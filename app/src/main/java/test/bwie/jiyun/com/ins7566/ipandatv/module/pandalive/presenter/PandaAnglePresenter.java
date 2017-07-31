package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.presenter;


import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.IPandaLivemodel;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.PandaLiveImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveDuoshijiaoBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.LiveContract;

/**
 * Created by lx on 2017/7/29.
 * 多视角直播
 */

public class PandaAnglePresenter implements LiveContract.Presenter {

    private LiveContract.View liveFragment;
    private IPandaLivemodel pandaLivemodel;

    public PandaAnglePresenter(LiveContract.View view) {
        this.liveFragment=view;
        this.liveFragment.setPresenter(this);
        pandaLivemodel = new PandaLiveImpl();

    }
    @Override
    public void start() {
        pandaLivemodel.getLiveFragment(Urls.PANDALIVE, null, new INetWorkCallback<PandaLiveDuoshijiaoBean>() {


            @Override
            public void OnSuccess(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {
                liveFragment.showLiveFragment(pandaLiveDuoshijiaoBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                liveFragment.showMessage(ErrorMsg);
            }
        });
    }

    @Override
    public void setVidManager(String vsid) {

    }
}
