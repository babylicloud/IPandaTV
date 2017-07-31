package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin.zhuce;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;

/**
 * Created by Lenovo on 2017/7/30.
 */
public class EmailRegisterFragment extends BaseFragment implements EmailRegisterContract.View {

    @BindView(R.id.editUserPhone_yx)
    EditText editUserPhoneYx;
    @BindView(R.id.checkCodeEdit_yx)
    EditText checkCodeEditYx;
    @BindView(R.id.Email_Image_YanZhengma)
    ImageView EmailImageYanZhengma;
    @BindView(R.id.newPasswordEdit_yx)
    EditText newPasswordEditYx;
    @BindView(R.id.newCheckPasswordEdit_yx)
    EditText newCheckPasswordEditYx;
    @BindView(R.id.findPwdBtn_yx)
    Button findPwdBtnYx;
    Unbinder unbinder;
    private byte[] bytes;
    private String jsonId;
    private EmailRegisterContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.register_youxiang;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        new EmailRegisterPresenter(this);
        presenter.start();
    }


    @Override
    public void setParams(Bundle bundle) {

    }

    public void getPersonalRegImgCheck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request build = new Request.Builder().url("http://reg.cntv.cn/simple/verificationCode.action").build();
                okHttpClient.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Headers headers = response.headers();
                        jsonId = headers.get("Set-Cookie");
                        bytes = response.body().bytes();
                        App.activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Drawable captchaImage = byteToDrawable(bytes);
                                EmailImageYanZhengma.setImageDrawable(captchaImage);
                            }
                        });
                    }
                });
            }
        }).start();
    }


    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }

    @OnClick({R.id.findPwdBtn_yx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.findPwdBtn_yx:
                String trim = editUserPhoneYx.getText().toString().trim();
                String trim1 = checkCodeEditYx.getText().toString().trim();
                String trim2 = newCheckPasswordEditYx.getText().toString().trim();
                presenter.Register(trim, trim1, trim2);
                break;
        }
    }

    @OnClick(R.id.Email_Image_YanZhengma)
    public void onViewClicked() {
//        getPersonalRegImgCheck();
        presenter.start();
    }

    @Override
    public void setDrawable(Drawable drawable) {
        EmailImageYanZhengma.setImageDrawable(drawable);
    }

    @Override
    public void set(String s) {

    }

    @Override
    public void setPresenter(EmailRegisterContract.Presenter presenter) {
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
