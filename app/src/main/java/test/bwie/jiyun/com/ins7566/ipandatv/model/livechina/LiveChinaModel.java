package test.bwie.jiyun.com.ins7566.ipandatv.model.livechina;


import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;

/**
 * Created by INS7566 on 2017/7/28.
 */

public interface LiveChinaModel {
    <T>void getLiveChinaUrl(String url,INetWorkCallback<T> callback);
    <T>void getLiveChinaTab(INetWorkCallback<T> callback);
}
