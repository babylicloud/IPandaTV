package test.bwie.jiyun.com.ins7566.ipandatv.model.home;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HudongBean;

/**
 * Created by Lenovo on 2017/7/28.
 */
public interface IHudongModel {

    void getHudong(INetWorkCallback<HudongBean> callback);

}
