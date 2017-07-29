package test.bwie.jiyun.com.ins7566.ipandatv.model.livechina;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.HttpFactory;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class LiveChinaImpl implements LiveChinaModel {
    @Override
    public <T> void getLiveChinaUrl(String url, INetWorkCallback<T> callback) {
        HttpFactory.create().get(url,null,callback);
    }

    @Override
    public <T> void getLiveChinaTab(INetWorkCallback<T> callback) {
        HttpFactory.create().get(Urls.PANDA_LIVE_CHINA_TAB,null,callback);
    }
}
