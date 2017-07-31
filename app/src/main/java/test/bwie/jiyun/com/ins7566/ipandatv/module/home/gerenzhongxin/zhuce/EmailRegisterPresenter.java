package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin.zhuce;

import android.graphics.drawable.Drawable;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NNetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.HomeModelimpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.IHomeModel;

/**
 * Created by Lenovo on 2017/7/30.
 */

public class EmailRegisterPresenter implements EmailRegisterContract.Presenter {

    private IHomeModel totallabelModel;
    private EmailRegisterContract.View homeView;

    public EmailRegisterPresenter(EmailRegisterContract.View homeView) {
        this.homeView = homeView;
        this.homeView.setPresenter(this);
        totallabelModel = new HomeModelimpl();
    }


    @Override
    public void Register(String name, String Yzm, String pwd) {
        totallabelModel.getEmailRegister(name, Yzm, pwd, new NNetWorkCallback() {
            @Override
            public void OnSuccess(String s) {
                homeView.set(s);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }

    @Override
    public void start() {
        totallabelModel.getPicture(new NetWorkCallback() {
            @Override
            public void OnSucess(Drawable drawable) {
                homeView.setDrawable(drawable);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }
}
