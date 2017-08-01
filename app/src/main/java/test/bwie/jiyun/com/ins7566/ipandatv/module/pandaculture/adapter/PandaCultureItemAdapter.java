package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.activity.VedioActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.fragment.RollDtialActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

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
//        MyOpenHelper helper = new MyOpenHelper(getContext(), "guankanjilu.db", null, 1);
//
//        try {
//            dao = helper.getDao(JiluDao.class);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        holder.setOnclickListener(R.id.culture_relat, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listBean.getType().toString().equals("2")) {
                    Intent intent2 = new Intent(App.activity, RollDtialActivity.class);
                    intent2.putExtra("url", listBean.getUrl());
                    intent2.putExtra("pid", "84f27011346547c595d78b47a48eb6de");
                    intent2.putExtra("title", listBean.getTitle());
                    MyLog.e("Url", listBean.getUrl() + listBean.getTitle());
                    App.activity.startActivity(intent2);

//                    JiluDao jiluDao = new JiluDao();
//
//                    jiluDao.setTitle( listBean.getTitle());
//                    jiluDao.setImageurl(listBean.getImage());
//                    try {
//                        int i = dao.create(jiluDao);
//                        MyLog.e("AAA", "插入了" + i + "条数据");
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
                } else {
                    Intent intent = new Intent(App.activity, VedioActivity.class);
                    intent.putExtra("url", listBean.getUrl());
                    intent.putExtra("pid", listBean.getId());
                    intent.putExtra("title", listBean.getTitle());
                    intent.putExtra("image", listBean.getImage());
                    MyLog.e("Url", listBean.getUrl() + listBean.getTitle());
                    App.activity.startActivity(intent);

//                    try {
//                        List<JiluDao> chaxunItem = dao.queryForAll();
//                        if(chaxunItem.size() == 0) {
//                            JiluDao jiluDao = new JiluDao();
//                            jiluDao.setTitle( listBean.getTitle());
//                            jiluDao.setImageurl(listBean.getImage());
//                            int i = dao.create(jiluDao);
//                            MyLog.e("AAA", "插入了" + i + "条数据");
//                        }
//                        else {
//                            for (int i=0;i<chaxunItem.size();i++){
//                                if( listBean.getTitle().equals(chaxunItem.get(i).getTitle())) {
//                                    quchong=true;
//                                    return;
//                                }
//                            }
//                            if(quchong) {
//                                MyLog.e("tag","相同");
//                            }
//                            else {
//                                JiluDao jiluDao = new JiluDao();
//                                jiluDao.setTitle( listBean.getTitle());
//                                jiluDao.setImageurl(listBean.getImage());
//                                int i = dao.create(jiluDao);
//                                MyLog.e("AAA", "插入了" + i + "条数据");
//                                MyLog.e("tag","添加");
//                            }
//                        }
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }

                }
            }
        });
    }
}
