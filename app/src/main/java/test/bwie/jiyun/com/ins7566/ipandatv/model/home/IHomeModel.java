package test.bwie.jiyun.com.ins7566.ipandatv.model.home;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.BaseModel;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;

/**
 * Created by lx on 2017/7/11.
 * 处理业务逻辑（数据读写）
 */

public interface IHomeModel extends BaseModel {
//    void getTotallabel(INetWorkCallback<PandaBean> callback);

    //首页轮播图接口
    void getHomePageLunBo(INetWorkCallback<HomePageBean> callback);

//    //登陆
//    void Login(String user, String pwd, INetWorkCallback<LoginBean> callback);
//
//    //获取手机验证码
//    void getYzm(String name, String imgYzm, INetWorkCallback callback);
//
//    //注册  找回密码
//    void getRegister(String name, String Yzm, String Pwd, INetWorkCallback callback);
//
//    //获取图片验证码
//    void getPicture(INetWorkCallback callback);
//
//    //邮箱注册
//    void getEmailRegister(String name, String Yzm, String Pwd, INetWorkCallback callback);
//
//    void version(INetWorkCallback<UpdateBean> callback);
}
