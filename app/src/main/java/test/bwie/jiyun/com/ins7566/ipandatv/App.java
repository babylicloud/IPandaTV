package test.bwie.jiyun.com.ins7566.ipandatv;

import android.app.Application;
import android.content.Context;
import android.widget.RadioGroup;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;

/**
 * Created by INS7566 on 2017/7/27.
 */

public class App extends Application {
    public static BaseActivity activity;
    public static BaseFragment lastFragment;
    public static Context context;
    public static RadioGroup mRadiogroup;
}
