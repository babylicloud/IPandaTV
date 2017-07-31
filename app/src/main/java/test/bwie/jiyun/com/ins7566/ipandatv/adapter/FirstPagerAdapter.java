package test.bwie.jiyun.com.ins7566.ipandatv.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by INS7566 on 2017/7/11.
 */

public class FirstPagerAdapter extends PagerAdapter {
    private List<View> mlist;
    public FirstPagerAdapter(List<View> list){
        mlist = list;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mlist.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        container.removeView(mlist.get(position));
    }
}
