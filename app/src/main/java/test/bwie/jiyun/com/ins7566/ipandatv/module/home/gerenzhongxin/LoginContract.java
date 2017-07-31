package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.LoginBean;

/**
 * Created by Lenovo on 2017/7/30.
 */

public interface LoginContract {


    interface View extends BaseView<Presenter> {
        void LoginOclick(LoginBean loginBean);
    }

    interface Presenter extends BasePresenter {
        void Login(String name, String pwd);
    }

}
