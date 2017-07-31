package test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.adapter.ChangchengAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.bean.ChangchengBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.bean.PopupBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.contract.LiveChinaContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.presenter.ChangchengPresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.utils.ShowDialog;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

/**
 * Created by INS7566 on 2017/7/29.
 */

public class ChangchengFragment extends BaseFragment implements LiveChinaContract.View {
    @BindView(R.id.livechina_listview)
    ListView livechinaListview;
    Unbinder unbinder;
    private ChangchengAdapter adapter;
    private List<ChangchengBean.LiveBean> mList =new ArrayList<>();
    private Bundle bundle;
    private ACache aCache;
    private LiveChinaContract.Presenter presenter;
    String url;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_livechina;
    }

    @Override
    protected void init(View view) {
        new ChangchengPresenter(this);
         url =bundle.getString("url");
        if (url!=null){
            presenter.setChangcheng(url);

        }
        adapter = new ChangchengAdapter(getContext(),mList);
        livechinaListview.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        presenter.setChangcheng(url);

    }

    @Override
    public void setParams(Bundle bundle) {
         this.bundle=bundle;
    }

    @Override
    public void showChangchengFragment(ChangchengBean changchengBean) {
        mList.addAll(changchengBean.getLive());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getChinaLiveTab(PopupBean popupBean) {

    }

    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {
    this.presenter=presenter;
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
        aCache=ACache.get(getContext());
        ChangchengBean list = (ChangchengBean)aCache.getAsObject("ChangchengBean");
        mList.addAll(list.getLive());
        adapter.notifyDataSetChanged();
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
