package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin.zhuce;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;

/**
 * Created by Lenovo on 2017/7/30.
 */
public class Title_RegisterActivity extends BaseActivity {

    @BindView(R.id.Register_Finish)
    ImageView RegisterFinish;
    @BindView(R.id.PhoneRegister)
    Button PhoneRegister;
    @BindView(R.id.YouXiangRegister)
    Button YouXiangRegister;
    @BindView(R.id.Frame_Register)
    FrameLayout FrameRegister;
    private FragmentManager manager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_phone_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.Frame_Register, new PhoneRegisterFragment());
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Register_Finish, R.id.PhoneRegister, R.id.YouXiangRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Register_Finish:
                onBackPressed();
                break;
            case R.id.PhoneRegister:
                manager = getSupportFragmentManager();
                FragmentTransaction transaction1 = manager.beginTransaction();
                transaction1.replace(R.id.Frame_Register, new PhoneRegisterFragment());
                transaction1.commit();
                break;
            case R.id.YouXiangRegister:
                manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.Frame_Register, new EmailRegisterFragment());
                transaction.commit();
                break;
        }
    }
}
