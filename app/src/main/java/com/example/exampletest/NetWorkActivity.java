package com.example.exampletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetWorkActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_async;
    private static final String TAG = "NetWorkActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);

        btn_async = findViewById(R.id.btn_async);
        btn_async.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_async:
                //访问网络
                Log.e(TAG, "onClick: " );
//                getNetWork();
//                getNetWork1();
//                getNetWork2();
                //post异步请求
                getNetWork4();
//                getNetWork3();
                break;
            default:
                break;
        }
    }
    //post异步请求
    private void getNetWork4() {
        //定义OkHttp
        OkHttpClient okHttpClient = new OkHttpClient();
        //定义请求体
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .post(body)
                .url("https://www.httpbin.org/post")
                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                String data = response.body().string();
//                Log.d(TAG, "onResponse: "+data);
//            }
//        });
    }

    private void getNetWork3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //定义OkHttp
                OkHttpClient okHttpClient = new OkHttpClient();
                //定义请求体
                RequestBody requestBody = new FormBody.Builder()
                        .add("a","1000")
                        .add("b","2000")
                        .build();
                try {
                    //执行OkHttp
                    Request request = new Request.Builder()
                            .post(requestBody)
                            .url("https://www.httpbin.org/post")
                            .build();
                    Call call = okHttpClient.newCall(request);
                    Response response = call.execute();
                    String data = response.body().string();
                    Log.d(TAG, "run: "+data);
//                    Response response = okHttpClient.newCall(request).execute();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }).start();
    }

    //post异步请求
    private void getNetWork2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //定义OkHttp
                OkHttpClient okHttpClient = new OkHttpClient();
                //定义请求体
                FormBody body = new FormBody.Builder().build();
                try {
                    //执行OkHttp
                    Request request = new Request.Builder()
                            .post(body)
                            .url("https://www.httpbin.org/post")
                            .build();
                    Response response = okHttpClient.newCall(request).execute();
                    //JSON字符串
                    String string = response.body().string();
                    Log.d(TAG, "run: "+string );
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //post同步请求
    private void getNetWork1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //定义OkHttp
                OkHttpClient okHttpClient = new OkHttpClient();
                //定义请求体
                FormBody body = new FormBody.Builder().build();
                try {
                    //执行OkHttp
                    Request request = new Request.Builder()
                            .post(body)
                            .url("https://www.httpbin.org/post")
                            .build();
                    Call call = okHttpClient.newCall(request);
                    Response response = call.execute();

//                    Response response = okHttpClient.newCall(request).execute();
                    String ss = response.body().string();
//                    Object fromJson = new Gson().fromJson(ss, new TypeToken<List<Student>>() {
//                    }.getType());
                    Log.e(TAG, "run: "+ss );
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    //post同步请求
    private void getNetWork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //定义OkHttp
                OkHttpClient okHttpClient = new OkHttpClient();

                FormBody formBody = new FormBody.Builder()
                        .add("a","10000")
                        .add("b","20000")
                        .build();

                try {
                    Request request = new Request.Builder()
                            .post(formBody)
                            .url("https://www.httpbin.org/post")
                            .build();
                    Response response = okHttpClient.newCall(request).execute();
                    String ss = response.body().string();
                    Log.e(TAG, "run: " + ss);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}