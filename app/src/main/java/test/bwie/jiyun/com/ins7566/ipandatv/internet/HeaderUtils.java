package test.bwie.jiyun.com.ins7566.ipandatv.internet;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NNetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.UpdateBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

/**
 * Created by lx on 2017/7/21.
 */

public class HeaderUtils implements IHttp {
    private OkHttpClient okHttpClient;
    private String jsonId;
    private byte[] bytes;

    //构造函数私有化
    private HeaderUtils() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static HeaderUtils okHttpUtils;

    //提供一个公共的、静态的、返回值类型是当前本类的对象
    public static HeaderUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (HeaderUtils.class) {
                if (okHttpUtils == null)
                    okHttpUtils = new HeaderUtils();
            }
        }
        return okHttpUtils;
    }

    /**
     * 发送get请求
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param callback 回调
     * @param <T>      请求回来的数据对应的JavaBean
     */
    @Override
    public <T> void get(String url, Map<String, String> params, final INetWorkCallback<T> callback) {
        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.toString().substring(0, sb.length() - 1);
        }
        Request request = null;
        try {
            request = new Request.Builder()
                    .addHeader("Referer", URLEncoder.encode("https://reg.cntv.cn/login/login.action", "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CYNTV_MOBILE", "UTF-8"))
                    .url(url).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        if (e.getMessage() != null) {
                            callback.OnError(404, e.getMessage().toString());
                        } else {
                            Log.e("Error", "错误 e.getMessage 为空");
                        }


                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.OnSuccess(getGeneric(jsonData, callback));
                    }
                });
            }
        });

    }

    @Override
    public <T> void post(String url, Map<String, String> params, final INetWorkCallback<T> callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key, value);
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.OnError(404, e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.OnSuccess(getGeneric(jsonData, callback));
                    }
                });

            }
        });
    }

    @Override
    public <T> void doget(String url, Map<String, String> params, final NetWorkCallback callback) {
        Request request = null;
        request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.getMessage();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                bytes = response.body().bytes();
                Headers headers = response.headers();
                final Drawable drawable = byteToDrawable(bytes);
                jsonId = headers.get("Set-Cookie");
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.OnSucess(drawable);
                    }
                });

            }
        });
    }

    //获得手机验证码
    @Override
    public <T> void getSjYam(String url, Map<String, String> params, final NNetWorkCallback callback) {
        Request request = null;
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                String s = params.get(key);
                builder.add(key, s);
            }
        }
        FormBody build = builder.build();
        try {
            request = new Request.Builder()
                    .post(build)
                    .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", jsonId)
                    .url(url).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.getMessage();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.OnSuccess(string);
                    }
                });
            }
        });
    }
    //注册
    @Override
    public <T> void Register(String url, Map<String, String> params, final NNetWorkCallback callback) {
        Request request = null;
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                String s = params.get(key);
                builder.add(key, s);
            }
        }
        FormBody build = builder.build();
        try {
            request = new Request.Builder()
                    .post(build)
                    .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .url(url).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.OnSuccess(string);
                    }
                });
            }
        });
    }

    @Override
    public <T> void EmailRegister(String url, Map<String, String> params, final NNetWorkCallback callback) {
        Request request = null;
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                String s = params.get(key);
                builder.add(key, s);
            }
        }
        FormBody build = builder.build();
        try {
            request = new Request.Builder()
                    .post(build)
                    .addHeader("Referer", URLEncoder.encode("iPanda.Android", "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8"))
                    .addHeader("Cookie", getCookie())
                    .url(url).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.OnSuccess(string);
                    }
                });
            }
        });
    }

    @Override
    public <T> void DownLoad(String url, Map<String, String> params, INetWorkCallback<UpdateBean> callback) {

    }

    public Drawable byteToDrawable(byte[] buteArray) {
        try {
            String string = new String(buteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(buteArray);
        return Drawable.createFromStream(ins, null);
    }

    /**
     * 自动解析json至回调中的JavaBean
     *
     * @param jsonData
     * @param callBack
     * @param <T>
     * @return
     */
    private <T> T getGeneric(String jsonData, INetWorkCallback<T> callBack) {
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData, type);
        ACache aCache = ACache.get(App.activity);
        aCache.put(t.getClass().getSimpleName(), (Serializable) t);
        return t;
    }

    public String getCookie() {
        SharedPreferences sharedPreferences = App.activity.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String cookie = sharedPreferences.getString("Cookie", "");
        return cookie;
    }
}
