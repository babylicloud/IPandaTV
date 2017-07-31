package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract;


import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveJCYKBean;

/**
 * Created by lx on 2017/7/29.
 */

public interface PandaLiveContract {
    interface View extends BaseView<Presenter> {
        void showLiveFragment(PandaLiveJCYKBean pandaLiveJCYKBean);
    }

    interface Presenter extends BasePresenter {

    }
}
