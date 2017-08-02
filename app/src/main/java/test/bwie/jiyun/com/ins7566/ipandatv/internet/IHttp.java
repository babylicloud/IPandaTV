package test.bwie.jiyun.com.ins7566.ipandatv.internet;

import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NNetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.NetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.module.home.bean.UpdateBean;

/**
 * Created by INS7566 on 2017/7/27.
 */

public interface IHttp {
    <T> void get(String url, Map<String, String> params, INetWorkCallback<T> callback);

    <T> void post(String url, Map<String, String> params, INetWorkCallback<T> callback);
    //登陆 图片验证码
    <T> void doget(String url, Map<String, String> params, NetWorkCallback callback);

    //获取手机验证码
    <T> void getSjYam(String url, Map<String, String> params, NNetWorkCallback callback);

    //手机号注册
    <T> void Register(String url, Map<String, String> params, NNetWorkCallback callback);
    //邮箱注册
    <T> void EmailRegister(String url, Map<String, String> params, NNetWorkCallback callback);
    //版本更新
    <T> void DownLoad(String url,Map<String, String> params,INetWorkCallback<UpdateBean> callback);
}
