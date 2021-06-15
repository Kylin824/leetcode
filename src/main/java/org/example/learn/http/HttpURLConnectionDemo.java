package org.example.learn.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpURLConnectionDemo {

    /**
     * 优点：JDK 自带，不需引入额外依赖
     * 缺点：使用起来非常繁琐，也缺乏连接池管理、域名机械控制等特性支持，不支持http2.0
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        String urlString = "https://httpbin.org/post";
        String bodyString = "password=123";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // 通过HttpURLConnection对象获取到输出流，然后把要发送的内容发送出去
        OutputStream os = conn.getOutputStream();
        os.write(bodyString.getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.close(); // 此时http请求还未真正发送出去

        // HTTP请求实际上直到我们获取服务器响应数据（如调用getInputStream()、getResponseCode()等方法）时才正式发送出去。
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            // 通过输入流读取到服务器端响应的内容
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("响应内容:" + sb.toString());
        } else {
            System.out.println("响应码:" + conn.getResponseCode());
        }
    }
}
