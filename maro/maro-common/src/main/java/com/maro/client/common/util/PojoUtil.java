package com.maro.client.common.util;


import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.annotation.TimeFieldDescription;
import com.maro.client.common.constant.StringConstant;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.util.DateUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * PojoUtil是一个针对pojo(do、vo、dto)类对象进行处理的工具类，这里提供了常用的方法对pojo类对象进行处理，比如DO对象转换成
 * VO对象
 * @author 冯成果
 * @date 2018-4-2
 * @since 00.01.0001
*/
public class PojoUtil {


    static final String GET ="get";
    static final String SET = "set";


    /**
     * 根据传入的第一个参数DO对象，转换成传入的第二个参数VO对象
     * @param srcEntity,待转换DO
     * @param targetVOClass ，目标对象的Cass对象
     * @author 冯成果
     * @since 01.00.0001
     * @version 版本 由【冯成果】于【2018-04-02】进行添加
     */
    public static <T> T convertDO2VO(Object srcEntity, Class<T> targetVOClass){
        T targetVO = null;
        try {
            targetVO = targetVOClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //遍历srcEntity中所有的get方法，并放入以截取了字符后的方法名为key，方法对象为value放入到MAP中
        Map<String, Method> srcMethodMap = listMethodMap(srcEntity, GET);
        //遍历targetVO中所有的et方法，并放入以截取了sset字符后的方法名为key，方法对象为value放入到MAP中
        Map<String, Method> targetMethodMap = listMethodMap(targetVO, SET);

        // 遍历DO中所有的get方法，把每次遍历的方法和VO中的方法比较，如果方法的属性名一致（这里get方法没有get字符串，set
         // 方法没有set字符串），则先执行DO中的get方法获取DO中相应属性的返回值，然后通过把返回值当成参数，执行VO中对应的
         // set方法
         giveValue(srcEntity,targetVO,srcMethodMap,targetMethodMap);

        //初始化枚举描述字段值
        initEnumFieldValue(targetVO);
        //初始化时间字段描述字段值
        initTimeFiledValue(targetVO);

        return targetVO;

    }

    private static <T> void initTimeFiledValue(T targetVO) {
        Method[] methods = targetVO.getClass().getMethods();
        Map<String,Method> methodMap = new HashMap<String,Method>();
        for(int i=0;i<methods.length;i++){
            Method method = methods[i];
            TimeFieldDescription annotation = method.getAnnotation(TimeFieldDescription.class);
            if(annotation != null) {
                String timeField = annotation.timeFieldName();
                String pattern = annotation.pattern();
                String getMethodName = GET + timeField.substring(0, 1).toUpperCase() + timeField.substring(1);
                try{
                    Method getMethod = targetVO.getClass().getMethod(getMethodName);
                    if(getMethod != null){
                        Long value = (Long) getMethod.invoke(targetVO);
                        String timeString = DateUtils.formatDate(new Date(value), pattern);
                        method.invoke(targetVO,timeString);
                    }
                }catch (Exception e){

                }
            }
        }
    }

    private static <T> void initEnumFieldValue(T targetVO) {
        Method[] methods = targetVO.getClass().getMethods();
        Map<String,Method> methodMap = new HashMap<String,Method>();
        for(int i=0;i<methods.length;i++){
            Method method = methods[i];
            EnumDescription annotation = method.getAnnotation(EnumDescription.class);
            if(annotation != null) {
                Class clazz = annotation.targetEnum();
                String enumField = annotation.enumFieldName();
                String getMethodName = GET + enumField.substring(0, 1).toUpperCase() + enumField.substring(1);
                try{
                    Method getMethod = targetVO.getClass().getMethod(getMethodName);
                    if(getMethod != null){
                        Integer value = (Integer) getMethod.invoke(targetVO);
                        String name = EnumUtil.getName(clazz, value);
                        method.invoke(targetVO,name);
                    }
                }catch (Exception e){

                }
            }
        }
    }

    /**
     * 遍历DO中所有的get方法，把每次遍历的方法和VO中的方法比较，如果方法的属性名一致（这里get方法没有get字符串，set方法
     * 没有set字符串），则先执行DO中的get方法获取DO中相应属性的返回值，然后通过把返回值当成参数，执行VO中对应的set方法
     * @param srcEntity，源对象DO
     * @param targetVO ，目标对象VO
     * @param srcMethodMap，存放源对象get方法的map集合
     * @param targetMethodMap，存放目标对象set方法的map集合
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本 由【冯成果】于【2018-04-02】进行添加
     */
    private static void giveValue(Object srcEntity, Object targetVO, Map<String, Method> srcMethodMap, Map<String, Method> targetMethodMap) {
        Iterator<Map.Entry<String, Method>> it = srcMethodMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Method> row = it.next();
            String methodName = row.getKey();
            Method srcMethod = row.getValue();
            Method targetMethod = targetMethodMap.get(methodName);
            if(targetMethod != null){
                try {
                    Object returnObject = srcMethod.invoke(srcEntity);
                    targetMethod.invoke(targetVO,returnObject);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 筛选出object中所有的包含subMethodName方法，并放入以截取了subMethodName字符后的方法名为key，方法对象为value放入到MAP
     * 中比如Map<String,Method> map = listMethodMap(entity,GET);如果entity里面有getId的方法，则map里面存放的是id和getId的
     * 方法对象；再比如Map<String,Method> map = listMethodMap(entity,SET);如果entity里面有setName的方法，则map里面存放的
     * 是name和setName的方法对象。
     * @param object，待遍历对象
     * @param subMethodName，子方法字名称，这里只能是get或者set字符串。
     * @return Map<String,Method>，以截取掉特殊字符串（subMethodName）的方法名为key，方法对象为value的map集合。集合主要
     * 存放方法名存放对象中所有的，方法名称中包括subMethodName的方法。
     * @author 冯成果
     * @since 冯成果
     * @version 版本 由【冯成果】于【2018-04-02】进行添加
     */
    private static Map<String,Method> listMethodMap(Object object,String subMethodName){

//        Method[] methods = object.getClass().getDeclaredMethods();
        Method[] methods = object.getClass().getMethods();
        Map<String,Method> methodMap = new HashMap<String,Method>();
        for(int i=0;i<methods.length;i++){
            Method method = methods[i];
            if(method.getName().contains(subMethodName)){
                methodMap.put(method.getName().substring(subMethodName.length()),method);
            }
        }
        return methodMap;
    }

    /**
     * 批量根据传入的第一个参数DO对象集合，转换成传入的第二个参数VO对象集合
     * @param srcEntities,待转换DO对象集合
     * @param targetVOClass，目标VO对象集合
     * @author 冯成果
     * @since 01.00.0001
     * @version 版本 由【冯成果】于【2018-04-02】进行添加
     */
    public static <T> List<T> convertBatchDO2VO(List<? extends Object> srcEntities, Class<T> targetVOClass){
        List<T> list = new ArrayList<T>();
        for(int i=0;i<srcEntities.size();i++){
            Object srcEntity = srcEntities.get(i);
            T vo = convertDO2VO(srcEntity, targetVOClass);
            list.add(vo);
        }
        return list;
    }

    public static AjaxJson createAjaxJson(Boolean success,Object object){
        AjaxJson ajaxJson = new AjaxJson();
        if(success){
            ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        }else{
            ajaxJson.setMsg(StringConstant.TIP_FAIL);
        }
        ajaxJson.setSuccess(success);
        ajaxJson.setObj(object);
        return ajaxJson;
    }

}
