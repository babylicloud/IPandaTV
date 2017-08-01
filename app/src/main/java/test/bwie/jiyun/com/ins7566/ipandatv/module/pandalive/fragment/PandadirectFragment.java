package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.adapter.PandaDirectAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveJCYKBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.PandaLiveContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.presenter.PandaLivePresenter;

/**
 * Created by lx on 2017/7/29.
 * 直播页面 显示的第一个页面
 */

public class PandadirectFragment extends BaseFragment implements PandaLiveContract.View {
    @BindView(R.id.direct_tablayout)
    TabLayout directTablayout;
    @BindView(R.id.direct_viewpager)
    ViewPager directViewpager;
    Unbinder unbinder;
    private PandaDirectAdapter adapter;
    private List<String> mListName;
    private List<BaseFragment> mList;
    private PandaLivePresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pandadirect;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        new PandaLivePresenter(this);
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
    public void showLiveFragment(PandaLiveJCYKBean pandaLiveJCYKBean) {
        mListName = new ArrayList<>();
        mList = new ArrayList<>();
        List<PandaLiveJCYKBean.TablistBean> tablist = pandaLiveJCYKBean.getTablist();
        PandaAmazingFragment pandaJCYKFragment = null;
        Bundle bundle = null;
        mListName.add("直播");
        mList.add(new LiveFragment());

        for (int i = 1; i < tablist.size(); i++) {
            PandaLiveJCYKBean.TablistBean tablistBean = tablist.get(i);
            pandaJCYKFragment = new PandaAmazingFragment();
            String title = tablistBean.getTitle();
            bundle = new Bundle();
            bundle.putString("vid", tablistBean.getId());
            pandaJCYKFragment.setParams(bundle);
            mListName.add(title);
            mList.add(pandaJCYKFragment);
        }
        adapter = new PandaDirectAdapter(getChildFragmentManager(), mListName, mList);
        directViewpager.setAdapter(adapter);
        directTablayout.setupWithViewPager(directViewpager);
    }

    @Override
    public void setPresenter(PandaLiveContract.Presenter presenter) {
        this.presenter = (PandaLivePresenter) presenter;
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
