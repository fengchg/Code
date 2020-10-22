package com.maro.client.common.util;

import com.maro.client.common.annotation.EnumSqlScript;
import com.maro.client.common.constant.enumconstant.ServerOrderStatusEnum;
import com.maro.platform.core.util.DateUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EnumUtil {


    final static String SQL_INSERT_GROUP = "INSERT INTO `t_s_typegroup` (`ID`, `typegroupcode`, `typegroupname`, `create_date`, `create_name`) VALUES ('%s', '%s', '%s', '%s', '管理员');";
    final static String SQL_INSERT_TYPE = "INSERT INTO `t_s_type` (`ID`, `typecode`, `typename`, `typepid`, `typegroupid`, `create_date`, `create_name`) VALUES ('%s', '%s', '%s', NULL, '%s', '%s', '管理员');";

    final static String SQL_DELETE_GROUP = "delete from t_s_typegroup where id = (select id from t_s_typegroup where typegroupcode = '%s');";
    final static String SQL_DELETE_TYPE = "delete from t_s_type where typegroupid = (select id from t_s_typegroup where typegroupid = '%s')";

    final static String fileName = "D:\\init-script.sql";
    final static String basePackgeName = "E:\\code\\workspace_main\\maro\\zixuan\\maro\\maro-client\\target\\classes\\";

    public static Map<Class,Map<Integer,String>> mapContainer = new HashMap<Class,Map<Integer,String>>();


    public static String getName(Class clazz,Integer code){
        String name = null;
        Map<Integer, String> map = mapContainer.get(clazz);
        if(map == null){
            Object[] enumConstants = clazz.getEnumConstants();
             map = new HashMap<>();
            for(int i=0;i<enumConstants.length;i++){
                Enum em = (Enum) enumConstants[i];
                int code1 = em.ordinal();
                String name1 = em.name();
                try {
                    code1 = (int) em.getClass().getDeclaredMethod("getCode").invoke(em);
                    name1 = (String) em.getClass().getDeclaredMethod("getName").invoke(em);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                map.put(code1,name1);
            }
            mapContainer.put(clazz,map);
        }
        name = map.get(code);
        if(name == null){
            name = "";
        }
        return name;
    }

    public static void createEnumSqlScript() throws IllegalAccessException, NoSuchMethodException {
        String packageName = ServerOrderStatusEnum.class.getResource("").getPath();

        File file = new File(packageName);
        File[] files = file.listFiles();
        String result = "";
        for(int i=0;i<files.length;i++) {
            String replace = files[i].getPath().replace(basePackgeName, "").replaceAll("\\\\",".").replace(".class","");
            try {
                Class<?> aClass = Class.forName(replace);
                EnumSqlScript annotation = aClass.getAnnotation(EnumSqlScript.class);
                String groupId = UUID.randomUUID().toString();
                String groupName = annotation.groupName();
                String group = annotation.group();
//                String deleteTypeSqlScript = buildDeleteTypeSqlScript(annotation.group());
                String typeSqlScript = buildTypeSqlScript(aClass,groupId,group,groupName);
                result += typeSqlScript;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        createSqlScriptFile(fileName,result);

    }

    private static String buildDeleteTypeSqlScript(String group) {
        String result = "";
        result += "\n"+String.format(SQL_DELETE_GROUP,group);
        result += "\n"+String.format(SQL_DELETE_TYPE,group);
        return result;
    }

    private static String buildTypeSqlScript(Class clazz,String groupId,String group,String groupName) {
        Object[] enumConstants = clazz.getEnumConstants();
        String result = "";
        result += "\n"+String.format(SQL_INSERT_GROUP,groupId,group,groupName, DateUtils.formatDateTime());
        for(int j=0;j<enumConstants.length;j++){
            Enum em = (Enum) enumConstants[j];
            int code1 = 0;
            String name1 = null;
            try {
                code1 = (int) em.getClass().getDeclaredMethod("getCode").invoke(em);
                name1 = (String) em.getClass().getDeclaredMethod("getName").invoke(em);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            String typeId = UUID.randomUUID().toString();
            result += "\n"+String.format(SQL_INSERT_TYPE,typeId,code1+"",name1,groupId,DateUtils.formatDateTime());
            result += "\n\n\n";
        }
        return result;
    }


    private static void createSqlScriptFile(String fileName,String result){
        File destFile = new File(fileName);
        if(!destFile.exists()){
            try {
                boolean newFile = destFile.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(destFile);
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write(result);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
