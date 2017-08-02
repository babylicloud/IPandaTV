package test.bwie.jiyun.com.ins7566.ipandatv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.umeng.message.PushAgent;

import butterknife.ButterKnife;
import test.bwie.jiyun.com.ins7566.ipandatv.App;

/**
 * Created by INS7566 on 2017/7/27.
 */


public abstract class BaseActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        App.activity = this;
        initView();
        initData();
        loadData();
        PushAgent.getInstance(this).onAppStart();
    }
private boolean mFlag;
    @Override
    protected void onResume() {
        super.onResume();
        //记住当前的BaseActivity
        App.activity = this;
        //当页面可见时加载数据
//        MobclickAgent.onResume(this);

        App.activity = this;
        if(mFlag) {
            loadData();
            mFlag=false;
        }

    }

    public void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //加载布局
    protected abstract int getLayoutId();

    //初始化view
    protected abstract void initView();

    //初始化数据
    public abstract void initData();

    //加载数据
    public abstract void loadData();

}
