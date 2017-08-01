package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.presenter;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.internet.urls.Urls;
import test.bwie.jiyun.com.ins7566.ipandatv.model.culturemodel.IPandaCulture;
import test.bwie.jiyun.com.ins7566.ipandatv.model.culturemodel.PandaCultureImp;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureVedioBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaTebieBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.contract.CultureContract;

/**
 * Created by lx on 2017/7/30.
 */

public class PandaCultureVideoPresenter implements CultureContract.Presenter {

    private CultureContract.View pandaculture;
    private IPandaCulture pandaCulture;

    public PandaCultureVideoPresenter(CultureContract.View view) {
        this.pandaculture = view;
        this.pandaculture.setPresenter(this);
        pandaCulture = new PandaCultureImp();

    }

    @Override
    public void start() {
        pandaCulture.getculuretebie(Urls.VEDIOCULTURE, null, new INetWorkCallback<PandaTebieBean>() {

            @Override
            public void OnSuccess(PandaTebieBean pandaTebieBean) {
                pandaculture.ShowFirst(pandaTebieBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                pandaculture.ShowMsg(ErrorMsg);
            }
        });

    }

    @Override
    public void setVideoURl(String pid) {
        Map<String, String> map = new HashMap<>();
        map.put("pid", pid);
        pandaCulture.getPandaCultureVideo(map, new INetWorkCallback<PandaCultureVedioBean>() {
            @Override
            public void OnSuccess(PandaCultureVedioBean pandaCultureVedioBean) {
                pandaculture.showVideo(pandaCultureVedioBean);
                Log.d("bbbbbbb", pandaCultureVedioBean.toString());
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }
}
