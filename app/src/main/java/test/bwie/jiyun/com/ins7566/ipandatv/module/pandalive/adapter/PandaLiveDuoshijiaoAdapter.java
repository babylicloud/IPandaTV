package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.adapter;


import android.content.Context;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveDuoshijiaoBean;


/**
 * Created by lx on 2017/7/29.
 */

public class PandaLiveDuoshijiaoAdapter extends BaseAdapter<PandaLiveDuoshijiaoBean.ListBean> {
    public PandaLiveDuoshijiaoAdapter(Context context, List<PandaLiveDuoshijiaoBean.ListBean> datas) {
        super(context, R.layout.adapter_duoshijiaolive, datas);
    }


    @Override
    public void convert(ViewHolder holder, PandaLiveDuoshijiaoBean.ListBean listBean) {
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.duoshijiao_iv);
        Glide.with(App.activity).load(listBean.getImage()).into(imageView);
        holder.setText(R.id.duoshijiao_tv, listBean.getTitle());

    }
}
