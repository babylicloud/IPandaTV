package test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.bean.PandaBroadBean;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class BobaoAdapter extends BaseAdapter<PandaBroadBean.ListBean> {

    public BobaoAdapter(Context context, List<PandaBroadBean.ListBean> datas) {
        super(context, R.layout.fragment_panda_observe_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final PandaBroadBean.ListBean pandaBroadBean) {

        holder.setText(R.id.panda_observe_item_title,pandaBroadBean.getTitle());
        holder.setText(R.id.panda_observe_item_sp_time,pandaBroadBean.getVideolength());
//        holder.setText(R.id.panda_observe_item_time,String.valueOf(pandaBroadBean.getFocus_date()));

//        String data1 =  DataUtils.getFormatedDateTime(,pandaBroadBean.getFocus_date());
//        holder.setText(R.id.panda_observe_item_time,data1);
        holder.setText(R.id.panda_observe_item_time, convert((pandaBroadBean.getFocus_date())));


        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.panda_observe_item_image);
        Glide.with(context).load(pandaBroadBean.getPicurl()).into(imageView);
//
//        MyOpenHelper helper = new MyOpenHelper(getContext(), "guankanjilu.db", null, 1);
//
//        try {
//            dao = helper.getDao(JiluDao.class);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        holder.setOnclickListener(R.id.panda_observe_relativeLayout, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,VideoActivity.class);
//                intent.putExtra("url",pandaBroadBean.getUrl());
//                intent.putExtra("title",pandaBroadBean.getTitle());
//                intent.putExtra("pid",pandaBroadBean.getGuid());
//                intent.putExtra("image",pandaBroadBean.getPicurl());
////                MyLog.e("Url",pandaBroadBean.getUrl()+pandaBroadBean.getTitle());
//                App.activity.startActivity(intent);
//
//
//            }
//        });
    }


    public String convert(long mill){
        Date date=new Date(mill);
        String strs="";
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            strs=sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }
}
