package test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.adapter.DragAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.adapter.PandaDirectAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.adapter.ZHPagerAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.bean.ChangchengBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.bean.PopupBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.contract.LiveChinaContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.presenter.LiveChinaPresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.utils.ShowDialog;
import test.bwie.jiyun.com.ins7566.ipandatv.view.DragGridView;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View{
    @BindView(R.id.live_chena_TabLayout)
    TabLayout liveChenaTabLayout;
    @BindView(R.id.live_chena_IBtn)
    ImageButton liveChenaIBtn;
    @BindView(R.id.live_chena_viewPager)
    ViewPager liveChenaViewPager;
    Unbinder unbinder;
    private DragGridView gridView;
    private DragGridView gridView_other;
    private DragAdapter dragAdapter;
    private DragAdapter other_adapter;
    private ArrayList<BaseFragment> fragmentList = new ArrayList<BaseFragment>(); //碎片链表
    private PopupWindow popupWindow;
    private ArrayList<String> channels = new ArrayList<>();
    private ArrayList<String> channels_other = new ArrayList<>();
    private ZHPagerAdapter title_adapter;

    private PandaDirectAdapter adapter;
    private List<String> mListName;
    private List<BaseFragment> mList;
    private List<String> mListNameUrl;
    private Map<String, String> mMapAllUrl;
    private LiveChinaPresenter presenter;
    private CheckBox button;
    private ACache aCache;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_livechina_item;
    }

    @Override
    protected void init(View view) {
        new LiveChinaPresenter(this);
        title_adapter=new ZHPagerAdapter(App.activity.getSupportFragmentManager(),fragmentList, channels);
    }

    @Override
    protected void loadData() {
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
    public void showChangchengFragment(ChangchengBean changchengBean) {

    }

    @Override
    public void getChinaLiveTab(PopupBean popupBean) {
        add_Fragment(popupBean);
        List<PopupBean.TablistBean> tablist = popupBean.getTablist();
        initDatatitle(tablist);
        List<PopupBean.AlllistBean> alllist = popupBean.getAlllist();
        initDataOther(alllist);
//        ShowPopuUtils.getInsent().popuUtilsDismiss();
        liveChenaIBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.zhibochena_fragment, null);
                upPopupWindow(view);
            }
        });
    }

    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {
        this.presenter = (LiveChinaPresenter) presenter;
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

    }

    @Override
    public void showErrorMsg() {
        ACache aCache = ACache.get(getContext());
        PopupBean asObject = (PopupBean) aCache.getAsObject("PopupBean");
        add_Fragment(asObject);
    }

    public void add_Fragment(PopupBean popupBean) {
        mListName = new ArrayList<>();
        mList = new ArrayList<>();
        mListNameUrl = new ArrayList<>();
        mMapAllUrl = new HashMap<>();
        List<PopupBean.TablistBean> tablist = popupBean.getTablist();
        List<PopupBean.AlllistBean> alllist = popupBean.getAlllist();
        ChangchengFragment badaLingFragment = null;
        Bundle bundle = null;
        for (PopupBean.TablistBean tablistBean : tablist) {
            mListName.add(tablistBean.getTitle());
            badaLingFragment = new ChangchengFragment();
            bundle = new Bundle();
            bundle.putString("url", tablistBean.getUrl());
            badaLingFragment.setParams(bundle);
            mList.add(badaLingFragment);
            mListNameUrl.add(tablistBean.getUrl());
            mMapAllUrl.put(tablistBean.getTitle(), tablistBean.getUrl());
        }
        for (PopupBean.AlllistBean alllistBean : alllist) {
            mMapAllUrl.put(alllistBean.getTitle(), alllistBean.getUrl());
        }
        adapter = new PandaDirectAdapter(getChildFragmentManager(), mListName, mList);
        liveChenaViewPager.setAdapter(adapter);
        liveChenaTabLayout.setupWithViewPager(liveChenaViewPager);
        liveChenaTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    public void setRefresh() {
        mListName.clear();
        mList.clear();
        mListName.addAll(channels);
        Set<String> strings = mMapAllUrl.keySet();
        ChangchengFragment badaLingFragment = null;
        Bundle bundle = null;
        String url = null;
        for (String nameTab : mListName) {
            url = mMapAllUrl.get(nameTab);
            badaLingFragment = new ChangchengFragment();
            bundle = new Bundle();
            bundle.putString("url", url);
            badaLingFragment.setParams(bundle);
            mList.add(badaLingFragment);
        }
        adapter = new PandaDirectAdapter(getChildFragmentManager(), mListName, mList);
        liveChenaViewPager.setAdapter(adapter);
        liveChenaTabLayout.setupWithViewPager(liveChenaViewPager);

    }


    public void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.activity_popup_columns, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);
    }

    public void popupView(View v) {
        ImageView imageView = (ImageView) v.findViewById(R.id.Fanhui);
        gridView = (DragGridView) v.findViewById(R.id.gridView_channel);
        gridView_other = (DragGridView) v.findViewById(R.id.gridView_channel_other);
        button = (CheckBox) v.findViewById(R.id.licechina_add_button);
        gridView.setNumColumns(3);
        dragAdapter = new DragAdapter(App.activity, channels);
        gridView.setAdapter(dragAdapter);

        other_adapter = new DragAdapter(App.activity, channels_other);
        gridView_other.setAdapter(other_adapter);
        gridView_other.setNumColumns(3);

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button.setText("完成");
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String channel = channels.get(position);
                            if (channels.size() > 4) {
                                channels.remove(position);
                                channels_other.add(channel);
                                dragAdapter.notifyDataSetChanged();
                                other_adapter.notifyDataSetChanged();
                            }

                        }
                    });
                    gridView_other.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String channel = channels_other.get(position);
                            channels_other.remove(position);
                            channels.add(channel);
                            dragAdapter.notifyDataSetChanged();
                            other_adapter.notifyDataSetChanged();
                        }
                    });
                } else {
                    button.setText("编辑");
                    setRefresh();


                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWindow.dismiss();

            }
        });


    }

    private void initDataOther(List<PopupBean.AlllistBean> alllistBeanList) {
        for (PopupBean.AlllistBean alllistBean : alllistBeanList) {
            channels_other.add(alllistBean.getTitle());
//            ShowPopuUtils.getInsent().popuUtilsDismiss();
        }

    }

    private void initDatatitle(List<PopupBean.TablistBean> tablistBeanList) {
        for (PopupBean.TablistBean alllistBean : tablistBeanList) {
            channels.add(alllistBean.getTitle());
        }
    }
}
