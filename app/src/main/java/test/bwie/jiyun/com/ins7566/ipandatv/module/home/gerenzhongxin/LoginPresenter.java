package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.HomeModelimpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.IHomeModel;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.LoginBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by Lenovo on 2017/7/30.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private IHomeModel totallabelModel;
    private LoginContract.View LoginView;

    public LoginPresenter(LoginContract.View LoginView) {
        this.LoginView = LoginView;
        this.LoginView.setPresenter(this);
        totallabelModel = new HomeModelimpl();
    }



    @Override
    public void Login(String name, String pwd) {
        totallabelModel.Login(name, pwd, new INetWorkCallback<LoginBean>() {
            @Override
            public void OnSuccess(LoginBean loginBean) {
                LoginView.LoginOclick(loginBean);
                MyLog.e("TAG", loginBean.getErrMsg());
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }

    @Override
    public void start() {

    }
}
