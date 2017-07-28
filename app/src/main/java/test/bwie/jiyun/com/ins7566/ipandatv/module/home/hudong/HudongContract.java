package test.bwie.jiyun.com.ins7566.ipandatv.module.home.hudong;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HudongBean;

/**
 * Created by Lenovo on 2017/7/28.
 */

public interface HudongContract {

    interface Presenter extends BasePresenter{

    }
    interface View extends BaseView<Presenter>{

        void setResult(HudongBean hudongBean);

        void showMessage(String msg);
    }



}
