package test.bwie.jiyun.com.ins7566.ipandatv.module.vedio;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.vedio.bean.VideoStartBean;

/**
 * Created by INS7566 on 2017/7/31.
 */

public interface VedioContract  {
    interface View extends BaseView<Presenter> {
        //播放视频
        void showlivevedioFragment(VideoStartBean jcykBean);

    }

    interface Presenter extends BasePresenter {
        void setVideoURl(String pid);
    }

}
