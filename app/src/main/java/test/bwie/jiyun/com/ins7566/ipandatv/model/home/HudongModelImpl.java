package test.bwie.jiyun.com.ins7566.ipandatv.model.home;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HudongBean;

import static test.bwie.jiyun.com.ins7566.ipandatv.model.BaseModel.iHttp;

/**
 * Created by Lenovo on 2017/7/28.
 */
public class HudongModelImpl implements IHudongModel{
    @Override
    public void getHudong(INetWorkCallback<HudongBean> callback) {
        iHttp.get(Urls.INTERACTURL, null, callback);
    }
}
