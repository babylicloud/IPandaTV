package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.fragment;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.adapter.PandaLiveDuoshijiaoAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaDangxiongburangBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveDuoshijiaoBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveTalkListBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.LiveContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.presenter.PandaAnglePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;


/**
 * Created by lx on 2017/7/29.
 */

public class PandaLiveDuoshijiaoFragment extends BaseFragment implements LiveContract.View {
    @BindView(R.id.duoshijiaopullrecycler)
    PullToRefreshRecyclerView duoshijiaopullrecycler;
    Unbinder unbinder;
    @BindView(R.id.Lin)
    LinearLayout Lin;
    private PandaLiveDuoshijiaoAdapter adapter;
    private List<PandaLiveDuoshijiaoBean.ListBean> mList = new ArrayList<>();
    private LiveContract.Presenter presenter;
    private int Index = 1;

    private PandaAnglePresenter presente;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_duoshijiao;
    }

    @Override
    protected void init(View view) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Lin.setVisibility(View.GONE);
        duoshijiaopullrecycler.addItemDecoration(new DividerItemDecoration(App.activity, DividerItemDecoration.VERTICAL));
        duoshijiaopullrecycler.setLayoutManager(gridLayoutManager);
        duoshijiaopullrecycler.setPullRefreshEnabled(true);//下拉刷新
        //是否开启上拉加载功能
        duoshijiaopullrecycler.setLoadingMoreEnabled(true);
        //开启刷新回调
        duoshijiaopullrecycler.displayLastRefreshTime(true);
        //停止刷新
        //停止刷新
        duoshijiaopullrecycler.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                duoshijiaopullrecycler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        duoshijiaopullrecycler.setRefreshComplete();
                        mList.clear();
                        loadData();

                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                duoshijiaopullrecycler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        duoshijiaopullrecycler.setLoadMoreComplete();
                        Index++;
                        loadData();

                    }
                }, 2000);
            }
        });

        adapter = new PandaLiveDuoshijiaoAdapter(getContext(), mList);
        duoshijiaopullrecycler.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        presente = new PandaAnglePresenter(this);
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
    public void showlivevedioFragment(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void showLiveFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {
        mList.addAll(pandaLiveDuoshijiaoBean.getList());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showeyeFragment(PandaLiveTalkListBean pandaLiveTalkListBean) {

    }

    @Override
    public void showMessage(String msg) {
        ACache aCache = ACache.get(getContext());
        PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoObject = (PandaLiveDuoshijiaoBean) aCache.getAsObject("PandaLiveDuoshijiaoBean");

        mList.addAll(pandaLiveDuoshijiaoObject.getList());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showJcykFragment(PandaDangxiongburangBean pandaDangxiongburangBean) {

    }


    @Override
    public void setPresenter(LiveContract.Presenter presenter) {
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
