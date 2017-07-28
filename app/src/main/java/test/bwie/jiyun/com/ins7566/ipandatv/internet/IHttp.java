package test.bwie.jiyun.com.ins7566.ipandatv.internet;

import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;

/**
 * Created by INS7566 on 2017/7/27.
 */

public interface IHttp {
    <T> void get(String url, Map<String, String> params, INetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, INetWorkCallback<T> callback);
    <T> void download(String url,Map<String,String> params,INetWorkCallback<T> callback);

}
