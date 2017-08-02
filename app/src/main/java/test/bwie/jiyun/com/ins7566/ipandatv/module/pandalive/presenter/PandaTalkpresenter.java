package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.presenter;


import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.IPandaLivemodel;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.PandaLiveImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveTalkListBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.LiveContract;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by lx on 2017/7/29.
 * 边看边聊
 */

public class PandaTalkpresenter implements LiveContract.Presenter {
    private LiveContract.View liveFragment;
    private IPandaLivemodel pandaLivemodel;

    public PandaTalkpresenter(LiveContract.View view) {
        this.liveFragment = view;
        this.liveFragment.setPresenter(this);
        pandaLivemodel = new PandaLiveImpl();
    }

    @Override
    public void start() {
        pandaLivemodel.getEyeFragment(Urls.TALKLIST, null, new INetWorkCallback<PandaLiveTalkListBean>() {


            @Override
            public void OnSuccess(PandaLiveTalkListBean pandaLiveTalkListBean) {
                liveFragment.showeyeFragment(pandaLiveTalkListBean);
                MyLog.e("talk", pandaLiveTalkListBean.getData().getTotal());
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                liveFragment.showMessage(ErrorMsg);
                liveFragment.showAcache();
            }
        });
    }

    @Override
    public void setVidManager(String vsid) {

    }
}
