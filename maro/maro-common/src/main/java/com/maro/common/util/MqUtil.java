package com.maro.common.util;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 对rebitMq进行操作的工具类
 * 
 * @see
 * @since v1.0, 2018年5月14日
 * @author gongdaohai
 *
 */
public class MqUtil {
	public static String HOST = null;
	public static Integer PORT = null;
	public static String USER = null;
	public static String PASS = null;
	public static boolean SEND = false;
	public static Connection connection = null;
	static {
		// 读取src目录下的rabbitmq.properties文件
		ResourceBundle resource = ResourceBundle.getBundle("rabbitmq");
		HOST = resource.getString("rabbitmq.shost");
		PORT = Integer.valueOf(resource.getString("rabbitmq.sport"));
		USER = resource.getString("rabbitmq.susername");
		PASS = resource.getString("rabbitmq.spassword");
		//是否需要发送数据至MQ，对于客户端来说，无需发送数据，所以也就不需要获取mq的配置信息了
		SEND = resource.getString("rabbitmq.send").equals("true")?true:false;
	}
	// 获取MQ连接
	private static Connection getConnection() throws Exception {
		if (connection == null||!connection.isOpen()) {
			// 定义一个链接工厂
			ConnectionFactory factory = new ConnectionFactory();
			// 设置服务地址,IP,端口,账号密码信息
			factory.setHost(HOST);
			factory.setUsername(USER);
			factory.setPassword(PASS);
			factory.setPort(PORT);
			// 关键所在，指定线程池
			ExecutorService service = Executors.newFixedThreadPool(10);
			factory.setSharedExecutor(service);
			// 设置自动恢复
			factory.setAutomaticRecoveryEnabled(true);
			factory.setNetworkRecoveryInterval(10*1000);// 设置 没10s ，重试一次
			factory.setTopologyRecoveryEnabled(false);// 设置不重新声明交换器，队列等信息。
			connection = factory.newConnection();
		}
		return connection;
	}
	// 获取发送MQ频道
	private static Channel getChannel() throws Exception {
		// 获取连接
		Connection connection = getConnection();
		// 获取频道
		Channel channel = connection.createChannel();
		// 返回
		return channel;
	}
	/**
	 * 发送消息给MQ
	 * @param queueName 队列名称，为null发送给FONOUTEXCHANGE路由绑定的所有队列，不为null发送给指定的队列
	 * @param objs
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月21日
	 * @version
	 */
	public static boolean sendEntity(String queueName,Object ... objs) {
		return remoteOpt(queueName,"mqController","saveEntity",objs);
	}
	/**
	 * 将实体对象转化成json格式数据传给MQ
	 * @param obj 实体对象
	 * @param channel 频道对象
	 * @param tableName 频道对象
	 * @throws IOException
	 * @author gongdaohai
	 * @since v1.0,2018年5月16日
	 * @version
	 */
	public static boolean sendTableData(String queueName,String tableName,Object obj) throws IOException{
		return remoteOpt(queueName,"mqController","insertData",tableName,obj);
	}

	public static boolean deleteTableData(String queueName, String tableName, List ids) throws IOException{
		return remoteOpt(queueName,"mqController","deleteData",tableName,ids);
	}
	/**
	 * 远程操作
	 * @param queueName 队列名称，为null发送给FONOUTEXCHANGE路由绑定的所有队列，不为null发送给指定的队列
	 * @param controllerName controller名称
	 * @param methodName 方法名称
	 * @param args 方法的参数集合
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月17日
	 * @version
	 */
	public static boolean remoteOpt(String queueName,String controllerName,String methodName,Object ... args) {
		if(!SEND) return true;//不允许同步直接返回
		boolean isMqUser=false;
		boolean result = true;
		if(!isMqUser){
			Channel channel=null;
			try {
				channel = getChannel();
				Map headers=new HashMap();
				headers.put(MqConstant.CONTROLLERNAME, controllerName);
				headers.put(MqConstant.METHODNAME, methodName);
				Builder builder = new BasicProperties.Builder();
				builder.headers(headers);
				BasicProperties build = builder.build();
				Map body=new HashMap();
				StringBuffer argsname=new StringBuffer();
				for(Object o:args){
					if(o instanceof List){
						argsname.append("list,"+((List)o).get(0).getClass().getName()+";");
					}else{
						argsname.append(o.getClass().getName()+";");
					}
				}
				if(argsname.length()>0){
					body.put(MqConstant.ARGSNAME, argsname.substring(0, argsname.length()-1));
				}else{
					body.put(MqConstant.ARGSNAME, "");
				}
				body.put(MqConstant.BODY, args);
				String jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(body, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
				if(queueName!=null){
					channel.basicPublish(MqConstant.DIRECTEXCHANGE, queueName, false, build,jsonStr.getBytes("UTF-8"));
				}else{
					channel.basicPublish(MqConstant.FONOUTEXCHANGE, "", false, build,jsonStr.getBytes("UTF-8"));
				}
			} catch (Exception e) {
				// TODO: handle exception
				result = false;
				if(connection!=null&&connection.isOpen()){
					try {
						connection.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}finally{
				if(channel!=null&&channel.isOpen()){
					try {
						channel.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}
		}
		return result;
	}
	/**
	 * 初始化Mq，建立一个队列并将routkey和队列名保持一致
	 * @param queueName 队列名
	 * @throws Exception
	 * @author gongdaohai
	 * @since v1.0,2018年5月21日
	 * @version
	 */
	public static void initClientMq(String queueName) throws Exception{
		// 获取连接
		Connection connection = getConnection();
		// 获取频道
		Channel channel = connection.createChannel();
		// 声明一个fanout模式的交换机,消息会发送给所有绑定的队列
		channel.exchangeDeclare(MqConstant.FONOUTEXCHANGE, MqConstant.FONOUTTYPE);
		// 声明一个dirent模式的交换机,根据routekey路由到指定的队列
		channel.exchangeDeclare(MqConstant.DIRECTEXCHANGE, MqConstant.DIRECTTYPE, true);
		// 声明一个持久化的队列,第二个参数设置为true，会将消息持久化到磁盘，第四个参数设置为true表示没有消息并且没有连接则删除改队列，详情可以查一下API
		channel.queueDeclare(queueName, true, false, false, null);
		// 将绑定到该交换机
		channel.queueBind(queueName, MqConstant.DIRECTEXCHANGE, queueName);
		// 将绑定到该交换机
		channel.queueBind(queueName, MqConstant.FONOUTEXCHANGE, queueName);
		//关闭chanel
		channel.close();
		//关闭连接
		connection.close();
	}

}
