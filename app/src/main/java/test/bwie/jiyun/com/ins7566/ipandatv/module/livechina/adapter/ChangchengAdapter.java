package test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.bean.ChangchengBean;

/**
 * Created by INS7566 on 2017/7/29.
 */

public class ChangchengAdapter extends BaseAdapter{
    private Context mContext;
    private List<ChangchengBean.LiveBean> mList;
    private boolean isBocke = false;

    public ChangchengAdapter(Context mContext, List<ChangchengBean.LiveBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    class Holder{
        private ImageView jcVideoPlayer;
        private TextView mtitle,mJianjie;
        private ImageButton chebox;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if(convertView == null) {
            holder = new Holder();
            convertView = View.inflate(mContext, R.layout.adapter_livechina_item,null);
            holder.jcVideoPlayer = (ImageView) convertView.findViewById(R.id.custom_videoplayer_standard_with_share_button);
            holder.mtitle = (TextView) convertView.findViewById(R.id.ZhiboChena_title);
            holder.mJianjie = (TextView) convertView.findViewById(R.id.ZhiboChena_Jianjie);
            holder.chebox = (ImageButton) convertView.findViewById(R.id.ZhiboChena_chebox);

            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        ChangchengBean.LiveBean bean = mList.get(position);
        holder.mtitle.setText(bean.getTitle());
        holder.mJianjie.setText(bean.getBrief());
        Glide.with(App.activity).load(bean.getImage()).into(holder.jcVideoPlayer);

        holder.chebox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isBocke == false) {
                    holder.mJianjie.setVisibility(View.VISIBLE);
                    isBocke =true;
                }else{
                    isBocke=false;
                    holder.mJianjie.setVisibility(View.GONE);
                }
            }
        });

        return convertView;
    }
}
