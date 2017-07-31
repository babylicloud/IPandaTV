package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.utils.AmendEditText;

/**
 * Created by Lenovo on 2017/7/31.
 */
public class PersonAmendActivity extends BaseActivity {
    @BindView(R.id.Amend_Login_Finish_Person)
    ImageView AmendLoginFinishPerson;
    @BindView(R.id.Edit_Amend)
    AmendEditText EditAmend;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_amend;
    }

    @Override
    protected void initView() {
        Intent in = getIntent();
        String info = in.getStringExtra("info");
        EditAmend.setText(info);
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.Amend_Login_Finish_Person)
    public void onViewClicked() {
        onBackPressed();
    }
}
