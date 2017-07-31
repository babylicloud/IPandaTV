package test.bwie.jiyun.com.ins7566.ipandatv.model.culturemodel;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.HttpFactory;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;

/**
 * Created by lx on 2017/7/28.
 */

public class Cultureimp implements ICulturemodle {
    @Override
    public void ShowTotal(INetWorkCallback<PandaCultureBean> callback) {
        HttpFactory.create().get(Urls.PANDACULTURE, null, callback);
    }
}
