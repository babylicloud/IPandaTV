package test.bwie.jiyun.com.ins7566.ipandatv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by INS7566 on 2017/7/27.
 */


public abstract class BaseFragment extends Fragment {
    private boolean isFirst = true;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, inflater.inflate(getLayoutId(), null));
        return inflater.inflate(getLayoutId(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isFirst = true;
        init(view);
//        loadData();
    }

    //当页面可见时
    @Override
    public void onResume() {
        super.onResume();
        if (isFirst) {
            loadData();
            isFirst = false;
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        //Fragment处于隐藏状态
        if (hidden) {
            onHidden();
        } else {
            //Fragment处于显示状态
            onShow();
        }
    }

    //加载布局
    protected abstract int getLayoutId();

    //初始化数据
    protected abstract void init(View view);

    //加载数据
    protected abstract void loadData();

    //当前Fragment可见时调用
    protected void onShow() {
        //能在该方法中刷新数据
    }

    //当前Fragment隐藏时调用，可以做数据保存
    protected void onHidden() {
    }

    public abstract void  setParams(Bundle bundle);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
