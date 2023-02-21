package com.rpc.proxy;

import com.rpc.common.Invocation;
import com.rpc.protocol.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:吴照保
 * @Description:
 * @date:2023/2/21 23:00
 **/
public class ProxyFactory {
    /*
    通过动态代理返回对应的接口对象
     */
    public static <T> T getProxy(Class interfaceClass){
        //读取用户的配置（想要用什么实现动态代理）
        //使用jdk的动态代理
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation((interfaceClass.getName()),method.getName(),
                        method.getParameterTypes(),args);
                HttpClient httpClient = new HttpClient();
                String result = httpClient.send("localhost", 8080, invocation);
                return result;
            }
        });
        return (T)proxyInstance;
    }
}
