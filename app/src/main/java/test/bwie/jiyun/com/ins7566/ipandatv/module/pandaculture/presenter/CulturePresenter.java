package test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.presenter;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.culturemodel.Cultureimp;
import test.bwie.jiyun.com.ins7566.ipandatv.model.culturemodel.ICulturemodle;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.bean.PandaCultureBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandaculture.contract.CultureContract;

/**
 * Created by lx on 2017/7/28.
 */

public class CulturePresenter implements CultureContract.Presenter {
    private ICulturemodle cultureimp;
    private CultureContract.View CultureView;

    public CulturePresenter(CultureContract.View CultureView) {
        this.CultureView = CultureView;
        this.CultureView.setPresenter(this);
        cultureimp = new Cultureimp();
    }

    @Override
    public void setVideoURl(String pid) {

    }

    @Override
    public void start() {
        cultureimp.ShowTotal(new INetWorkCallback<PandaCultureBean>() {
            @Override
            public void OnSuccess(PandaCultureBean pandaCultureBean) {
                CultureView.ShowAll(pandaCultureBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {
                CultureView.ShowMsg(ErrorMsg);
            }
        });

    }
}
