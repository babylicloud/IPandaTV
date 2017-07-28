package test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter;

import android.view.View;

import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;

/**
 * Created by lx on 2017/7/20.
 */

public interface setOnClick {
    void setOnClick(HomePageBean.DataBean.PandaeyeBean homePageBean, int position, View view);
    void setOnClick(HomePageBean.DataBean.PandaliveBean pandaliveBean, int position, View view);
}
