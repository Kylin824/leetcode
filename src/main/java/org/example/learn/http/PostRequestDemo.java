package org.example.learn.http;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PostRequestDemo {

    /**
     * 请求体类型
     */
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    /**
     * 私钥
     */
    public static final String API_KEY = "42a4421288d5a3a86cf78ad3bd121bbf";

    /**
     * 公钥
     */
    public static final String API_UUID = "b46c1494ab181b6744ad50521dca8549";


    /**
     * Http请求共通方法
     *
     * @param requestStr 请求参数
     * @param url        请求地址
     * @return 请求结果
     */
    public static String postRequest(String requestStr, String url) throws IOException, NoSuchAlgorithmException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse(CONTENT_TYPE);
        String sign = signLocal(requestStr);
        RequestBody body = RequestBody.create(mediaType, "apiUuid=" + API_UUID + "&requestStr=" + requestStr + "&sign=" + sign);
        okhttp3.Request request = new Request.Builder().url(url).method("POST", body)
                .addHeader("Content-Type", CONTENT_TYPE).build();
        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 本地计算签名逻辑
     *
     * @param requestStr 请求参数
     * @return 签名
     */
    private static String signLocal(String requestStr) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = messageDigest.digest((API_KEY + requestStr).getBytes("UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hex.toUpperCase());
        }
        return stringBuffer.toString();
    }

}
