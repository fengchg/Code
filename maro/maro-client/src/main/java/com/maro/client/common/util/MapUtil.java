package com.maro.client.common.util;

import com.maro.common.util.MapUtilWare;

import java.util.*;

public class MapUtil<T> {

    private Map<String,Integer> map = new HashMap<String,Integer>();
    private List<List<T>> list = new ArrayList<List<T>>();
    private Integer index = new Integer(0);

    public void addElement(String key,T value){
        index = map.get(key);
        if(index == null){
            list.add(new ArrayList<T>());
            index = list.size() -1;
            map.put(key,index);
        }
        list.get(index).add(value);
    }

    public <T> List<T> listElement(Class<T> clz){
        List<T> returnList = new ArrayList<T>();
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entry.iterator();
        while(it.hasNext()){
            MapUtilWare mapUtilWare = null;
            try {
                mapUtilWare = (MapUtilWare) clz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Map.Entry<String, Integer> row = it.next();
            String key = row.getKey();
            Integer value = row.getValue();
            mapUtilWare.setValue(key,list.get(value));
            T ret = (T) mapUtilWare;
            returnList.add(ret);
        }
        return returnList;
    }

}
