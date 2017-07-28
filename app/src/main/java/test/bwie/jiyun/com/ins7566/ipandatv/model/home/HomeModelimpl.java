package test.bwie.jiyun.com.ins7566.ipandatv.model.home;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.HomePageBean;

/**
 * Created by lx on 2017/7/11.
 * 业务接口实现类
 */

public class HomeModelimpl implements IHomeModel {

//    @Override
//    public void getTotallabel(INetWorkCallback<PandaBean> callback) {
//        iHttp.get(Urls.TOTALLABELURL, null, callback);
//    }
//
//    @Override
//    public void getHomePageLunBo(INetWorkCallback<HomePageBean> callback) {
//        iHttp.get(Urls.PANDATOTAL, null, callback);
//    }
//
//    //登陆
//    @Override
//    public void Login(String user, String pwd, INetWorkCallback<LoginBean> callback) {
//        Map<String, String> map = new HashMap<>();
//        map.put("username", user);
//        map.put("password", pwd);
//        map.put("from", "https://reg.cntv.cn/login/login.action");
//        map.put("service", "client_transaction");
//        getiHttp.get(Urls.LoginUrl, map, callback);
//    }
//
//    //获取手机验证码
//    @Override
//    public void getYzm(String name, String imgYzm, NNetWorkCallback callback) {
//        Map<String, String> map = new HashMap<>();
//        map.put("mobile", name);
//        map.put("verificationCode", imgYzm);
//        map.put("method", "getRequestVerifiCodeM");
//        map.put("verfiCodeType", "1");
//        getiHttp.getSjYam(Urls.url, map, callback);
//    }
//
//    //注册
//    @Override
//    public void getRegister(String name, String Yzm, String Pwd, NNetWorkCallback callback) {
//        Map<String, String> map = new HashMap<>();
//        map.put("method", "saveMobileRegisterM");
//        map.put("mobile", name);
//        map.put("verfiCode", Yzm);
//        try {
//            map.put("passWd", URLEncoder.encode(Pwd, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        map.put("verfiCodeType", "1");
//        try {
//            map.put("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        getiHttp.Register(Urls.Zcurl, map, callback);
//    }
//
//
//    @Override
//    public void getPicture(NetWorkCallback callback) {
//        getiHttp.doget(Urls.from, null, callback);
//    }
//
//    //邮箱注册
//    @Override
//    public void getEmailRegister(String name, String Yzm, String Pwd, NNetWorkCallback callback) {
//        Map<String, String> map = new HashMap<>();
//        map.put("mailAdd", name);
//        map.put("passWd", Pwd);
//        map.put("verificationCode", Yzm);
//        getiHttp.EmailRegister(Urls.EMILEREGIS, map, callback);
//    }
//
//    @Override
//    public void version(INetWorkCallback<UpdateBean> callback) {
//        HttpFactory.create().get(Urls.UPDATE_URL, null, callback);
//    }

    @Override
    public void getHomePageLunBo(INetWorkCallback<HomePageBean> callback) {
        iHttp.get(Urls.PANDATOTAL, null, callback);
    }
}
