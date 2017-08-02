package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.adapter.PabdaDXBRAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaDangxiongburangBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveDuoshijiaoBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveTalkListBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.contract.LiveContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.presenter.PandaLiveAmazingPresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.utils.ShowDialog;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

/**
 * Created by lx on 2017/7/29.
 * 精彩一刻
 */

public class PandaAmazingFragment extends BaseFragment implements LiveContract.View {
    @BindView(R.id.jcyk_pullrecycler)
    PullToRefreshRecyclerView jcykPullrecycler;
    Unbinder unbinder;
    private PabdaDXBRAdapter adapter;
    private List<PandaDangxiongburangBean.VideoBean> mList = new ArrayList<>();
    private LiveContract.Presenter presenter;
    private int Index = 1;
    private Bundle bundle = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_jcyk;
    }

    @Override
    protected void init(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        jcykPullrecycler.addItemDecoration(new DividerItemDecoration(App.activity, DividerItemDecoration.VERTICAL));
        jcykPullrecycler.setLayoutManager(layoutManager);
        jcykPullrecycler.setPullRefreshEnabled(true);//下拉刷新
        //是否开启上拉加载功能
        jcykPullrecycler.setLoadingMoreEnabled(true);
        //开启刷新回调
        jcykPullrecycler.displayLastRefreshTime(true);
        //停止刷新
        //停止刷新
        jcykPullrecycler.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                jcykPullrecycler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        jcykPullrecycler.setRefreshComplete();
                        mList.clear();
                        loadData();

                    }
                }, 200);
            }

            @Override
            public void onLoadMore() {
                jcykPullrecycler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        jcykPullrecycler.setLoadMoreComplete();
                        Index++;
                        loadData();

                    }
                }, 200);
            }
        });
    }

    @Override
    protected void loadData() {
        showProgress();
        new PandaLiveAmazingPresenter(this);
        presenter.start();
        adapter = new PabdaDXBRAdapter(getContext(), mList);
        jcykPullrecycler.setAdapter(adapter);
        if (bundle != null) {
            String vid = bundle.getString("vid");
            presenter.setVidManager(vid);
        }
    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
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
    public void showJcykFragment(PandaDangxiongburangBean pandaDangxiongburangBean) {
        mList.addAll(pandaDangxiongburangBean.getVideo());
        adapter.notifyDataSetChanged();
        dismissProgress();
    }

    @Override
    public void showMessage(String msg) {
        showAcache();
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
    public void setPresenter(LiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {
        ShowDialog.getInsent().create(App.activity);
    }

    @Override
    public void dismissProgress() {
        ShowDialog.getInsent().popuUtilsDismiss();
    }

    @Override
    public void showAcache() {
        ACache aCache = ACache.get(getContext());
        PandaDangxiongburangBean pandaChaomenggunxiuObject =
                (PandaDangxiongburangBean) aCache.
                        getAsObject("PandaDangxiongburangBean");
        mList.addAll(pandaChaomenggunxiuObject.getVideo());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsg() {

    }
}
