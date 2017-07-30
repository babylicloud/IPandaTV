package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;


/**
 * Created by lx on 2017/7/29.
 */

public class PandaDirectAdapter extends FragmentStatePagerAdapter {
    private List<String> ListName;
    private List<BaseFragment> mList;

    public PandaDirectAdapter(FragmentManager fm, List<String> ListName, List<BaseFragment> mList) {
        super(fm);
        this.ListName = ListName;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ListName.get(position);
    }
}
