package test.bwie.jiyun.com.ins7566.ipandatv;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.RadioGroup;

import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

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

    @Override
    public void onCreate() {
        super.onCreate();
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("TAG123456", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
}
