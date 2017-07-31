package test.bwie.jiyun.com.ins7566.ipandatv.module.home.gerenzhongxin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.bwie.jiyun.com.ins7566.ipandatv.R;
import test.bwie.jiyun.com.ins7566.ipandatv.base.BaseActivity;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.LoginBean;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.acache.ACache;


/**
 * Created by lx on 2017/7/22.
 * 个人中心
 */

public class Person_InfoActivity extends BaseActivity {
    @BindView(R.id.entry)
    ImageView entry;
    @BindView(R.id.panda_person_userimg)
    ImageView pandaPersonUserimg;
    @BindView(R.id.panda_person_img)
    RelativeLayout pandaPersonImg;
    @BindView(R.id.entry1)
    ImageView entry1;
    @BindView(R.id.panda_person_guankan)
    TextView pandaPersonGuankan;
    @BindView(R.id.panda_person_nicheng)
    RelativeLayout pandaPersonNicheng;
    @BindView(R.id.panda_person_tuichu)
    Button pandaPersonTuichu;
    @BindView(R.id.Login_Finish_Person)
    ImageView LoginFinishPerson;
    private LoginBean loginBean;
    private Bitmap head;// 头像Bitmap
    private static String path = "/sdcard/myHead/";// sd路径
    private PopupWindow popupWindow;
    private Button mButPhoto, mButPz, mButCancel;

    @Override
    protected int getLayoutId() {
        return R.layout.panda_person_personinfo;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        Intent in = getIntent();
        ACache acache = ACache.get(this);
        loginBean = (LoginBean) acache.getAsObject("loginentity");
        String userName = in.getStringExtra("userName");
        if (userName.equals("点击登录")) {

        } else {
            pandaPersonGuankan.setText(userName);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Login_Finish_Person, R.id.panda_person_nicheng, R.id.panda_person_tuichu, R.id.panda_person_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Login_Finish_Person:
                finish();
                break;
            case R.id.panda_person_nicheng:
                Intent intent = new Intent(this, PersonAmendActivity.class);
                String s = pandaPersonGuankan.getText().toString();
                intent.putExtra("info", s);
                startActivity(intent);
                break;
            case R.id.panda_person_tuichu:
                ACache acache = ACache.get(this);
                acache.remove("loginentity");
                Intent in = getIntent();
                in.putExtra("edit", "点击登录");
                setResult(300, in);
                finish();
                break;
            case R.id.panda_person_img:
                init();
                popwindow();
                break;
        }
    }

    /**
     * 判断是否有存储卡，有返回TRUE，否则FALSE
     *
     * @return
     */
    public static boolean isSDcardExist() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }


    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
        startActivityForResult(intent2, 2);// 采用ForResult打开
        popupWindow.dismiss();
    }


    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }

    private void init() {

        Bitmap bt = BitmapFactory.decodeFile(path + "head.jpg");// 从SD卡中找头像，转换成Bitmap
        if (bt != null) {
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bt);// 转换成drawable
            pandaPersonUserimg.setImageDrawable(drawable);
        } else {
            /**
             * 如果SD里面没有则需要从服务器取头像，取回来的头像再保存在SD中
             *
             */
        }
    }

    public void popwindow() {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(this).inflate(
                R.layout.add_popup_dialog, null);
        popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);// 取得焦点
        ColorDrawable colorDrawable = new ColorDrawable(0x30000000);
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(colorDrawable);
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        mButPhoto = (Button) view.findViewById(R.id.add_photo);
        mButPz = (Button) view.findViewById(R.id.add_pz);
        mButCancel = (Button) view.findViewById(R.id.add_cancel);

        mButPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 从本地相册选取图片作为头像
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 1);
                popupWindow.dismiss();
            }
        });
        mButPz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choseHeadImageFromCameraCapture();
            }
        });
        mButCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }
//    name.setText(intent.getStringExtra("updatena"));

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());// 裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }

                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {
                        /**
                         * 上传服务器代码
                         */
                        setPicToView(head);// 保存在SD卡中
                        pandaPersonUserimg.setImageBitmap(head);// 用ImageView显示出来
                    }
                }
                break;
            default:
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 调用系统的裁剪功能
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }

    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
