package test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.adapter.BobaoAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.bean.BroadHeaderBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.bean.PandaBroadBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.contract.BroadCastContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.presenter.BroadCastPresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class PandaBroadcastFragment extends BaseFragment implements BroadCastContract.View{
    @BindView(R.id.bobao_RecyclerView)
    PullToRefreshRecyclerView mRecyclerView;
    Unbinder unbinder;

    private ImageView mImage;
    private TextView title;
    private View view1;
    BroadCastContract.Presenter presenter;
    private List<PandaBroadBean.ListBean> mList = new ArrayList<>();
    private BobaoAdapter bobaoAdapter;
    private String urls;
    private BroadHeaderBean bobaoHeaderBean;
    private int Index = 1;
    private BroadCastPresenter bobaoPresenter;
    private String url;

    private String mTitle,tupian;
    private boolean flag=false;
    @Override
    protected int getLayoutId() {
        return R.layout.bobao_fragment;
    }

    @Override
    protected void init(View view) {

        view1 = LayoutInflater.from(getContext()).inflate(R.layout.image_header_fragment, null);
        mImage = (ImageView) view1.findViewById(R.id.Header_image);
        title = (TextView) view1.findViewById(R.id.Header_title);

        mRecyclerView.addHeaderView(view1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(App.activity, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setPullRefreshEnabled(true);//下拉刷新
        //是否开启上拉加载功能
        mRecyclerView.setLoadingMoreEnabled(true);
        //开启刷新回调
        mRecyclerView.displayLastRefreshTime(true);
        //停止刷新
        //停止刷新
        mRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.setRefreshComplete();
                        mList.clear();
                        loadData();

                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.setLoadMoreComplete();
                        Index++;
                        loadData();

                    }
                }, 2000);
            }
        });
    }

    @Override
    protected void loadData() {
        bobaoPresenter = new BroadCastPresenter(this);
        presenter.start();
        bobaoAdapter = new BobaoAdapter(getContext(), mList);
        mRecyclerView.setAdapter(bobaoAdapter);


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
    public void setResult(PandaBroadBean pandaLiveBean) {

        mList.addAll(pandaLiveBean.getList());
        bobaoAdapter.notifyDataSetChanged();
//        ShowPopuUtils.getInsent().popuUtilsDismiss();
    }

    @Override
    public void setResultHeadler(BroadHeaderBean broadHeaderBean) {
//        tupian = bobaoHeaderBean.getData().getBigImg().get(0).getImage();
//        Glide.with(App.activity).load(tupian).into(mImage);
//        mTitle = bobaoHeaderBean.getData().getBigImg().get(0).getTitle();
//        this.title.setText(mTitle);
//        url = bobaoHeaderBean.getData().getBigImg().get(0).getUrl();
    }

    @Override
    public void showMessage(String msg) {

    }


    @Override
    public void ShowMessageTwo(String msg) {
    }
    @Override
    public void setPresenter(BroadCastContract.Presenter presenter) {
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
        ACache aCache=ACache.get(App.activity);
//        BroadHeaderBean broadHeader = (BroadHeaderBean) aCache.getAsObject("BroadHeaderBean");
//        tupian = broadHeader.getData().getBigImg().get(0).getImage();
//        Glide.with(App.activity).load(tupian).into(mImage);
//        mTitle = broadHeader.getData().getBigImg().get(0).getTitle();
//        this.title.setText(mTitle);
//        url = broadHeader.getData().getBigImg().get(0).getUrl();
//        mList.addAll(pandaLiveBean.getList());
        PandaBroadBean pandaBroadBea = (PandaBroadBean) aCache.getAsObject("PandaBroadBean");
        mList.addAll(pandaBroadBea.getList());
        bobaoAdapter.notifyDataSetChanged();
    }

}
