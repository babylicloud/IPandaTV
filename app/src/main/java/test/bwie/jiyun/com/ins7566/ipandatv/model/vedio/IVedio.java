package test.bwie.jiyun.com.ins7566.ipandatv.model.vedio;

import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;

/**
 * Created by INS7566 on 2017/7/31.
 */

public interface IVedio {
    <T> void getVDJCYK(Map<String,String> params, INetWorkCallback<T> callback);
}
