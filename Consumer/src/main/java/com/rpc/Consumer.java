package com.rpc;

import com.rpc.common.Invocation;
import com.rpc.protocol.HttpClient;
import com.rpc.proxy.ProxyFactory;

/**
 * @author:吴照保
 * @Description:
 * @date:2023/2/20 20:07
 **/
public class Consumer {
    public static void main(String[] args) {
        //下面这种是通过构造参数去发起请求，然后实际中RPC需要像调用本地方法一样去调用远程方法
        /*Invocation invocation = new Invocation((HelloService.class.getName()),"sayHello",
                new Class[]{String.class},new Object[]{"zhangsan"});
        HttpClient httpClient = new HttpClient();
        String result = httpClient.send("localhost", 8080, invocation);
        System.out.println(result);*/
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String res = helloService.sayHello("张三");
        System.out.println(res);
    }
}
