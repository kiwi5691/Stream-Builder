package cn.stream.streambuilder.web.base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserCache {
    public static ConcurrentHashMap<String, Map<String, byte[]>> userClasses = new ConcurrentHashMap<>();

    public static Map<String, byte[]> getClasses(String serial){
        Optional<Map<String, byte[]>> optionalStringMap = Optional.ofNullable(userClasses.get(serial));
        return optionalStringMap.orElse(null);
    }
    public static void set(String serial,Map<String, byte[]> map,String className){
        if(getClasses(serial)!=null){
            Map<String, byte[]> tmap= getClasses(serial);
            tmap.put(className,map.get(className));
        }else {
        userClasses.put(serial,map);
        }
    }

}

