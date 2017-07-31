package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin.zhuce;

import android.graphics.drawable.Drawable;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NNetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.HomeModelimpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.IHomeModel;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by Lenovo on 2017/7/30.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private IHomeModel iHomeModel;
    private RegisterContract.View homeView;

    public RegisterPresenter(RegisterContract.View homeView) {
        this.homeView = homeView;
        this.homeView.setPresenter(this);
        iHomeModel = new HomeModelimpl();
    }


    @Override
    public void getSjYam(String name, String TpYam) {
        iHomeModel.getYzm(name, TpYam, new NNetWorkCallback() {
            @Override
            public void OnSuccess(String s) {
                homeView.sendYam(s);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }

    @Override
    public void Register(String name, String Yzm, String pwd) {
        iHomeModel.getRegister(name, Yzm, pwd, new NNetWorkCallback() {
            @Override
            public void OnSuccess(String s) {
                homeView.sendYam(s);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }

    @Override
    public void start() {
        iHomeModel.getPicture(new NetWorkCallback() {
            @Override
            public void OnSucess(Drawable drawable) {
                homeView.setDrawable(drawable);
                MyLog.e("TAG",drawable+"");
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }
}
