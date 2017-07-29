package test.bwie.jiyun.com.ins7566.ipandatv.model.broatcast;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.HttpFactory;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class BroadCastImpl implements IBroadCast {
    @Override
    public void getPandaObserveHead(INetWorkCallback callback) {
        HttpFactory.create().get(Urls.PANDA_OBSERVE_HEAD,null,callback);
    }

    @Override
    public void getPandaObserveItem(INetWorkCallback callback) {
        HttpFactory.create().get(Urls.PANDA_OBSERVE_ITEM, null, callback);
    }
}
