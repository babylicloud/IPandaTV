package test.bwie.jiyun.com.ins7566.ipandatv.module.home.hudong;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.HudongModelImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.home.IHudongModel;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HudongBean;

/**
 * Created by Lenovo on 2017/7/28.
 */

public class HudongPresenter implements HudongContract.Presenter{


    private IHudongModel ihudongModel;
    private HudongContract.View Hudongview;

    public HudongPresenter(HudongContract.View Hudongview){
        this.Hudongview = Hudongview;
        this.Hudongview.setPresenter(this);
        ihudongModel = new HudongModelImpl();
    }

    @Override
    public void start() {
        ihudongModel.getHudong(new INetWorkCallback<HudongBean>() {
            @Override
            public void OnSuccess(HudongBean hudongBean) {
                Hudongview.setResult(hudongBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                Hudongview.showAcache();
            }
        });
    }
}
