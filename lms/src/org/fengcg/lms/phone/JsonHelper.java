package org.fengcg.lms.phone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.fengcg.lms.util.StringUtil;
import org.fengcg.lms.vo.User;
import org.fengcg.lms.vo.UserExp;

/**
 * @author 冯成果
 * @date 2016-4-18
 * @time 下午02:27:55
 */
public class JsonHelper {
	
	private StringUtil strUtil = new StringUtil();
	
	private Object getValue(Object obj,String key){
		Object value = null;
		try {
			if(key.contains(".")){
				int index = key.indexOf(".");
				String tmp_key = key.substring(0,index);
				tmp_key = strUtil.buildGetMethodName(tmp_key);
				Method method = obj.getClass().getMethod(tmp_key);
				Object tmp_obj = method.invoke(obj);
				return getValue(tmp_obj, key.substring(index+1));
			}else{
				key = strUtil.buildGetMethodName(key);
				Method method = obj.getClass().getMethod(key);
				value = method.invoke(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	public String buildJson(Object obj,String[] keys,String[] newkeys){
		Object[] values = new Object[keys.length];
		for(int i=0;i<keys.length;i++){
			String key = keys[i];
			values[i] = getValue(obj,key);
		}
		return buildJson(newkeys,values);
	}
	
	public String buildJson(Object obj,String[] keys){
		Object[] values = new Object[keys.length];
		for(int i=0;i<keys.length;i++){
			String key = keys[i];
			values[i] = getValue(obj,key);
		}
		return buildJson(keys,values);
	}
	
	public String buildJson(String[] keys,Object[] values){
		StringBuffer json = new StringBuffer();
		for(int i=0;i<keys.length;i++){
			json.append("\""+keys[i]+"\"");
			json.append(":");
			json.append("\""+values[i]+"\"");
			json.append(",");
		}
		String rsjson = "{" + json.toString().substring(0,json.length()-1) + "}";
		return rsjson;
	}
	
	public String buildJson(String json,boolean issuccess){
		StringBuffer js = new StringBuffer();
		if(issuccess){
			js.append("{\"code\":\"200\",\"message\":\"操作成功\",\"data\":").append(json).append("}");
		}else{
			js.append("{\"code\":\"999\",\"message\":\"操作失败\",\"data\":").append(json).append("}");
		}
		return js.toString();
	}
	
	public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		JsonHelper helper = new JsonHelper();
//		User u = new  User();
//		u.setId(1);
//		u.setUserName("feng");
//		u.setUserExp(new UserExp());
//		u.getUserExp().setAddress("中国");
//		u.getUserExp().setCode("11111111111111");
//		u.getUserExp().setRealName("冯成果");
//		String value = helper.buildJson(u,new String[]{"id","userName","userExp.code","userExp.realName","userExp.address"},true);
		List<User> us = new ArrayList<User>();
		for(int i=0;i<10;i++){
			User u = new  User();
			u.setId(i);
			u.setUserName("userName" + i);
			u.setUserExp(new UserExp());
			u.getUserExp().setAddress("address" + i);
			u.getUserExp().setCode("code" + i);
			u.getUserExp().setRealName("realname" + i);
			us.add(u);
		}
		
		String value = helper.buildJSONList(us,"users",new String[]{"id","userName","userExp.code","userExp.realName","userExp.address"},new String[]{"id","userName","code","realName","address"});
		
		System.out.println(value);
	}
	
	public String buildJSONList(List<?> list,String listname,String[] keys){
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\""+listname + "\":[");
		for(int i=0;i<list.size();i++){
			Object obj = list.get(i);
			String tmp_js = buildJson(obj,keys);
			json.append(tmp_js);
			if(i < list.size() - 1){
				json.append(",");
			}
		}
		json.append("]");
		json.append("}");
		return json.toString();
	}
	
	public String buildJSONList(List<?> list,String listname,String[] keys,String[] newKeys){
		StringBuffer json = new StringBuffer();
		json.append("{");
		json.append("\""+listname + "\":[");
		for(int i=0;i<list.size();i++){
			Object obj = list.get(i);
			String tmp_js = buildJson(obj,keys,newKeys);
			json.append(tmp_js);
			if(i < list.size() - 1){
				json.append(",");
			}
		}
		json.append("]");
		json.append("}");
		return json.toString();
	}
}
