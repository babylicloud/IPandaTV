package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin.zhuce;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by Lenovo on 2017/7/30.
 */
public class PhoneRegisterFragment extends BaseFragment implements RegisterContract.View {

    @BindView(R.id.editUserPhone_)
    EditText editUserPhone;
    @BindView(R.id.Phone_Cancle)
    TextView PhoneCancle;
    @BindView(R.id.checkCodeEdit_)
    EditText checkCodeEdit;
    @BindView(R.id.TPYanZhengma)
    ImageView TPYanZhengma;
    @BindView(R.id.Photo_Cancle)
    TextView PhotoCancle;
    @BindView(R.id.phoneCheckCode_)
    EditText phoneCheckCode;
    @BindView(R.id.phoneCheckCodeBtn_)
    Button phoneCheckCodeBtn;
    @BindView(R.id.Yzm_Cancle)
    TextView YzmCancle;
    @BindView(R.id.newPasswordEdit_)
    EditText newPasswordEdit;
    @BindView(R.id.Pwd_Cancle)
    TextView PwdCancle;
    @BindView(R.id.findPwdBtn_)
    Button findPwdBtn;
    Unbinder unbinder;
    private byte[] bytes;
    private OkHttpClient Client = new OkHttpClient.Builder().build();
    private String jsonId;
    private RegisterContract.Presenter presenter;


    @Override
    protected int getLayoutId() {
        return R.layout.register_phone;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        new RegisterPresenter(this);
        presenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @OnClick({R.id.phoneCheckCodeBtn_, R.id.findPwdBtn_})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phoneCheckCodeBtn_:
                //手机号
                String tPhoneNumber = editUserPhone.getText().toString().trim();
                //图片验证码
                String imgyanzhengma = checkCodeEdit.getText().toString().trim();
                //手机验证码
                presenter.getSjYam(tPhoneNumber, imgyanzhengma);
                break;
            case R.id.findPwdBtn_:
                //手机号输入
                String number = editUserPhone.getText().toString().trim();
                //手机验证码
                String tCheckPhone = phoneCheckCode.getText().toString().trim();
                //密码输入
                String tPassWord = newPasswordEdit.getText().toString();
                //注册
                presenter.Register(number, tCheckPhone, tPassWord);
                break;
        }
    }

    @OnClick(R.id.TPYanZhengma)
    public void onViewClicked() {
        presenter.start();
    }


    @Override
    public void setDrawable(Drawable drawable) {
        TPYanZhengma.setImageDrawable(drawable);
        MyLog.e("TAG", drawable + "");
    }

    @Override
    public void sendYam(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
