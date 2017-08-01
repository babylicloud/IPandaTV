package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.activity.VedioActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaDangxiongburangBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;


/**
 * Created by lx on 2017/7/29.
 */

public class PabdaDXBRAdapter extends BaseAdapter<PandaDangxiongburangBean.VideoBean> {

    public PabdaDXBRAdapter(Context context, List<PandaDangxiongburangBean.VideoBean> datas) {
        super(context, R.layout.adapter_jcyk, datas);
    }

    @Override
    public void convert(final ViewHolder holder, final PandaDangxiongburangBean.VideoBean bean) {
        holder.setText(R.id.panda_oculture_item_sp_time, bean.getLen())
                .setText(R.id.panda_culture_item_title, bean.getT())
                .setText(R.id.panda_culture_item_time, bean.getPtime());
        ImageView imageView = holder.getView(R.id.panda_culture_item_image);
        Glide.with(context).load(bean.getImg()).into(imageView);
        holder.setOnclickListener(R.id.culture_relat, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VedioActivity.class);
                intent.putExtra("url", bean.getUrl());
                intent.putExtra("title", bean.getT());
                intent.putExtra("pid", bean.getVid());
                intent.putExtra("image", bean.getImg());
                MyLog.e("Url", bean.getUrl() + bean.getT());
                App.activity.startActivity(intent);
            }
        });
    }
}
