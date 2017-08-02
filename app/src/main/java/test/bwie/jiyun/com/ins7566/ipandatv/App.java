package test.bwie.jiyun.com.ins7566.ipandatv;

import android.app.Application;
import android.content.Context;
import android.widget.RadioGroup;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by INS7566 on 2017/7/27.
 */

public class App extends Application {
    public static BaseActivity activity;
    public static BaseFragment lastFragment;
    public static Context context;
    public static RadioGroup mRadiogroup;

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("629348515", "846d07e6c06496625cf0ae0ced36021d", "https://api.weibo.com/oauth2/default.html");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        UMShareAPI.get(this);
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String s) {
                MyLog.e("TAG1", s);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
//        CrashHandler.getInstance().init(this);//初始化全局异常管理
    }

}
