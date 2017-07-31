package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.LoginBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin.zhuce.Title_RegisterActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by Lenovo on 2017/7/30.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View{
    @BindView(R.id.Login_Finish)
    ImageView LoginFinish;
    @BindView(R.id.Login_Register)
    TextView LoginRegister;
    @BindView(R.id.Text_Login)
    TextView TextLogin;
    @BindView(R.id.Login_WeiXin)
    ImageView LoginWeiXin;
    @BindView(R.id.Login_QQ)
    ImageView LoginQQ;
    @BindView(R.id.Login_WeiBo)
    ImageView LoginWeiBo;
    @BindView(R.id.mText)
    TextView mText;
    @BindView(R.id.editUserName)
    EditText editUserName;
    @BindView(R.id.editUserPassword)
    EditText editUserPassword;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.loginBtn)
    Button loginBtn;
    private LoginContract.Presenter presenter;
    private String usrid;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        new LoginPresenter(this);
        presenter.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
//    }



    @OnClick({R.id.Login_Finish, R.id.Login_WeiXin, R.id.Login_QQ, R.id.Login_WeiBo, R.id.loginBtn,R.id.Login_Register,R.id.forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Login_Finish:
                onBackPressed();
                break;
            case R.id.Login_WeiXin:

                break;
            case R.id.Login_QQ:
                break;
            case R.id.Login_WeiBo:
                break;
            case R.id.loginBtn:
                String userName = editUserName.getText().toString().trim();
                String passWard = editUserPassword.getText().toString().trim();
                if (userName.equals("") && passWard.equals("")) {
                    Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.Login(userName, passWard);
                }
//                finish()


                break;
            case R.id.Login_Register:
                Intent in = new Intent(this, Title_RegisterActivity.class);
                startActivity(in);
                break;
            case R.id.forget_password:
                break;

        }
    }

    @Override
    public void LoginOclick(LoginBean loginBean) {
        MyLog.e("TAG", loginBean.getErrMsg());
        ACache aCache = ACache.get(this);
        aCache.put("loginentity", loginBean);
        if (loginBean.getErrMsg().equals("成功")) {
            usrid = loginBean.getUser_seq_id();
            Toast.makeText(this, "成功登陆", Toast.LENGTH_SHORT).show();
            Intent in = getIntent();
            in.putExtra("user", "央视网友" + usrid);
            setResult(50, in);

//            editor = getSharedPreferences("data",MODE_PRIVATE).edit();
//            editor.putString("name","央视网友" + loginBean.getUser_seq_id());
//            editor.commit();
            finish();
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showAcache() {

    }

    @Override
    public void showErrorMsg() {

    }
}
