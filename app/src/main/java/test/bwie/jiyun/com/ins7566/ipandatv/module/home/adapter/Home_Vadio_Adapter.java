package test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;


/**
 * Created by lx on 2017/7/14.
 */

public class Home_Vadio_Adapter extends BaseAdapter {
    private List<HomePageBean.DataBean.WallliveBean.ListBeanX> mlist;
    private LayoutInflater inflater;
    private Context context;

    public Home_Vadio_Adapter(Context context, List<HomePageBean.DataBean.WallliveBean.ListBeanX> mlist) {
        this.mlist = mlist;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.home_vadio_adapter_item,null);
            viewHolder.home_vadio_image = (ImageView) convertView.findViewById(R.id.home_vadio_image);
            viewHolder.home_vadio_title = (TextView) convertView.findViewById(R.id.home_vadio_title);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HomePageBean.DataBean.WallliveBean.ListBeanX listscrollBean = mlist.get(position);
        viewHolder.home_vadio_title.setText(listscrollBean.getTitle());
        Glide.with(context).load(listscrollBean.getImage()).into(viewHolder.home_vadio_image);
        return convertView;
    }
    class ViewHolder{
        ImageView home_vadio_image;
        TextView home_vadio_title;
    }
}
