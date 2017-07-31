package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin.zhuce;

import android.graphics.drawable.Drawable;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;

/**
 * Created by Lenovo on 2017/7/30.
 */

public interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void setDrawable(Drawable drawable);

        void sendYam(String s);
    }

    interface Presenter extends BasePresenter {
        void getSjYam(String name, String TpYam);
        void Register(String name, String Yzm, String pwd);
    }


}
