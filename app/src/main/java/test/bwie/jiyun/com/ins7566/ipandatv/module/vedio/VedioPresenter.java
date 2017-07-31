package test.bwie.jiyun.com.ins7566.ipandatv.module.vedio;

import java.util.HashMap;
import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.vedio.IVedio;
import test.bwie.jiyun.com.ins7566.ipandatv.model.vedio.VedioImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.module.vedio.bean.VideoStartBean;

/**
 * Created by INS7566 on 2017/7/31.
 */

public class VedioPresenter implements VedioContract.Presenter {
    private VedioContract.View view;
    private IVedio livemodel;
    public VedioPresenter(VedioContract.View view){
        this.view=view;
        view.setPresenter(this);
        this.livemodel=new VedioImpl();
    }
    @Override
    public void setVideoURl(String pid) {
        Map<String,String> map=new HashMap<>();
        map.put("pid",pid);
        livemodel.getVDJCYK(map, new INetWorkCallback<VideoStartBean>() {

            @Override
            public void OnSuccess(VideoStartBean videoStartBean) {
                view.showlivevedioFragment(videoStartBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }

    @Override
    public void start() {

    }
}
