package test.bwie.jiyun.com.ins7566.ipandatv.module.home.fragment;

import com.nostra13.universalimageloader.utils.L;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.HomeModelimpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.IHomeModel;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.UpdateBean;

/**
 * Created by Lenovo on 2017/7/28.
 */

public class HomePresenter implements HomeContract.Presenter {
    private IHomeModel iHomeModel;
    private HomeContract.View homeView;

    public HomePresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        this.homeView.setPresenter(this);
        iHomeModel = new HomeModelimpl();
    }

    @Override
    public void start() {
        iHomeModel.getHomePageLunBo(new INetWorkCallback<HomePageBean>() {
            @Override
            public void OnSuccess(HomePageBean homePageBean) {
                homeView.setImage(homePageBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                homeView.showAcache();
            }

        });

    }

    @Override
    public void version() {
        iHomeModel.version(new INetWorkCallback<UpdateBean>() {
            @Override
            public void OnSuccess(final UpdateBean updateBean) {
                //成功的回调
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeView.getVersion(updateBean);
                        L.d("版本更新bean打印", updateBean.getData().getVersionsinfo().toString());

                    }
                });
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
//                L.d("版本更新网络请求错误",errorMsg.toString());
            }

        });
    }
}
