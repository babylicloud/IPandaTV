package test.bwie.jiyun.com.ins7566.ipandatv.model.pandalive;

import java.util.HashMap;
import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.HttpFactory;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;


/**
 * Created by lx on 2017/7/29.
 */

public class PandaLiveImpl implements IPandaLivemodel {
    //获得熊猫直播标题
    @Override
    public <T> void getTabTitle(String url, Map<String, String> params, INetWorkCallback<T> callback) {

        HttpFactory.create().get(url,params,callback);
    }

    //获得
    @Override
    public <T> void getData(String url, Map<String, String> params, INetWorkCallback<T> callback) {

        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    //显示图片
    @Override
    public <T> void showImage(String url, Map<String, String> params, INetWorkCallback<T> callback) {

        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    @Override
    public <T> void gettitle(String url, Map<String, String> params, INetWorkCallback<T> callback) {

        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    //获取详细信息
    @Override
    public <T> void getDetailInfo(String url, Map<String, String> params, INetWorkCallback<T> callback) {

        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    //多视角直播标题

    //边看边聊标题
    @Override
    public <T> void getEyeTitle(String url, Map<String, String> params, INetWorkCallback<T> callback) {

        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    //多视角直播
    @Override
    public <T> void getLiveFragment(String url, Map<String, String> params, INetWorkCallback<T> callback) {
        HttpFactory.create().get(Urls.DUOSHIJIAO,params,callback);
    }

    //边看表聊
    @Override
    public <T> void getEyeFragment(String url, Map<String, String> params, INetWorkCallback<T> callback) {
        HttpFactory.create().get(Urls.TALKLIST,params,callback);
    }

    @Override
    public <T> void getJcyk(String url, Map<String, String> params, INetWorkCallback<T> callback) {
        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    @Override
    public <T> void getTalkList(String url, Map<String, String> params, INetWorkCallback<T> callback) {

        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    @Override
    public <T> void vedioPlay(String url, Map<String, String> params, INetWorkCallback<T> callback) {
        HttpFactory.create().get(Urls.PANDALIVE,params,callback);
    }

    //vsid=VSET100272959126    &n=7        &serviceId=panda      &o=desc     &of=time      &p=1
    @Override
    public <T> void livejcyk(String vsid, INetWorkCallback<T> callback) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n","7");
        map.put("serviceId","panda");
        map.put("o","desc");
        map.put("of","time");
        map.put("p","1");
        HttpFactory.create().get(Urls.JCYI,map,callback);

    }

    @Override
    public <T> void liveFragment(INetWorkCallback<T> callback) {
        HttpFactory.create().get(Urls.PANDAJCYK,null,callback);
    }

}
