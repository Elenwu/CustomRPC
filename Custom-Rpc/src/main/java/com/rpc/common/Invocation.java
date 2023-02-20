package com.rpc.common;

import java.io.Serializable;

/**
 * @author:吴照保
 * @Description:统一接收对象
 * @date:2023/2/20 23:18
 **/
public class Invocation implements Serializable {
    private String interfaceName;//哪个接口
    private String methodName;//哪个方法
    private Class[] parametersTypes;//方法参数类型
    private Object[] parameters;//具体参数

    public Invocation(String interfaceName, String methodName, Class[] parametersTypes, Object[] parameters) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.parametersTypes = parametersTypes;
        this.parameters = parameters;
    }

    public Invocation() {
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParametersTypes() {
        return parametersTypes;
    }

    public void setParametersTypes(Class[] parametersTypes) {
        this.parametersTypes = parametersTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
