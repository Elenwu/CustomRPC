package com.rpc.protocol;

import com.rpc.common.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author:吴照保
 * @Description:
 * @date:2023/2/20 23:44
 **/
public class HttpClient {
    public String send(String hostname, Integer port, Invocation invocation){
        //用户配置
        try {
            URL url =  new URL("http",hostname,port,"/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            //配置
            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            String result = IOUtils.toString(inputStream);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
