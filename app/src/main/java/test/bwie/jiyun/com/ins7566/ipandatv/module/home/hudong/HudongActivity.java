package test.bwie.jiyun.com.ins7566.ipandatv.module.home.hudong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.activity.WebActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.HudongAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HudongBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

/**
 * Created by Lenovo on 2017/7/28.
 */
public class HudongActivity extends BaseActivity implements HudongContract.View{

    @BindView(R.id.Personal_Cente)
    ImageView PersonalCente;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.Hudong_recyclerView)
    PullToRefreshRecyclerView HudongRecyclerView;
    private List<HudongBean.InteractiveBean> mList = new ArrayList<>();
    private int Index= 1;
    private HudongAdapter mAdapter;
    private HudongContract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.hudong_activity;
    }

    @Override
    protected void initView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        HudongRecyclerView.addItemDecoration(new DividerItemDecoration(App.activity, DividerItemDecoration.VERTICAL));
        HudongRecyclerView.setLayoutManager(layoutManager);
        HudongRecyclerView.setPullRefreshEnabled(true);//下拉刷新
        //是否开启上拉加载功能
        HudongRecyclerView.setLoadingMoreEnabled(true);
        //开启刷新回调
        HudongRecyclerView.displayLastRefreshTime(true);
        //停止刷新
        //停止刷新
        HudongRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                HudongRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HudongRecyclerView.setRefreshComplete();
                        mList.clear();
                        loadData();

                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                HudongRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HudongRecyclerView.setLoadMoreComplete();
                        Index++;
                        loadData();

                    }
                }, 2000);
            }
        });


        mAdapter = new HudongAdapter(this, mList);
        HudongRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnClick(new HudongAdapter.Onclick() {
            @Override
            public void Setonclick(View view, HudongBean.InteractiveBean interactiveBean) {
                Intent intent=new Intent(HudongActivity.this, WebActivity.class);
                intent.putExtra("url",interactiveBean.getUrl());
                startActivity(intent);
            }
        });



    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
       new HudongPresenter(this);
        presenter.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.Personal_Cente)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void setResult(HudongBean hudongBean) {
        mList.addAll(hudongBean.getInteractive());
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HudongContract.Presenter presenter) {
        this.presenter= presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showAcache() {
        ACache aCache = ACache.get(App.activity);
        HudongBean hudongobj = (HudongBean) aCache.getAsObject("HudongBean");
        mList.addAll(hudongobj.getInteractive());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsg() {

    }
}
