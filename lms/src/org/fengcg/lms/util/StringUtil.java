/**
 * 
 */
package org.fengcg.lms.util;

/**
 * @author ·ë³É¹û
 * @time ÏÂÎç04:56:39
 * @description 
 */
public class StringUtil {

	public static final String GET_STR = "get";
	public static final String SET_STR = "set";
	
	public String caseFirstCharUpperCase(String pmname){
		if(pmname == null || pmname.length() == 0){
			throw new RuntimeException("argument is null or is length");
		}
		char[] chars = pmname.toCharArray();
		char newch = Character.toUpperCase(chars[0]);
		chars[0] = newch;
		String newname = new String(chars);
		return newname;
	}
	
	public String buildGetMethodName(String methodName){
		String mtnm = caseFirstCharUpperCase(methodName);
		return GET_STR + mtnm;
	}
	public String buildSetMethodName(String methodName){
		String mtnm = caseFirstCharUpperCase(methodName);
		return SET_STR + mtnm;
	}
	
	public String array2str(String[] array){
		StringBuffer bf = new StringBuffer();
		for(String item : array){
			bf.append(item);
			bf.append(",");
		}
		;
		return bf.substring(0,bf.length() - 1).toString();
	}
	
}
