package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaDangxiongburangBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveDuoshijiaoBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveTalkListBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.LiveContract;

/**
 * Created by lx on 2017/7/29.
 * 主页面直播的布局
 */

public class LiveFragment extends BaseFragment implements LiveContract.View {
    @BindView(R.id.start)
    ImageView start;
    @BindView(R.id.direct_shipin_linear)
    RelativeLayout directShipinLinear;
    @BindView(R.id.direct_jianjie)
    TextView directJianjie;
    @BindView(R.id.live_isshow)
    CheckBox liveIsshow;
    @BindView(R.id.live_brief)
    TextView liveBrief;
    @BindView(R.id.live_back1)
    TextView liveBack1;
    @BindView(R.id.live_lin_brief)
    ScrollView liveLinBrief;
    @BindView(R.id.direct_framelayout)
    FrameLayout directFramelayout;
    Unbinder unbinder;
    private FragmentManager manager;

    boolean ischeck = false;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhibo;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            manager = App.activity.getSupportFragmentManager();
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.direct_framelayout, new PandaLivedsjtalkFragment());
        transaction.commit();
    }

    @Override
    public void setParams(Bundle bundle) {

    }


    @OnClick(R.id.live_isshow)
    public void onViewClicked() {

        if (ischeck == false) {
            liveLinBrief.setVisibility(View.VISIBLE);
            ischeck = true;
            return;
        } else {
            liveLinBrief.setVisibility(View.GONE);
            ischeck = false;
            return;

        }
    }

    @Override
    public void showlivevedioFragment(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void showLiveFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

    }

    @Override
    public void showeyeFragment(PandaLiveTalkListBean pandaLiveTalkListBean) {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showJcykFragment(PandaDangxiongburangBean pandaDangxiongburangBean) {

    }


    @Override
    public void setPresenter(LiveContract.Presenter presenter) {

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
