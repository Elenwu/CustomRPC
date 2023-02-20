package com.rpc;

/**
 * @author:吴照保
 * @Description:
 * @date:2023/2/20 20:05
 **/
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
