package com.maro.common.util;

import com.maro.platform.core.util.ContextHolderUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.pojo.base.TSType;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Util {
	
	//用户角色的code(子煊管理员)
	public final static String ROLE_CODE = "maro_admin";
	
	/**
	 * 通过Map<需要处理的对象的属性,字典code> 来获取对象的字典值，并存储到该对象对应的属性+String的属性中去
	 * @param obj 需要处理的对象，可以死数组
	 * @param typeAndField eg <"type","maro_seat_type"> 意思是根据对象的type值去maro_seat_type字典中去找对应的实际值，并存放入typeString字段中去
	 * @author gongdaohai
	 * @since v1.0,2018年4月13日
	 * @version
	 */
	public static void getRealValue(Object obj,Map<String,String> typeAndField){
		if(obj instanceof List){
			for(Object o:((List)obj)){
				convert(typeAndField, o);
			}
		}else{
			convert(typeAndField, obj);
		}
	}
	/**
	 * 转化
	 * @param typeAndField
	 * @param o
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @author gongdaohai
	 * @since v1.0,2018年4月13日
	 * @version
	 */
	private static void convert(Map<String, String> typeAndField, Object o){
		try {
			for (String str : typeAndField.keySet()) {
				String type=typeAndField.get(str);
				Method getMethod = o.getClass().getMethod("get"+str.substring(0,1).toUpperCase()+str.substring(1));
				Method setMethod = o.getClass().getMethod("set"+str.substring(0,1).toUpperCase()+str.substring(1)+"String",String.class);
				Object fieldValue = getMethod.invoke(o);
				setMethod.invoke(o, getValueFromTypeByTypeCodeAndKey(type, String.valueOf(fieldValue)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过数据字典的code和key值获取数据字典的value
	 * 
	 * @param code
	 * @param key
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	public static String getValueFromTypeByTypeCodeAndKey(String code,
			String key) {
		List<TSType> list = ResourceUtil.allTypes.get(code);
		for (TSType t : list) {
			if (t.getTypecode().toLowerCase().equals(key.toLowerCase())) {
				return t.getTypename();
			}
		}
		return "";
	}
	/**
	 * 通过key获取数据字典中的code为maro_message的value值
	 * @param key
	 * @return
	 * @author gongdaohai
	 * @since v1.0 2018年3月29日
	 */
	public static String getMessageFromTypeByKey(String key) {
		List<TSType> list = ResourceUtil.allTypes.get("maro_message");
		for (TSType t : list) {
			if (t.getTypecode().toLowerCase().equals(key.toLowerCase())) {
				return t.getTypename();
			}
		}
		return "操作成功！";
	}
	/**
	 * 获取当天的起始时间
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年4月8日
	 * @version
	 */
	public static Date getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}
    /**
     * 获取当天的结束时间
     * @return
     * @author gongdaohai
     * @since v1.0,2018年4月8日
     * @version
     */
	public static Date getEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();
	}

	/**
	 * 获取当天前后几天的时间
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(int day) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.DATE,todayStart.get(Calendar.DATE)+day);
		return todayStart.getTime();
	}
	/**
	 * 判断是否有这个角色
	 * roleCodes 角色编码
	 * code     需要匹配的code
	 */
	public static boolean ifRoleCode(){
		//角色编码
		String roleCodes1 = (String)ContextHolderUtils.getSession().getAttribute("maroRoleCodes");
        String roleCodeArr[] = roleCodes1.split(",");
        boolean tf = false;
        for(int i=0;i<roleCodeArr.length;i++){
        	if(roleCodeArr[i].equals(ROLE_CODE)){
        		tf = true;
        	}
        }
        return tf;
	}
	/**
	 * @param message
	 * @param index
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月28日
	 * @version
	 */
	public static Object jsonToObject(String message,int index,Map<String, Class> classMap){
		try {
			//将json字符串转换为json对象
			JSONObject jSONObject = JSONObject.fromObject(message);
			//获取参数
			String argsName = jSONObject.get("argsname").toString();
			//分割成数组
			String[] argsNames = argsName.split(";");
			//获取实体jSONArray对象
			JSONArray jSONArray = (JSONArray)jSONObject.get("body");
			String args = argsNames[index];
			if(args.startsWith("list,")){
				//实例化参数
				String string = args.split(",")[1];
				Object argClass = Class.forName(string).newInstance();
				JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
				List<Object> o=JSONArray.toList((JSONArray)jSONArray.get(index), argClass.getClass(),classMap);
				return o;
			}else if(args.equals("java.lang.String")){
				return  jSONArray.get(index);
			}else if(args.equals("java.lang.Integer")){
				return  jSONArray.get(index);
			}else if(args.equals("java.util.Date")){
				return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONArray.get(index).toString());
			}else{
				//实例化参数
				Object argClass = Class.forName(args).newInstance();
				Object object = jSONArray.get(index);
				JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd HH:mm:ss"}) );
				Object o=JSONObject.toBean((JSONObject)object, argClass.getClass(),classMap);
				return o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *
	 * @param fileName 文件名
	 * @param data 数据
	 */
	public static void writeToFile(String fileName,String data){
		File file=new File(fileName);
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file,true);
			// 向文件写入内容
			writer.write(data);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 时间字符串转时间戳
	 * @param date_str
	 * @param format
	 * @return
	 */
	public static String date2TimeStamp(String date_str,String format){
		 try {
				 SimpleDateFormat sdf = new SimpleDateFormat(format);
				 return String.valueOf(sdf.parse(date_str).getTime()/1000);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 return "";
	}

	/**
	 * 时间转时间戳
	 * @param date_str
	 * @param format
	 * @return
	 */
	public static String date2TimeStamp(Date date_str,String format){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return String.valueOf(date_str.getTime()/1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 时间转时间字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2TimeStr(Date date,String format){
		try {
			SimpleDateFormat formatter=new SimpleDateFormat(format);
			return formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		Date dateBefore = getDateBefore(5);
		System.out.println(date2TimeStr(dateBefore,"yyyy-MM-dd HH:mm:ss"));
		//String s="{\"body\":[{\"area\":\"1\",\"bpmStatus\":null,\"createBy\":null,\"createDate\":null,\"createName\":null,\"deleteFlag\":null,\"departId\":\"2c92631b640ce8f901640d2231fd0009\",\"equipmentNumber\":\"Fn38IIt7auHWRkaW1525664012\",\"id\":\"32c4e41832bf4e8d8bb85e1c698d6fca\",\"introduce\":\"\",\"la\":\"\",\"lo\":\"\",\"mail\":\"\",\"name\":\"成都青羊光华店\",\"number\":\"0001\",\"openTime\":null,\"perConsume\":\"\",\"phone\":\"13111111111\",\"picture\":\"\",\"position\":\"成都中坝站\",\"shopInfo\":\"\",\"sysCompanyCode\":null,\"sysOrgCode\":null,\"type\":1,\"updateBy\":null,\"updateDate\":null,\"updateName\":null,\"workTime\":\"\"},[{\"bpmStatus\":\"1\",\"createBy\":\"helulin\",\"createDate\":\"2018-07-16 13:59:03\",\"createName\":\"何露琳\",\"deleteFlag\":null,\"flag\":\"0069\",\"id\":\"0048238698b841b385764a0e5993504c\",\"lateOperatinId\":\"\",\"name\":\"69\",\"number\":90,\"shopId\":null,\"sysCompanyCode\":\"A05\",\"sysOrgCode\":\"A05A01\",\"type\":4,\"typeString\":null,\"updateBy\":\"admin\",\"updateDate\":\"2018-07-23 09:30:03\",\"updateName\":\"管理员\"},{\"bpmStatus\":\"1\",\"createBy\":\"helulin\",\"createDate\":\"2018-07-16 13:59:03\",\"createName\":\"何露琳\",\"deleteFlag\":null,\"flag\":\"0048\",\"id\":\"ffa73fa9c6d24756932926007c48577d\",\"lateOperatinId\":\"\",\"name\":\"48\",\"number\":10,\"shopId\":null,\"sysCompanyCode\":\"A05\",\"sysOrgCode\":\"A05A01\",\"type\":4,\"typeString\":null,\"updateBy\":\"admin\",\"updateDate\":\"2018-07-23 09:28:52\",\"updateName\":\"管理员\"}]],\"argsname\":\"com.maro.common.shop.pojo.entity.MaroShopEntity;list,com.maro.common.shop.pojo.entity.MaroShopSeatEntity\"}";
		//jsonToObject(s,1,null);
	}
	public static Object jsonToObject(String message,int index){
		return jsonToObject(message, index, null);
	}
}
