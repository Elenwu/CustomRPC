package com.rpc.protocol;

import com.rpc.common.Invocation;
import com.rpc.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author:吴照保
 * @Description:用不同的handler处理不同的请求类似过滤器责任链
 * @date:2023/2/20 23:15
 **/
public class HttpServerHandler {
    public void handler (HttpServletRequest req, HttpServletResponse resp)  {
           //处理请求——>接口、方法、方法参数
        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();
            String interfaceName = invocation.getInterfaceName();
            //获取对应要处理请求的类
            Class classImpl = LocalRegister.get(interfaceName);
            //通过反射获取实现类的方法
            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParametersTypes());
            String result= (String) method.invoke(classImpl.newInstance(), invocation.getParameters());
            IOUtils.write(result, resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
