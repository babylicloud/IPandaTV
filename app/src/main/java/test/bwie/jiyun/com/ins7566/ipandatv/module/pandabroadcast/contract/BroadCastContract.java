package test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.contract;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.bean.BroadHeaderBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.bean.PandaBroadBean;

/**
 * Created by INS7566 on 2017/7/28.
 */

public interface BroadCastContract {
    interface View extends BaseView<Presenter> {

        void setResult(PandaBroadBean pandaLiveBean);
        void setResultHeadler(BroadHeaderBean broadHeaderBean);
//        void showMessage(String msg);
//        void ShowMessageTwo(String msg);

    }

    interface Presenter extends BasePresenter {
    }
}
