package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.LoginBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by Lenovo on 2017/7/29.
 */
public class MyselfActivity extends BaseActivity {
    @BindView(R.id.Personal_Finish)
    ImageView PersonalFinish;
    @BindView(R.id.panda_person_userimg)
    ImageView pandaPersonUserimg;
    @BindView(R.id.Text_Person)
    TextView TextPerson;
    @BindView(R.id.panda_person_username)
    RelativeLayout pandaPersonUsername;
    @BindView(R.id.panda_person_guankan)
    ImageView pandaPersonGuankan;
    @BindView(R.id.panda_person_guankanlishi)
    RelativeLayout pandaPersonGuankanlishi;
    @BindView(R.id.panda_person_shoucang)
    ImageView pandaPersonShoucang;
    @BindView(R.id.panda_person_wodeshoucang)
    RelativeLayout pandaPersonWodeshoucang;
    @BindView(R.id.panda_person_set)
    ImageView pandaPersonSet;
    @BindView(R.id.panda_person_setting)
    RelativeLayout pandaPersonSetting;
    private LoginBean loginBean;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String name ;
    @Override
    protected int getLayoutId() {
        return R.layout.panda_person_view;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

//        preferences = getSharedPreferences("data",MODE_PRIVATE);
//
//        name = preferences.getString("name","");
//
//        TextPerson.setText(name);

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

    @OnClick({R.id.panda_person_username, R.id.panda_person_guankanlishi, R.id.panda_person_wodeshoucang, R.id.panda_person_setting,R.id.Personal_Finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.panda_person_username:
                ACache acache = ACache.get(this);
                loginBean = (LoginBean) acache.getAsObject("loginentity");
                if (loginBean == null && TextPerson.getText().toString().equals("点击登录")) {
                    Intent in = new Intent(this, LoginActivity.class);
                    startActivityForResult(in, 50);
                } else {
                    Intent in = new Intent(this, Person_InfoActivity.class);
                    in.putExtra("userName", TextPerson.getText().toString());
                    startActivityForResult(in, 300);
                }

                break;
            case R.id.panda_person_guankanlishi:



                break;
            case R.id.panda_person_wodeshoucang:
                break;
            case R.id.panda_person_setting:
                Intent intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.Personal_Finish:
                onBackPressed();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 10:
                name = data.getStringExtra("name");
                MyLog.e("TAB", name);
                TextPerson.setText(name);
                break;
            case 50:
                TextPerson.setText(data.getStringExtra("user"));
                MyLog.e("TAG", data.getStringExtra("user"));
                break;
            case 300:
                TextPerson.setText(data.getStringExtra("edit"));
                MyLog.e("TAG", data.getStringExtra("edit"));
                break;
        }
    }


}
