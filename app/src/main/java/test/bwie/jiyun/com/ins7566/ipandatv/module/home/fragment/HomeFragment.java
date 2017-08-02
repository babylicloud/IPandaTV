package test.bwie.jiyun.com.ins7566.ipandatv.module.home.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.utils.L;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.activity.VedioActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.activity.WebActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseFragment;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.HomeViewPagerAdapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.Home_Adapter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.adapter.setViewPagerListener;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.UpdateBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;

import static test.bwie.jiyun.com.ins7566.ipandatv.App.context;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View, ViewPager.OnPageChangeListener {
    private PullToRefreshRecyclerView PulltoRefresh;
    private View view1, v;
    private LinearLayout linearLayout;
    private ViewPager mViewPager;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private List<View> Pagerview = new ArrayList<>();
    private int currmentNum = 100000;
    private HomeContract.Presenter presenter;
    private Home_Adapter homeAdapter;
    private List<Object> mList = new ArrayList<>();
    //版本迭代
    private static int versionCode;
    private String versionsUrl;
    private AlertDialog alertDialog;
    int total = 0;
    private int versionsInt;

    @Override
    protected int getLayoutId() {
        return R.layout.main_headpage;

    }

    @Override
    protected void init(View view) {
        PulltoRefresh = (PullToRefreshRecyclerView) view.findViewById(R.id.PulltoRefresh);
        view1 = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_main, null);
        linearLayout = (LinearLayout) view1.findViewById(R.id.home_viewpager_linearLayout);
        mViewPager = (ViewPager) view1.findViewById(R.id.home_viewpager);
        mViewPager.setOnPageChangeListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        PulltoRefresh.setLayoutManager(linearLayoutManager);
        PulltoRefresh.addHeaderView(view1);
        PulltoRefresh.setPullRefreshEnabled(true);
        PulltoRefresh.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                PulltoRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PulltoRefresh.setRefreshComplete();
//                        mList.clear();

//                        presenter.start();
                    }
                }, 200);
            }

            @Override
            public void onLoadMore() {
                PulltoRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PulltoRefresh.setLoadMoreComplete();
//                        presenter.start();
                    }
                }, 200);
            }
        });
        mViewPager.setFocusable(true);
        mViewPager.setFocusableInTouchMode(true);
        mViewPager.requestFocus();

        homeAdapter = new Home_Adapter(App.activity, mList);
        PulltoRefresh.setAdapter(homeAdapter);
//        homeAdapter.notifyDataSetChanged();

    }

    @Override
    protected void loadData() {
        new HomePresenter(this);
        presenter.start();
        presenter.version();

        homeAdapter.setOnClick(new Home_Adapter.OnClick() {
            @Override
            public void setTYPE1(View view, HomePageBean.DataBean.PandaeyeBean pandaeyeBean) {
                Intent in = new Intent(App.activity, VedioActivity.class);
                in.putExtra("url", "");
                in.putExtra("pid", pandaeyeBean.getItems().get(0).getPid());
                in.putExtra("title", pandaeyeBean.getItems().get(0).getTitle());
                context.startActivity(in);
            }

            @Override
            public void setTYPE2(View view, HomePageBean.DataBean.PandaeyeBean pandaeyeBean) {
                Intent in = new Intent(App.activity, VedioActivity.class);
                in.putExtra("pid", pandaeyeBean.getItems().get(1).getPid());
                in.putExtra("title", pandaeyeBean.getItems().get(1).getTitle());
                context.startActivity(in);
            }

            @Override
            public void setTYPE3(View view, HomePageBean.DataBean.PandaliveBean listBean, int position) {

                Intent in = new Intent(App.activity, VedioActivity.class);
                in.putExtra("pid", listBean.getList().get(position).getVid());
                in.putExtra("title", listBean.getList().get(position).getTitle());
                context.startActivity(in);
            }

            @Override
            public void setTYPE4(View view, HomePageBean.DataBean.AreaBean areaBean, int position) {
                Intent in = new Intent(getContext(), VedioActivity.class);
                in.putExtra("pid", areaBean.getListscroll().get(position).getPid());
                in.putExtra("title", areaBean.getListscroll().get(position).getTitle());
                in.putExtra("image", areaBean.getListscroll().get(position).getImage());
                getContext().startActivity(in);
            }

            @Override
            public void setTYPE5(View view, HomePageBean.DataBean.WallliveBean wallliveBean, int position) {
            }

            @Override
            public void setTYPE6(View view, HomePageBean.DataBean.ChinaliveBean chinaliveBean, int position) {
            }
        });

    }


    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public void setImage(HomePageBean homePageBean) {
        List<HomePageBean.DataBean.BigImgBean> bigImgBeanList = homePageBean.getData().getBigImg();
        showLunBo(bigImgBeanList);

        mList = new ArrayList<>();
        HomePageBean.DataBean data = homePageBean.getData();
        mList.add(data.getPandaeye());
        mList.add(data.getArea());
        mList.add(data.getChinalive());
        mList.add(data.getWalllive());
        mList.add(data.getPandalive());
        homeAdapter = new Home_Adapter(App.activity, mList);
        PulltoRefresh.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void setMsg(String msg) {

    }


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showAcache() {

        ACache aCache = ACache.get(getContext());
        HomePageBean asObject = (HomePageBean) aCache.getAsObject("HomePageBean");

        List<HomePageBean.DataBean.BigImgBean> bigImgBeanList = asObject.getData().getBigImg();
        showLunBo(bigImgBeanList);

        mList = new ArrayList<>();
        HomePageBean.DataBean data = asObject.getData();
        mList.add(data.getPandaeye());
        mList.add(data.getArea());
        mList.add(data.getChinalive());
        mList.add(data.getWalllive());
        mList.add(data.getPandalive());
        homeAdapter = new Home_Adapter(App.activity, mList);
        PulltoRefresh.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

    }

    @Override
    public void showErrorMsg() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currmentNum = position;
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (i == currmentNum % checkBoxes.size()) {
                checkBoxes.get(i).setChecked(true);
            } else {
                checkBoxes.get(i).setChecked(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //轮播图
    private void showLunBo(final List<HomePageBean.DataBean.BigImgBean> bigImgBeen) {
        v = null;
        CheckBox checkBox;
        view1 = null;
        for (HomePageBean.DataBean.BigImgBean bigImgBean : bigImgBeen) {
            view1 = LayoutInflater.from(App.activity).inflate(R.layout.checkbox_item, null);
            checkBox = (CheckBox) view1.findViewById(R.id.viewpager_checkbox_btn);
            linearLayout.addView(view1);
            checkBoxes.add(checkBox);
            v = LayoutInflater.from(App.activity).inflate(R.layout.image_header_fragment, null);
            ImageView imageView = (ImageView) v.findViewById(R.id.Header_image);
            TextView title = (TextView) v.findViewById(R.id.Header_title);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String image = bigImgBean.getImage();
            String titlestr = bigImgBean.getTitle();
            Glide.with(App.activity).load(image).into(imageView);
            title.setText(titlestr);
            Pagerview.add(v);
        }
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(Pagerview);
        mViewPager.setAdapter(adapter);
        checkBoxes.get(currmentNum % checkBoxes.size()).setChecked(true);
        mViewPager.setCurrentItem(currmentNum);
        handler.sendEmptyMessageDelayed(222, 2000);
        adapter.setViewPagerListner(new setViewPagerListener() {
            @Override
            public void setViewPager(int position) {
                HomePageBean.DataBean.BigImgBean bigImgBean = bigImgBeen.get(position);
                if (position == 0) {
                    String pid = bigImgBean.getPid();
                    String title = bigImgBean.getTitle();
                    String url = bigImgBean.getUrl();
                    Intent in = new Intent(App.activity, WebActivity.class);
                    in.putExtra("url", url);
                    in.putExtra("title", title);
                    startActivity(in);
                } else {
                    String pid = bigImgBean.getPid();
                    String title = bigImgBean.getTitle();
                    Intent in = new Intent(App.activity, VedioActivity.class);
                    in.putExtra("pid", pid);
                    in.putExtra("title", title);
                    startActivity(in);
                }
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 222:
                    currmentNum++;
                    mViewPager.setCurrentItem(currmentNum);
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        if (i == currmentNum % checkBoxes.size()) {
                            checkBoxes.get(i).setChecked(true);
                        } else {
                            checkBoxes.get(i).setChecked(false);
                        }
                    }
                    handler.sendEmptyMessageDelayed(222, 2000);
                    break;
            }
        }
    };

    @Override
    public void getVersion(UpdateBean updateBean) {
        String versionsNum = updateBean.getData().getVersionsNum();
        versionsUrl = updateBean.getData().getVersionsUrl();
        versionsInt = Integer.parseInt(versionsNum);
        if (versionCode < versionsInt) {
            L.d("当前版本", versionCode + "");
            L.d("最新版本", versionsInt + "");
            getShowDialog();
        } else {
            Toast.makeText(getActivity(), "已经是最新版本", Toast.LENGTH_LONG).show();
        }
    }

    public void getShowDialog() {
        new AlertDialog.Builder(getActivity()).setTitle("版本升级")//设置对话框标题
                .setMessage("检测到最新版本，新版本修改了一些小Bug")//设置显示的内容
                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {//添加确定按钮

                    @Override
                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                        // TODO Auto-generated method stub
                        try {
                            PackageManager pm = getActivity().getPackageManager();
                            PackageInfo pi = pm.getPackageInfo(getActivity().getPackageName(), 0);
                            pi.versionCode = versionsInt;
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        dialog.dismiss();
                        showDialogUpdate();
                        dialog.dismiss();
                    }
                }).setNegativeButton("稍后再说", new DialogInterface.OnClickListener() {//添加返回按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {//响应事件
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).show();//在按键响应事件中显示此对话框
    }

    /**
     * 提示版本更新的对话框
     */
    private void showDialogUpdate() {
// 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // 设置提示框的标题
        builder.setTitle("版本升级").
                // 设置提示框的图标
                        setIcon(R.drawable.logo_ipnda).
                // 设置要显示的信息
                        setMessage("发现新版本！请及时更新").
                // 设置确定按钮
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "选择确定哦", 0).show();
                        dialog.dismiss();
                        loadNewVersionProgress();//下载最新的版本程序
                    }
                }).

                // 设置取消按钮,null是什么都不做，并关闭对话框
                        setNegativeButton("取消", null);

        // 生产对话框
        alertDialog = builder.create();
        // 显示对话框
        alertDialog.show();
    }

    /**
     * 下载新版本程序，需要子线程
     */
    private void loadNewVersionProgress() {
        final String uri = versionsUrl;
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(getActivity());
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread() {
            @Override
            public void run() {
                try {
                    File file = getFileFromServer(uri, pd);
                    sleep(3000);
                    installApk(file);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    //下载apk失败
                    Log.i("abc", "下载失败");
//                    Toast.makeText(getActivity(), "下载新版本失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 从服务器获取apk文件的代码
     * 传入网址uri，进度条对象即可获得一个File文件
     * （要在子线程中执行哦）
     */
    public File getFileFromServer(String uri, final ProgressDialog pd) throws Exception {
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //获取到文件的大小
            pd.setMax(conn.getContentLength());
            InputStream is = conn.getInputStream();
            long time = System.currentTimeMillis();//当前时间的毫秒数
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), time + "updata.apk");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                total += len;
                //获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        } else {
            return null;
        }
    }

    /**
     * 安装apk
     */
    protected void installApk(File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        //执行的数据类型
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }

}
