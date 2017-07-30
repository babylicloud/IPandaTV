package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract;


import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaDangxiongburangBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveDuoshijiaoBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveTalkListBean;

/**
 * Created by lx on 2017/7/29.
 */

public interface LiveContract {

    interface View extends BaseView<Presenter> {
        //播放视频
        void showlivevedioFragment(PandaLiveBean pandaLiveBean);
        //多视角直播
        void showLiveFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean);
        //边看边聊
        void showeyeFragment(PandaLiveTalkListBean pandaLiveTalkListBean);

        void showMessage(String msg);

        void showJcykFragment(PandaDangxiongburangBean pandaDangxiongburangBean);
    }

    interface Presenter extends BasePresenter {
        void setVidManager(String vsid);
    }
}
