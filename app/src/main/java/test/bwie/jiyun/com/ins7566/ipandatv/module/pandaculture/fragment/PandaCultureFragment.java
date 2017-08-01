package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.adapter.HomeViewPagerAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.adapter.PandaCultureItemAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureVedioBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaTebieBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.contract.CultureContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.presenter.CulturePresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by lx on 2017/7/28.
 */

public class PandaCultureFragment extends BaseFragment implements CultureContract.View, ViewPager.OnPageChangeListener {
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
    private List<CheckBox> checkBoxes;
    private int currmentNum = 100000;
    private View v, v1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_culture;
    }

    @Override
    protected void init(View view) {
        culturePullrecycler = (PullToRefreshRecyclerView) view.findViewById(R.id.culture_pullrecycler);
        pandaCultureBeen = new ArrayList<>();
        listBeen = new ArrayList<>();
        imgs = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        View pandaCultureView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_panda_culture_banner, null);
        pandaCultureViewPagerView = (ViewPager) pandaCultureView.findViewById(R.id.panda_culture_banner);
        pandaCultureViewPagerView.setOnPageChangeListener(this);
        pandaCultureBannerTitle = (TextView) pandaCultureView.findViewById(R.id.panda_culture_banner_title);
        linearLayout = (LinearLayout) pandaCultureView.findViewById(R.id.pointsLinearLayout);
        pandaCultureItemAdapter = new PandaCultureItemAdapter(getActivity(), listBeen);
        culturePullrecycler.setAdapter(pandaCultureItemAdapter);
        pandaCultureItemAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        culturePullrecycler.setLayoutManager(linearLayoutManager);
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
        getHeader(pandaCultureBean.getBigImg());
        pandaCultureBeen.addAll(pandaCultureBean.getBigImg());
        listBeen.addAll(pandaCultureBean.getList());
    }

    @Override
    public void ShowFirst(PandaTebieBean pandaTebieBean) {

    }

    @Override
    public void showVideo(PandaCultureVedioBean pandaCultureVedioBean) {

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

    @Override
    public void showErrorMsg() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currmentNum = position;
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (i == currmentNum % checkBoxes.size()) {
                checkBoxes.get(i).setChecked(true);
            } else {
                checkBoxes.get(i).setChecked(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 222:
                    currmentNum++;
                    pandaCultureViewPagerView.setCurrentItem(currmentNum);
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

    private void getHeader(final List<PandaCultureBean.BigImgBean> pandaCultureBeen) {
        v = null;
        CheckBox checkBox;
        v1 = null;
        for (PandaCultureBean.BigImgBean bigImgBean : pandaCultureBeen) {
            v1 = LayoutInflater.from(App.activity).inflate(R.layout.checkbox_item, null);
            checkBox = (CheckBox) v1.findViewById(R.id.viewpager_checkbox_btn);
            linearLayout.addView(v1);
            checkBoxes.add(checkBox);
            v = LayoutInflater.from(App.activity).inflate(R.layout.image_header_fragment, null);
            ImageView imageView = (ImageView) v.findViewById(R.id.Header_image);
            TextView title = (TextView) v.findViewById(R.id.Header_title);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String title1 = bigImgBean.getTitle();
            title.setText(title1);
            String image = bigImgBean.getImage();
            Glide.with(App.activity).load(image).into(imageView);
            imgs.add(v);
            MyLog.e("TAG", image + "-------" + title1);
        }
        homeViewPagerAdapter = new HomeViewPagerAdapter(imgs);
        pandaCultureViewPagerView.setAdapter(homeViewPagerAdapter);
        checkBoxes.get(currmentNum % checkBoxes.size()).setChecked(true);
        pandaCultureViewPagerView.setCurrentItem(currmentNum);
        handler.sendEmptyMessageDelayed(222, 2000);
    }
}
