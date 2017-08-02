package test.bwie.jiyun.com.ins7566.ipandatv.activity;

import android.app.ActionBar;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.vedio.VedioContract;
import test.bwie.jiyun.com.ins7566.ipandatv.module.vedio.VedioPresenter;
import test.bwie.jiyun.com.ins7566.ipandatv.module.vedio.bean.VideoStartBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by INS7566 on 2017/7/31.
 */

public class VedioActivity extends BaseActivity implements VedioContract.View, View.OnClickListener {
    @BindView(R.id.custom_videoplayer_standard_with_share_button)
    JCVideoPlayerStandard jcVideoPlayerStandard;
    private VedioContract.Presenter presenter;
    private String pid, title, image;
    private android.widget.PopupWindow PopupWindow;
    private String url;
    private Boolean flag = true;

    @Override
    protected int getLayoutId() {
        return R.layout.video_avtivity;
    }

    @Override
    protected void initView() {
        presenter = new VedioPresenter(this);
        Intent intent = getIntent();

        pid = intent.getStringExtra("pid");
        title = intent.getStringExtra("title");
        image = intent.getStringExtra("image");
        MyLog.e("aaa", title + image);

        //标准基础上改进的视频播放(添加了分享按钮)
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.custom_videoplayer_standard_with_share_button);


    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        presenter.setVideoURl(pid);
    }

    @Override
    public void showlivevedioFragment(VideoStartBean jcykBean) {
        List<VideoStartBean.VideoBean.Chapters2Bean> chapters2 = jcykBean.getVideo().getChapters2();
        url = chapters2.get(0).getUrl();
        jcVideoPlayerStandard.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
        jcVideoPlayerStandard.startVideo();
        jcVideoPlayerStandard.setMonitor(new JCVideoPlayerStandard.imgClickon() {
            @Override
            public void Monitor(View view) {

            }

            @Override
            public void Back(View view) {
                finish();
            }

            @Override
            public void WatchthelistMonitor(View view) {
                showPopupWindow();
            }

            @Override
            public void PopupGao(View view) {

            }

            @Override
            public void PopupBiao(View view) {

            }
        });
    }

    @Override
    public void setPresenter(VedioContract.Presenter presenter) {
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

    }

    @Override
    public void showErrorMsg() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void showPopupWindow() {
        View mPopunwindwow = LayoutInflater.from(this).inflate(R.layout.popwindow_bottem, null);
        PopupWindow = new PopupWindow(mPopunwindwow, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        PopupWindow.setContentView(mPopunwindwow);
        LinearLayout lineFacebook = (LinearLayout) mPopunwindwow.findViewById(R.id.facebook);
        LinearLayout linetwitter = (LinearLayout) mPopunwindwow.findViewById(R.id.twitter);
        LinearLayout lineweibo = (LinearLayout) mPopunwindwow.findViewById(R.id.weibo);
        LinearLayout lineweixin = (LinearLayout) mPopunwindwow.findViewById(R.id.weixin);
        LinearLayout linepengyouquan = (LinearLayout) mPopunwindwow.findViewById(R.id.pengyouquan);
        TextView quxiao = (TextView) mPopunwindwow.findViewById(R.id.quxiao);
        lineFacebook.setOnClickListener(this);
        linetwitter.setOnClickListener(this);
        lineweibo.setOnClickListener(this);
        lineweixin.setOnClickListener(this);
        linepengyouquan.setOnClickListener(this);
        quxiao.setOnClickListener(this);
        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.colorWhite));
        PopupWindow.setBackgroundDrawable(dw);
        View rootview = LayoutInflater.from(this).inflate(R.layout.video_avtivity, null);
        PopupWindow.showAtLocation(rootview, Gravity.HORIZONTAL_GRAVITY_MASK, 0, 0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.facebook:
                sharefacebook();
                break;
            case R.id.twitter:
                break;
            case R.id.weibo:
                weibofenxiang();
                break;
            case R.id.weixin:
                share();
                break;
            case R.id.pengyouquan:
                break;
            case R.id.quxiao:
                PopupWindow.dismiss();
                break;
        }
    }

    public void weibofenxiang() {
        UMImage image = new UMImage(VedioActivity.this, R.mipmap.xiongmao);//网络图片
        UMImage thumb = new UMImage(this, R.drawable.logo_ipnda);
        image.setThumb(thumb);

        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
        image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享

        UMWeb web = new UMWeb(url);
        web.setTitle(title);//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription("熊猫频道邀请你一同观看");//描述

        new ShareAction(VedioActivity.this)
                .setPlatform(SHARE_MEDIA.SINA)//传入平台
                .withMedia(web)
                .setCallback(shareListener)//回调监听器
                .share();

    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(VedioActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(VedioActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(VedioActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };


    public void share() {
        //构造一个Intent
        Intent intent = new Intent();
        //分享到微信好友
        ComponentName comp = new ComponentName("com.tencent.mm",
                "com.tencent.mm.ui.tools.ShareImgUI");
        //微信分享页面组件分享到朋友圈
        //  ComponentName comp = new ComponentName("com.tencent.mm",
        //         "ComponentName.comtencent.mm.ui.tools.Sion.SEND");
        intent.setType("image/*");//image上的所有格式hareToTimeLineUI");
        intent.setType("text/plain");
        intent.setComponent(comp);//这个方法与Intent进行通讯
        intent.setAction("android.intent.action.SEND");
        //intent.setFlags(0x3000001);
        intent.putExtra(Intent.EXTRA_STREAM, "熊猫频道");
        Bitmap bt = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.xiongmao);
        final Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bt, null, null));
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(intent);
    }

    public void sharefacebook() {
        //构造一个Intent
        Intent intent = new Intent();
        //分享到微信好友
        ComponentName comp = new ComponentName("com.tencent.mm",
                "com.tencent.mm.ui.tools.ShareImgUI");
        //微信分享页面组件分享到朋友圈
        //  ComponentName comp = new ComponentName("com.tencent.mm",
        //         "ComponentName.comtencent.mm.ui.tools.Sion.SEND");
        intent.setType("image/*");//image上的所有格式hareToTimeLineUI");
        intent.setType("text/plain");
        intent.setComponent(comp);//这个方法与Intent进行通讯
        intent.setAction("android.intent.action.SEND");
        //intent.setFlags(0x3000001);
        intent.putExtra(Intent.EXTRA_SUBJECT, "熊猫频道");
        Bitmap bt = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.xiongmao);
        final Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bt, null, null));
        intent.putExtra(Intent.EXTRA_SUBJECT, uri);
        startActivity(intent);
    }
}
