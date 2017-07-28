package test.bwie.jiyun.com.ins7566.ipandatv.module.home.fragment;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.HomeModelimpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.IHomeModel;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;

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
}
