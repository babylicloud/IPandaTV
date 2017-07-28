package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;

/**
 * Created by lx on 2017/7/28.
 */

public class PandaCultureItemAdapter extends BaseAdapter<PandaCultureBean.ListBean> {

    private boolean quchong = false;

    public PandaCultureItemAdapter(Context context, List<PandaCultureBean.ListBean> datas) {
        super(context, R.layout.fragment_panda_culture_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final PandaCultureBean.ListBean listBean) {

        RelativeLayout relativeLayout = holder.getView(R.id.panda_observe_relativeLayout);

        holder.setText(R.id.panda_oculture_item_sp_time, listBean.getVideoLength())
                .setText(R.id.panda_culture_item_title, listBean.getTitle())
                .setText(R.id.panda_culture_item_time, listBean.getBrief());
        ImageView imageView = holder.getView(R.id.panda_culture_item_image);
        Glide.with(context).load(listBean.getImage()).into(imageView);
    }
}
