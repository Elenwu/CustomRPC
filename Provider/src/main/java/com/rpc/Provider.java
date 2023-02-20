package com.rpc;

import com.rpc.protocol.HttpServer;
import com.rpc.register.LocalRegister;

/**
 * @author:吴照保
 * @Description:
 * @date:2023/2/20 22:48
 **/
public class Provider {
    public static void main(String[] args) {
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);
    }
}
              