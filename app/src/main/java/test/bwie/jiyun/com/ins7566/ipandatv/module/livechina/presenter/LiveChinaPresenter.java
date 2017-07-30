package test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.presenter;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.livechina.LiveChinaImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.livechina.LiveChinaModel;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.bean.PopupBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.contract.LiveChinaContract;

/**
 * Created by INS7566 on 2017/7/29.
 */

public class LiveChinaPresenter implements LiveChinaContract.Presenter {
    private LiveChinaModel liveChinaModel;
    private LiveChinaContract.View view;

    public LiveChinaPresenter(LiveChinaContract.View livechinaview) {
        this.view = livechinaview;
        this.view.setPresenter(this);
        liveChinaModel = new LiveChinaImpl();
    }
    @Override
    public void setChangcheng(String url) {

    }


    @Override
    public void start() {
        liveChinaModel.getLiveChinaTab(new INetWorkCallback<PopupBean>() {
            @Override
            public void OnSuccess(PopupBean popupBean) {
                view.getChinaLiveTab(popupBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });

    }
}
