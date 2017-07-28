package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.adapter.HomeViewPagerAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.adapter.PandaCultureItemAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaTebieBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.contract.CultureContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.presenter.CulturePresenter;

/**
 * Created by lx on 2017/7/28.
 */

public class PandaCultureFragment extends BaseFragment implements CultureContract.View {
    @BindView(R.id.culture_pullrecycler)
    PullToRefreshRecyclerView culturePullrecycler;
    Unbinder unbinder;
    private CultureContract.Presenter presenter;
    private List<View> imgs;
    private HomeViewPagerAdapter homeViewPagerAdapter;
    private PandaCultureItemAdapter pandaCultureItemAdapter;
    private ViewPager pandaCultureViewPagerView;
    private TextView pandaCultureBannerTitle;
    private LinearLayout linearLayout;
    private List<PandaCultureBean.BigImgBean> pandaCultureBeen;
    private List<PandaCultureBean.ListBean> listBeen;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_culture;
    }

    @Override
    protected void init(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        culturePullrecycler.setLayoutManager(linearLayoutManager);
        pandaCultureBeen = new ArrayList<>();
        listBeen = new ArrayList<>();
        pandaCultureItemAdapter = new PandaCultureItemAdapter(getActivity(), listBeen);
        pandaCultureItemAdapter.notifyDataSetChanged();
        View pandaCultureView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_panda_culture_banner, null);
        pandaCultureViewPagerView = (ViewPager) pandaCultureView.findViewById(R.id.panda_culture_banner);
        pandaCultureBannerTitle = (TextView) pandaCultureView.findViewById(R.id.panda_culture_banner_title);
        linearLayout = (LinearLayout) pandaCultureView.findViewById(R.id.pointsLinearLayout);
        culturePullrecycler.addHeaderView(pandaCultureView);
    }

    @Override
    protected void loadData() {
        new CulturePresenter(this);
        presenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

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

    @Override
    public void ShowAll(PandaCultureBean pandaCultureBean) {
        pandaCultureBeen.addAll(pandaCultureBean.getBigImg());
        listBeen.addAll(pandaCultureBean.getList());
    }

    @Override
    public void ShowFirst(PandaTebieBean pandaTebieBean) {

    }

    @Override
    public void ShowMsg(String msg) {

    }

    @Override
    public void setPresenter(CultureContract.Presenter presenter) {
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
}
