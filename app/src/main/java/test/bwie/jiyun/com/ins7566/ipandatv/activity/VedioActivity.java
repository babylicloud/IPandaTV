package test.bwie.jiyun.com.ins7566.ipandatv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

public class VedioActivity extends BaseActivity implements VedioContract.View {
    @BindView(R.id.custom_videoplayer_standard_with_share_button)
    JCVideoPlayerStandard jcVideoPlayerStandard;
    private VedioContract.Presenter presenter;
    private String pid, title,image;
    private android.widget.PopupWindow PopupWindow;
    private String url;
    private Boolean flag = true;
    @Override
    protected int getLayoutId() {
        return R.layout.video_avtivity;
    }

    @Override
    protected void initView() {
         presenter=new VedioPresenter(this);
        Intent intent = getIntent();

        pid = intent.getStringExtra("pid");
        title = intent.getStringExtra("title");
        image = intent.getStringExtra("image");
        MyLog.e("aaa",title+image);

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
        jcVideoPlayerStandard.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
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
        this.presenter=presenter;
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

}
