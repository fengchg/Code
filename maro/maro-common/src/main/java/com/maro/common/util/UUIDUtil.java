package com.maro.common.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

/**
 * 给实体id自动生成32位uuid
 * @see
 * @since v1.0, 2018年5月16日
 * @author gongdaohai
 *
 */
public class UUIDUtil {
	/**
	 * 给实体id自动生成32位uuid
	 * @param entitys 实体对象，可以为List集合对象
	 * @author gongdaohai
	 * @since v1.0,2018年5月16日
	 * @version
	 */
	public static void setId(Object ... entitys){
		for(Object o:entitys){
			if(o instanceof List){
				for(Object entity:(List)o){
					try {
						Method getIdMethod = entity.getClass().getDeclaredMethod("getId");
						String id=(String)getIdMethod.invoke(entity);
						if(id==null||id.equals("")){
							Method setIdMethod = entity.getClass().getDeclaredMethod("setId", String.class);
							setIdMethod.invoke(entity, uuid());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
					}
				}
			}else{
				try {
					Method setIdMethod = o.getClass().getDeclaredMethod("setId", String.class);
					setIdMethod.invoke(o, uuid());
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
		}
	}
	/**
	 * 生成32位uuid
	 * @return
	 * @author gongdaohai
	 * @since v1.0,2018年5月16日
	 * @version
	 */
	private static String uuid(){
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
}
