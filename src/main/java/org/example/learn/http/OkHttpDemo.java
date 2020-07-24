package org.example.learn.http;

import okhttp3.*;

import java.io.IOException;

public class OkHttpDemo {

    // guidance: https://square.github.io/okhttp/


    OkHttpClient client = new OkHttpClient();

    String BASE_URL = "xxx";

    public void synchronousGetRequest() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/date")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.code());
    }

    public void synchronousPostRequest() throws IOException {
        String json = "{a:aaa}";
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(BASE_URL + "/date")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.code());
    }

    public void whenAsynchronousGetRequest_thenCorrect() {
        Request request = new Request.Builder()
                .url(BASE_URL + "/date")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {
                // ...
            }

            public void onFailure(Call call, IOException e) {
                //fail();
            }
        });
    }

    public void whenGetRequestWithQueryParameter_thenCorrect() throws IOException {

        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(BASE_URL + "/ex/bars").newBuilder();
        urlBuilder.addQueryParameter("id", "1");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
    }

    public void whenSendPostRequest_thenCorrect() throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("username", "test")
                .add("password", "test")
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/users")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

    }
}
