package test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter;


import android.content.Context;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HudongBean;

/**
 * Created by Lenovo on 2017/7/17.
 */

public class HudongAdapter extends BaseAdapter<HudongBean.InteractiveBean> {


    public HudongAdapter(Context context, List<HudongBean.InteractiveBean> datas) {
        super(context, R.layout.hudong_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final HudongBean.InteractiveBean interactiveBean) {

        holder.setText(R.id.Hudong_item_title,interactiveBean.getTitle());
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.Hudong_item_Image);
        Glide.with(context).load(interactiveBean.getImage()).into(imageView);
//       holder.setOnclickListener(R.id.hudong_linear, new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent intent=new Intent(App.activity, WebActivity.class);
//               intent.putExtra("url",interactiveBean.getUrl());
//               App.activity.startActivity(intent);
//
//           }
//       });


    }
}
