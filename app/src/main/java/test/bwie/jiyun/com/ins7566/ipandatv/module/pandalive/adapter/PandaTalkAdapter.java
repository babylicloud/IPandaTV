package test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandalive.bean.PandaLiveTalkListBean;


/**
 * Created by lx on 2017/7/29.
 */

public class PandaTalkAdapter extends BaseAdapter<PandaLiveTalkListBean.DataBean.ContentBean> {

    public PandaTalkAdapter(Context context, List<PandaLiveTalkListBean.DataBean.ContentBean> datas) {
        super(context, R.layout.adapter_talk, datas);
    }

    @Override
    public void convert(ViewHolder holder, PandaLiveTalkListBean.DataBean.ContentBean dataBean) {
        holder.setText(R.id.talk_title, dataBean.getAuthor());
        holder.setText(R.id.talk_content, dataBean.getMessage());
        holder.setText(R.id.talk_lou, dataBean.getPid() + "楼");
        holder.setText(R.id.talk_date, dataBean.getDateline());
    }
}
