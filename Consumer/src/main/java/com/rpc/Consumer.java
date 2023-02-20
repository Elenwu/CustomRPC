package com.rpc;

import com.rpc.common.Invocation;
import com.rpc.protocol.HttpClient;

/**
 * @author:吴照保
 * @Description:
 * @date:2023/2/20 20:07
 **/
public class Consumer {
    public static void main(String[] args) {
        Invocation invocation = new Invocation((HelloService.class.getName()),"sayHello",
                new Class[]{String.class},new Object[]{"zhangsan"});
        HttpClient httpClient = new HttpClient();
        String result = httpClient.send("localhost", 8080, invocation);
        System.out.println(result);
    }
}
