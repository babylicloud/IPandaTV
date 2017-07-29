package test.bwie.jiyun.com.ins7566.ipandatv.model.broatcast;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;

/**
 * Created by INS7566 on 2017/7/28.
 */

public interface IBroadCast {
   <T> void getPandaObserveHead(INetWorkCallback<T> callback);
   <T> void getPandaObserveItem(INetWorkCallback<T> callback);

}
