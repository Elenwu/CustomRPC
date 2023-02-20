package com.rpc.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:吴照保
 * @Description:
 * @date:2023/2/20 23:27
 **/
public class LocalRegister {
    private static Map<String,Class> map = new HashMap<>();

    public static void register(String interfaceName, Class ImplClass){
        map.put(interfaceName,ImplClass);
    }
    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }
}
