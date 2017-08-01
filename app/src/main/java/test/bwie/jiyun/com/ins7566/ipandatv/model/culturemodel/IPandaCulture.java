package test.bwie.jiyun.com.ins7566.ipandatv.model.culturemodel;

import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.BaseModel;

/**
 * Created by hp1 on 2017-04-07.
 */

public interface IPandaCulture extends BaseModel {
    void getPandaCultureHead(String url, INetWorkCallback myCallback);
    void getPandaCultureItem(String url, INetWorkCallback myCallback);

    <T> void getPandaCultureVideo(Map<String, String> params, INetWorkCallback<T> callback);
    <T> void getculuretebie(String url, Map<String, String> params, INetWorkCallback<T> callback);
}
