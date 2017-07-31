package test.bwie.jiyun.com.ins7566.ipandatv.module.home.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.HomeViewPagerAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.Home_Adapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.setOnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.setViewPagerListener;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View ,ViewPager.OnPageChangeListener{



   private PullToRefreshRecyclerView PulltoRefresh;
    private View view1,v;
    private LinearLayout linearLayout;
    private ViewPager mViewPager;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private List<View> Pagerview = new ArrayList<>();
    private int currmentNum = 100000;
    private HomeContract.Presenter presenter;
    private Home_Adapter homeAdapter;
    private List<Object> mList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.main_headpage;

    }

    @Override
    protected void init(View view) {
    PulltoRefresh = (PullToRefreshRecyclerView) view.findViewById(R.id.PulltoRefresh);
        view1 = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_main,null);
        linearLayout = (LinearLayout) view1.findViewById(R.id.home_viewpager_linearLayout);
        mViewPager = (ViewPager) view1.findViewById(R.id.home_viewpager);
        mViewPager.setOnPageChangeListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        PulltoRefresh.setLayoutManager(linearLayoutManager);
        PulltoRefresh.addHeaderView(view1);
        PulltoRefresh.setPullRefreshEnabled(true);
        PulltoRefresh.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                PulltoRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PulltoRefresh.setRefreshComplete();
//                        mList.clear();

//                        presenter.start();
                    }
                },200);
            }

            @Override
            public void onLoadMore() {
                PulltoRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PulltoRefresh.setLoadMoreComplete();
//                        presenter.start();
                    }
                },200);
            }
        });
        mViewPager.setFocusable(true);
        mViewPager.setFocusableInTouchMode(true);
        mViewPager.requestFocus();

        homeAdapter = new Home_Adapter(App.activity, mList);
        PulltoRefresh.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

    }

    @Override
    protected void loadData() {
        new HomePresenter(this);
        presenter.start();

        homeAdapter.setOnClick(new setOnClick() {
            @Override
            public void setTYPE1(View view) {

            }

            @Override
            public void setTYPE2(View view) {

            }

            @Override
            public void setTYPE3(View view) {

            }

            @Override
            public void setTYPE4(View view) {

            }

            @Override
            public void setTYPE5(View view) {

            }

            @Override
            public void setTYPE6(View view) {

            }
        });

    }

    @Override
    public void setParams(Bundle bundle) {

    }






    @Override
    public void setImage(HomePageBean homePageBean) {

        List<HomePageBean.DataBean.BigImgBean> bigImgBeanList = homePageBean.getData().getBigImg();
        showLunBo(bigImgBeanList);

        mList = new ArrayList<>();
        HomePageBean.DataBean data = homePageBean.getData();
        mList.add(data.getPandaeye());
        mList.add(data.getArea());
        mList.add(data.getChinalive());
        mList.add(data.getWalllive());
        mList.add(data.getPandalive());
        homeAdapter = new Home_Adapter(App.activity, mList);
        PulltoRefresh.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

    }

    @Override
    public void setMsg(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
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

        ACache aCache = ACache.get(getContext());
        HomePageBean asObject = (HomePageBean) aCache.getAsObject("HomePageBean");
        List<HomePageBean.DataBean.BigImgBean> bigImgBeanList = asObject.getData().getBigImg();
        showLunBo(bigImgBeanList);


        mList = new ArrayList<>();
        HomePageBean.DataBean data = asObject.getData();
        mList.add(data.getPandaeye());
        mList.add(data.getArea());
        mList.add(data.getChinalive());
        mList.add(data.getWalllive());
        mList.add(data.getPandalive());
        homeAdapter = new Home_Adapter(App.activity, mList);
        PulltoRefresh.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

    }

    @Override
    public void showErrorMsg() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //轮播图
    private void showLunBo(final List<HomePageBean.DataBean.BigImgBean> bigImgBeen) {
        v = null;
        CheckBox checkBox;
        view1 = null;
        for (HomePageBean.DataBean.BigImgBean bigImgBean : bigImgBeen) {
            view1 = LayoutInflater.from(App.activity).inflate(R.layout.checkbox_item, null);
            checkBox = (CheckBox) view1.findViewById(R.id.viewpager_checkbox_btn);
            linearLayout.addView(view1);
            checkBoxes.add(checkBox);
            v = LayoutInflater.from(App.activity).inflate(R.layout.image_header_fragment, null);
            ImageView imageView = (ImageView) v.findViewById(R.id.Header_image);
            TextView title = (TextView) v.findViewById(R.id.Header_title);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String image = bigImgBean.getImage();
            String titlestr = bigImgBean.getTitle();
            Glide.with(App.activity).load(image).into(imageView);
            title.setText(titlestr);
            Pagerview.add(v);
        }

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(Pagerview);
        mViewPager.setAdapter(adapter);
        checkBoxes.get(currmentNum % checkBoxes.size()).setChecked(true);
        mViewPager.setCurrentItem(currmentNum);
        handler.sendEmptyMessageDelayed(222, 2000);
        adapter.setViewPagerListner(new setViewPagerListener() {
            @Override
            public void setViewPager(int position) {
                HomePageBean.DataBean.BigImgBean bigImgBean = bigImgBeen.get(position);
                if (position == 0) {
                    String pid = bigImgBean.getPid();
                    String title = bigImgBean.getTitle();
//                    Intent in = new Intent(App.activity, BobaoActivity.class);
//                    in.putExtra("pid", pid);
//                    in.putExtra("title", title);
//                    startActivity(in);
                } else {
                    String pid = bigImgBean.getPid();
                    String title = bigImgBean.getTitle();
//                    Intent in = new Intent(App.activity, VideoActivity.class);
//                    in.putExtra("pid", pid);
//                    in.putExtra("title", title);
//                    startActivity(in);
                }
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 222:
                    currmentNum++;
                    mViewPager.setCurrentItem(currmentNum);
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        if (i == currmentNum % checkBoxes.size()) {
                            checkBoxes.get(i).setChecked(true);
                        } else {
                            checkBoxes.get(i).setChecked(false);
                        }
                    }
                    handler.sendEmptyMessageDelayed(222, 2000);
                    break;
            }
        }
    };




}
