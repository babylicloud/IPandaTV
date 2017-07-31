package test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.presenter;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.livechina.LiveChinaImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.livechina.LiveChinaModel;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.bean.ChangchengBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.livechina.contract.LiveChinaContract;

/**
 * Created by INS7566 on 2017/7/29.
 */

public class ChangchengPresenter implements LiveChinaContract.Presenter {
    private LiveChinaModel liveChinaModel;
    private LiveChinaContract.View view;

    public ChangchengPresenter(LiveChinaContract.View livechinaview) {
        this.view = livechinaview;
        this.view.setPresenter(this);
        liveChinaModel = new LiveChinaImpl();
    }
    @Override
    public void setChangcheng(String url) {
    liveChinaModel.getLiveChinaUrl(url, new INetWorkCallback<ChangchengBean>() {
    @Override
    public void OnSuccess(ChangchengBean changchengBean) {
        view.showChangchengFragment(changchengBean);
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
