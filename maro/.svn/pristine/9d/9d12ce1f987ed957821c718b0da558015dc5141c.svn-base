package com.maro.common.listener;

import com.alibaba.fastjson.JSONObject;
import com.maro.common.util.Util;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.util.ApplicationContextUtil;
import com.maro.platform.web.system.service.SystemService;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
/**
 * 监听服务器的MQ
 * @see
 * @since v1.0, 2018年5月22日
 * @author gongdaohai
 *
 */
public class MqServerListener implements ServletContextListener {
	private static boolean isInit=false;
	private static String SESSIONID=null;
	private static ApplicationContext applicationContext;
	private static Connection connection=null;
	private static Channel channel=null;
	public static String HOST = null;
	public static Integer PORT = null;
	public static String USER = null;
	public static String PASS = null;
	public static String SERVERPATH = null;
	public static String LOCALPATH = null;
	public static String SUSERNAME = null;
	public static String SPASSWORD = null;
	public static String LUSERNAME = null;
	public static String LPASSWORD = null;
	public static String CONTROLLERNAME = "controllername";
	public static String METHODNAME = "methodname";
	public static String LISTENERQUEUENAME = null;
	static {
		// 读取src目录下的rabbitmq.properties文件
		ResourceBundle resource = ResourceBundle.getBundle("rabbitmq");
		HOST = resource.getString("rabbitmq.shost");
		PORT = Integer.valueOf(resource.getString("rabbitmq.sport"));
		USER = resource.getString("rabbitmq.susername");
		PASS = resource.getString("rabbitmq.spassword");
		SERVERPATH = resource.getString("server.serverpath");
		SUSERNAME = resource.getString("server.username");
		SPASSWORD = resource.getString("server.password");
		LOCALPATH = resource.getString("local.serverpath");
		LUSERNAME = resource.getString("local.username");
		LPASSWORD = resource.getString("local.password");
		LISTENERQUEUENAME = resource.getString("rabbitmq.listenerqueuename");
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

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//获取spring上下文！
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		try {
			if(LISTENERQUEUENAME==null||LISTENERQUEUENAME.equals("")){
				//获取需要监听的队列名
				SystemService systemService = ApplicationContextUtil.getContext().getBean(SystemService.class);
				List<Object> listbySql = systemService.findListbySql("select t.org_code orgcode from t_s_depart t where t.or_not_store='Y'");
				if(listbySql!=null&&listbySql.size()==1){
					LISTENERQUEUENAME=listbySql.get(0).toString();
					//服务端认证
					if(approveUser(SERVERPATH)){
						//监听MQ
						listenMQ();
					}else{
						System.out.println("服务器用户认证失败！");
					}
				}else if(listbySql!=null&&listbySql.size()>1){
					System.out.println("本地店铺有多个！无法进行队列监听！");
				}
			}else{
				//服务端认证
				if(approveUser(SERVERPATH)){
					//监听MQ
					listenMQ();
				}else{
					System.out.println("服务器用户认证失败！");
				}
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//关闭频道和连接
		if(channel!=null&&channel.isOpen()){
			try {
				channel.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(connection!=null&&connection.isOpen()){
					try {
						connection.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	// 监听MQ消息并处理
	public static void listenMQ() throws Exception {
		if(isInit) return;
		// 获取连接
		connection = getConnection();
		// 获取频道
		channel = connection.createChannel();
		//那如果接收一个消息，但是没有应答，则客户端不会收到下一个消息
		channel.basicQos(0, 1, false);
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope,
									   BasicProperties properties, byte[] body) throws IOException {
				boolean result=invoke(properties, body);
				if(true){//每个操作都手动确定成功消费，但是将操作失败的数据记录在文件中
					//手动确认消息已成功消费
					channel.basicAck(envelope.getDeliveryTag(), false);
				}else{
					//消息退回
					channel.basicReject(envelope.getDeliveryTag(), true);
					try {
						Thread.sleep(1000*5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//第二个参数设置是否自动确认消息已消费，true为自动确认，false为手动确认
		channel.basicConsume(LISTENERQUEUENAME, false, consumer);
		//设置已进行初始化
		isInit=true;
	}

	/**
	 * 通过post请求调用本地的方法
	 * @param properties
	 * @param body
	 * @throws Exception
	 * @author gongdaohai
	 * @since v1.0,2018年5月17日
	 * @version
	 */
	private static boolean invoke(BasicProperties properties, byte[] body){
		boolean trn=true;
		String message=null;
		try{
			//获取controller名称
			String controllerName = properties.getHeaders().get(CONTROLLERNAME).toString();
			//获取方法名称
			String methodName = properties.getHeaders().get(METHODNAME).toString();
			//获取消息内容
			message = new String(body, "UTF-8");
			//转码特殊符号
			message=message.replaceAll(Matcher.quoteReplacement("&"),Matcher.quoteReplacement("!@7#$"));
			//POST请求数据
			String result= sendPost(LOCALPATH,controllerName+".do?"+methodName,"fromPath=fromMQ&message="+message,SESSIONID);
			if(result.startsWith("<!DOCTYPE")||result.startsWith("<html><head>")){//未登录
				if(approveUser(LOCALPATH)){
					result= sendPost(LOCALPATH,controllerName+".do?"+methodName,"fromPath=fromMQ&message="+message,SESSIONID);
				}else{
					System.out.println("本地用户认证失败！");
					return false;
				}
			}
			AjaxJson ajaxJson = JSONObject.toJavaObject(JSONObject.parseObject(result), AjaxJson.class);
			if(ajaxJson.isSuccess()){
				System.out.println(ajaxJson.getMsg());
			}else{
				System.out.println(ajaxJson.getMsg());
				trn=false;
				//将错误信息记录
				Util.writeToFile("C:/error.text",message+"\r\n");
			}
		}catch (Exception e){
			e.printStackTrace();
			trn=false;
			//将错误信息记录
			Util.writeToFile("C:/error.text",message+"\r\n");
		}
		return trn;
	}

	/**
	 * 向指定 URL 发送POST方法的请求，返回的数据为AjaxJson的数据格式，
	 * 当json.getSuccess()为true时，表名处理成功，为false时表示处理失败
	 * @param webPath 项目路径 eg:http://193.112.42.207:8091/jeecg/
	 * @param url 发送请求的 URL eg：mqController.do?saveServerorder
	 * @param param 请求参数，请求参数应该是 message=*** 的形式。
	 * @param sessionId
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String webPath,String url, String param,String sessionId) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(webPath+url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			if(sessionId!=null){
				conn.setRequestProperty("Cookie", "JSESSIONID="+sessionId);
			}
			// 1.获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
			AjaxJson json=new AjaxJson();
			json.setSuccess(false);
			json.setMsg("发送 POST 请求出现异常");
			result=JSONObject.toJSON(json).toString();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
				AjaxJson json=new AjaxJson();
				json.setSuccess(false);
				json.setMsg("发送 POST 请求出现异常");
				result=JSONObject.toJSON(json).toString();
			}
		}
		return result;
	}
	/**
	 * 用户认证，返回sessionid
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月22日
	 * @version
	 */
	private static boolean approveUser(String webPath){
		boolean result=true;
		String tunStr="";
		try{
			if(webPath.equals(SERVERPATH)){
				tunStr= sendPost(webPath,"utilController.do?approveUser","userName="+SUSERNAME+"&password="+SPASSWORD,null);
			}else{
				tunStr= sendPost(webPath,"utilController.do?approveUser","userName="+LUSERNAME+"&password="+LPASSWORD,null);
			}
			AjaxJson ajaxJson = JSONObject.toJavaObject(JSONObject.parseObject(tunStr), AjaxJson.class);
			if(ajaxJson.isSuccess()){
				SESSIONID=ajaxJson.getObj().toString();
			}else{
				SESSIONID=null;
				result=false;
			}
		}catch (Exception e){
			e.printStackTrace();
			result=false;
		}
		return result;
	}
}
