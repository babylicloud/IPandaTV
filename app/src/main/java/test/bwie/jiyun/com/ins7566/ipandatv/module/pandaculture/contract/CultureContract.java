package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.contract;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BasePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseView;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaTebieBean;

/**
 * Created by lx on 2017/7/28.
 */

public interface CultureContract {
    interface View extends BaseView<Presenter> {
        //展示所有
        void ShowAll(PandaCultureBean pandaCultureBean);

        //展示第一条数据
        void ShowFirst(PandaTebieBean pandaTebieBean);

        //返回信息
        void ShowMsg(String msg);
    }

    interface Presenter extends BasePresenter {
        void setVideoURl(String pid);
    }
}
