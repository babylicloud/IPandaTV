package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.presenter;


import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.IPandaLivemodel;
import test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive.PandaLiveImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveJCYKBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.PandaLiveContract;

/**
 * Created by lx on 2017/7/29.
 * 主页面
 */

public class PandaLivePresenter implements PandaLiveContract.Presenter {
    private PandaLiveContract.View view;
    private IPandaLivemodel pandaLivemodel;
    public PandaLivePresenter(PandaLiveContract.View view){
        this.view=view;
        this.view.setPresenter(this);
        pandaLivemodel=new PandaLiveImpl();
    }
    @Override
    public void start() {
        pandaLivemodel.liveFragment(new INetWorkCallback<PandaLiveJCYKBean>() {

            @Override
            public void OnSuccess(PandaLiveJCYKBean pandaLiveJCYKBean) {
                view.showLiveFragment(pandaLiveJCYKBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                view.showAcache();
            }
        });
    }
}
