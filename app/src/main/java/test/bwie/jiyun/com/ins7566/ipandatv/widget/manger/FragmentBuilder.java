package test.bwie.jiyun.com.ins7566.ipandatv.widget.manger;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;

import static test.bwie.jiyun.com.ins7566.ipandatv.App.lastFragment;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class FragmentBuilder {
    private FragmentManager fragmentManager;
    private BaseFragment baseFragment;
    private FragmentTransaction fragmentTransaction;
    private String simpleName;

    private FragmentBuilder() {
        init();
    }

    private static FragmentBuilder fragmentBuilder;

    public static synchronized FragmentBuilder getInstance() {
        if (fragmentBuilder == null) {
            fragmentBuilder = new FragmentBuilder();
        }
        return fragmentBuilder;
    }

    private void init() {
        //初始化并得到fragmentManger管理者对象
        fragmentManager = App.activity.getSupportFragmentManager();
    }

    public FragmentBuilder start(Class<? extends BaseFragment> baseclass, int ViewID) {
        //开始事务
        fragmentTransaction = fragmentManager.beginTransaction();
        //要跳转fragment的类
        simpleName = baseclass.getSimpleName();
        //用tag标记
        baseFragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
        if (baseFragment == null) {
            try {
                baseFragment = baseclass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //添加到事务
            fragmentTransaction.add(ViewID, baseFragment, simpleName);
        }
        if (lastFragment != null) {
            fragmentTransaction.hide(lastFragment);
        }
        //展示当前页面
        fragmentTransaction.show(baseFragment);
        //添加到回退栈
        fragmentTransaction.addToBackStack(simpleName);
        return this;
    }

    //传参
    public FragmentBuilder setParms(Bundle bundle) {
        baseFragment.setParams(bundle);
        return this;
    }

    public BaseFragment builder() {
        //赋给上一个页面
        lastFragment = baseFragment;
        //提交事务
        fragmentTransaction.commit();
        return baseFragment;
    }

    //清空
    public static void clean() {
        fragmentBuilder = null;
    }


}
