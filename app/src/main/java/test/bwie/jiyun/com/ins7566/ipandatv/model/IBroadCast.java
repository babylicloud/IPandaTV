package test.bwie.jiyun.com.ins7566.ipandatv.model;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;

/**
 * Created by INS7566 on 2017/7/28.
 */

public interface IBroadCast {
    void getPandaObserveHead(INetWorkCallback callback);
    void getPandaObserveItem(INetWorkCallback callback);

}
