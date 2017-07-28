package test.bwie.jiyun.com.ins7566.ipandatv.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.fragment.HomeFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.fragment.PandaBroadcastFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.ConfigFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.FrameLayout)
    android.widget.FrameLayout FrameLayout;
    @BindView(R.id.main_home_btn)
    RadioButton mainHomeBtn;
    @BindView(R.id.main_live_btn)
    RadioButton mainLiveBtn;
    @BindView(R.id.main_culture_btn)
    RadioButton mainCultureBtn;
    @BindView(R.id.main_broadcast_btn)
    RadioButton mainBroadcastBtn;
    @BindView(R.id.main_china_btn)
    RadioButton mainChinaBtn;
    @BindView(R.id.FrameLayout_contentGroup)
    RadioGroup FrameLayoutContentGroup;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {
        ConfigFragment.getInstance().init().start(HomeFragment.class).build();
    }

    @Override
    public void loadData() {

    }

    @OnClick({R.id.main_home_btn, R.id.main_live_btn, R.id.main_culture_btn, R.id.main_broadcast_btn, R.id.main_china_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_home_btn:
                break;
            case R.id.main_live_btn:
                break;
            case R.id.main_culture_btn:
                break;
            case R.id.main_broadcast_btn:
                ConfigFragment.getInstance().init().start(PandaBroadcastFragment.class).build();
                break;
            case R.id.main_china_btn:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
