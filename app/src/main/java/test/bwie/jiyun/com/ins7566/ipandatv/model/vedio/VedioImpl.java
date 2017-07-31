package test.bwie.jiyun.com.ins7566.ipandatv.model.vedio;

import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.HttpFactory;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;

/**
 * Created by INS7566 on 2017/7/31.
 */

public class VedioImpl implements IVedio {
    @Override
    public <T> void getVDJCYK( Map<String, String> params, INetWorkCallback<T> callback) {
        HttpFactory.create().get(Urls.VEDIOJCYK,params,callback);
    }
}
