package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.presenter;


import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.IPandaLivemodel;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.PandaLiveImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaDangxiongburangBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.LiveContract;

/**
 * Created by lx on 2017/7/29.
 * 动态添加精彩一刻
 */

public class PandaLiveAmazingPresenter implements LiveContract.Presenter {
    private LiveContract.View liveFragment;
    private IPandaLivemodel pandaLivemodel;

    public PandaLiveAmazingPresenter(LiveContract.View view) {
        this.liveFragment=view;
        this.liveFragment.setPresenter(this);
        pandaLivemodel = new PandaLiveImpl();

    }
    @Override
    public void start() {

    }

    @Override
    public void setVidManager(String vsid) {
        pandaLivemodel.livejcyk(vsid, new INetWorkCallback<PandaDangxiongburangBean>() {


            @Override
            public void OnSuccess(PandaDangxiongburangBean pandaDangxiongburangBean) {
                liveFragment.showJcykFragment(pandaDangxiongburangBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                liveFragment.showMessage(ErrorMsg);
            }
        });
    }
}
