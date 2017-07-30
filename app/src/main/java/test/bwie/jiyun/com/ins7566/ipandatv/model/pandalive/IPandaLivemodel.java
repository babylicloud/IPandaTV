package test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive;

import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.BaseModel;


/**
 * Created by lx on 2017/7/29.
 */

public interface IPandaLivemodel extends BaseModel {
    //标题栏
    <T> void getTabTitle(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //加载数据
    <T> void getData(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //显示图片
    <T> void showImage(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //大标题
    <T> void gettitle(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //详细信息
    <T> void getDetailInfo(String url, Map<String, String> params, INetWorkCallback<T> callback);


    //边看边聊直播
    <T> void getEyeTitle(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //多视角
    <T> void getLiveFragment(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //边看边聊
    <T> void getEyeFragment(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //精彩一刻
    <T> void getJcyk(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //边看边聊列表
    <T> void getTalkList(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //视频播放
    <T> void vedioPlay(String url, Map<String, String> params, INetWorkCallback<T> callback);

    //jingcaiyike
    //vsid=VSET100272959126    &n=7        &serviceId=panda      &o=desc     &of=time      &p=1
    <T> void livejcyk(String vsid, INetWorkCallback<T> callback);

    //复用fragment
    <T> void liveFragment(INetWorkCallback<T> callback);
}
