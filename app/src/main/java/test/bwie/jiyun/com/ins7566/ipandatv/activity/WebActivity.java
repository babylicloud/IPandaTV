package test.bwie.jiyun.com.ins7566.ipandatv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;

/**
 * Created by Lenovo on 2017/7/13.
 */
public class WebActivity extends BaseActivity{
//    implements View.OnClickListener
    @BindView(R.id.WebView)
    WebView WebView;
    @BindView(R.id.Shoucang)
    CheckBox Shoucang;
    @BindView(R.id.Fenxiang)
    ImageView Fenxiang;
    private String rurl;
    private PopupWindow PopupWindow;
//    private Dao<JiluDao,Integer> dao;
    private Boolean flag = true;
    private String pid, title,image;
    @Override
    protected int getLayoutId() {
        return R.layout.webview_activity;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        Intent intent = getIntent();
        title =intent.getStringExtra("title");
        rurl = intent.getStringExtra("url");
//        MyLog.e("URL",rurl);


        WebView.loadUrl(rurl);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        WebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Shoucang, R.id.Fenxiang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Shoucang:
//                if(flag) {
//                    JiluDao jiluDao = new JiluDao();
//                    jiluDao.setTitle(title);
//                    jiluDao.setImageurl(image);
//                    try {
//                        int i = dao.create(jiluDao);
//                        Log.e("AAA", "插入了" + i + "条数据");
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    flag = false;
//
//                }else{
//                    DeleteBuilder deleteBuilder = dao.deleteBuilder();
//                    try {
//                        deleteBuilder.where().eq("title",title);
//                        deleteBuilder.delete();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    flag =true;
//                }

                Toast.makeText(WebActivity.this, "你已添加到我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Fenxiang:
//                showPopupWindow();
                break;
        }
    }
//    public void showPopupWindow() {
//        View mPopunwindwow = LayoutInflater.from(this).inflate(R.layout.popwindow_bottem, null);
//        PopupWindow = new PopupWindow(mPopunwindwow, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
//        PopupWindow.setContentView(mPopunwindwow);
//        LinearLayout lineFacebook = (LinearLayout) mPopunwindwow.findViewById(R.id.facebook);
//        LinearLayout linetwitter = (LinearLayout) mPopunwindwow.findViewById(R.id.twitter);
//        LinearLayout lineweibo = (LinearLayout) mPopunwindwow.findViewById(R.id.weibo);
//        LinearLayout lineweixin = (LinearLayout) mPopunwindwow.findViewById(R.id.weixin);
//        LinearLayout linepengyouquan = (LinearLayout) mPopunwindwow.findViewById(R.id.pengyouquan);
//        TextView quxiao= (TextView) mPopunwindwow.findViewById(R.id.quxiao);
//        lineFacebook.setOnClickListener(this);
//        linetwitter.setOnClickListener(this);
//        lineweibo.setOnClickListener(this);
//        lineweixin.setOnClickListener(this);
//        linepengyouquan.setOnClickListener(this);
//        quxiao.setOnClickListener(this);
//
//        ColorDrawable dw = new ColorDrawable(this.getResources().getColor(R.color.colorWhite));
//        PopupWindow.setBackgroundDrawable(dw);
//        View rootview = LayoutInflater.from(this).inflate(R.layout.rollvideo_details, null);
//        PopupWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
//
//
//    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.facebook:
//                sharefacebook();
//                break;
//            case R.id.twitter:
//                break;
//            case R.id.weibo:
//                weibofenxiag();
//                break;
//            case R.id.weixin:
//                share();
//                break;
//            case R.id.pengyouquan:
//                break;
//            case R.id.quxiao:
//                PopupWindow.dismiss();
//                break;
//        }
//
//    }

//    public void weibofenxiag() {
//        UMImage image = new UMImage(WebActivity.this,R.mipmap.xiongmao);//网络图片
//        UMImage thumb =  new UMImage(this, R.drawable.logo_ipnda);
//        image.setThumb(thumb);
//
//        image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
//        image.compressStyle = UMImage.CompressStyle.QUALITY;//质量压缩，适合长图的分享
//
//        UMWeb web = new UMWeb(rurl);
//        web.setTitle("熊猫频道");//标题
//        web.setThumb(thumb);  //缩略图
//        web.setDescription("熊猫频道邀请你一同观看");//描述
//
//        new ShareAction(WebActivity.this)
//                .setPlatform(SHARE_MEDIA.SINA)//传入平台
//                .withMedia(web)
//                .setCallback(shareListener)//回调监听器
//                .share();
//
//    }
//    private UMShareListener shareListener = new UMShareListener() {
//        /**
//         * @descrption 分享开始的回调
//         * @param platform 平台类型
//         */
//        @Override
//        public void onStart(SHARE_MEDIA platform) {
//
//        }
//
//        /**
//         * @descrption 分享成功的回调
//         * @param platform 平台类型
//         */
//        @Override
//        public void onResult(SHARE_MEDIA platform) {
//            Toast.makeText(WebActivity.this,"成功了",Toast.LENGTH_LONG).show();
//        }
//
//        /**
//         * @descrption 分享失败的回调
//         * @param platform 平台类型
//         * @param t 错误原因
//         */
//        @Override
//        public void onError(SHARE_MEDIA platform, Throwable t) {
//            Toast.makeText(WebActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
//        }
//
//        /**
//         * @descrption 分享取消的回调
//         * @param platform 平台类型
//         */
//        @Override
//        public void onCancel(SHARE_MEDIA platform) {
//            Toast.makeText(WebActivity.this,"取消了",Toast.LENGTH_LONG).show();
//        }
//    };
//
//
//
//    public void share(){
//        //构造一个Intent
//        Intent intent = new Intent();
//        //分享到微信好友
//        ComponentName comp = new ComponentName("com.tencent.mm",
//                "com.tencent.mm.ui.tools.ShareImgUI");
//        //微信分享页面组件分享到朋友圈
//        //  ComponentName comp = new ComponentName("com.tencent.mm",
//        //         "ComponentName.comtencent.mm.ui.tools.Sion.SEND");
//        intent.setType("image/*");//image上的所有格式hareToTimeLineUI");
//        intent.setType("text/plain");
//        intent.setComponent(comp);//这个方法与Intent进行通讯
//        intent.setAction("android.intent.action.SEND");
//        //intent.setFlags(0x3000001);
//        intent.putExtra(Intent.EXTRA_STREAM,"熊猫频道");
//        Bitmap bt= BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.xiongmao);
//        final Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(),bt , null,null));
//        intent.putExtra(Intent.EXTRA_STREAM, uri);
//        startActivity(intent);
//    }
//
//    public void sharefacebook(){
//        //构造一个Intent
//        Intent intent = new Intent();
//        //分享到微信好友
//        ComponentName comp = new ComponentName("com.tencent.mm",
//                "com.tencent.mm.ui.tools.ShareImgUI");
//        //微信分享页面组件分享到朋友圈
//        //  ComponentName comp = new ComponentName("com.tencent.mm",
//        //         "ComponentName.comtencent.mm.ui.tools.Sion.SEND");
//        intent.setType("image/*");//image上的所有格式hareToTimeLineUI");
//        intent.setType("text/plain");
//        intent.setComponent(comp);//这个方法与Intent进行通讯
//        intent.setAction("android.intent.action.SEND");
//        //intent.setFlags(0x3000001);
//        intent.putExtra(Intent.EXTRA_SUBJECT,"熊猫频道");
//        Bitmap bt= BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.xiongmao);
//        final Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(),bt , null,null));
//        intent.putExtra(Intent.EXTRA_SUBJECT, uri);
//        startActivity(intent);
//    }


}
