package test.bwie.jiyun.com.ins7566.ipandatv.module.home.fragment;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;

/**
 * Created by Lenovo on 2017/7/28.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter>{

        void setImage(HomePageBean homePageBean);
        void setMsg(String msg);

    }

    interface Presenter extends BasePresenter{

    }
}
