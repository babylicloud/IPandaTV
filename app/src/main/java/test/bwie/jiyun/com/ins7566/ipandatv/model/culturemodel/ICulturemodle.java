package test.bwie.jiyun.com.ins7566.ipandatv.model.culturemodel;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;

/**
 * Created by lx on 2017/7/28.
 */

public interface ICulturemodle {
    void ShowTotal(INetWorkCallback<PandaCultureBean> callback);
}
