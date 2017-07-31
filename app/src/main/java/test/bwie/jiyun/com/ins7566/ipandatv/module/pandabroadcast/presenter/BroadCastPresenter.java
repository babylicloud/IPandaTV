package test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.presenter;

import test.bwie.jiyun.com.ins7566.ipandatv.internet.callback.INetWorkCallback;
import test.bwie.jiyun.com.ins7566.ipandatv.model.broatcast.BroadCastImpl;
import test.bwie.jiyun.com.ins7566.ipandatv.model.broatcast.IBroadCast;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.bean.BroadHeaderBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.bean.PandaBroadBean;
import test.bwie.jiyun.com.ins7566.ipandatv.module.pandabroadcast.contract.BroadCastContract;
import test.bwie.jiyun.com.ins7566.ipandatv.widget.manger.MyLog;

/**
 * Created by INS7566 on 2017/7/28.
 */

public class BroadCastPresenter implements BroadCastContract.Presenter {
    private IBroadCast bobaoModel;
    private BroadCastContract.View BobaoView;

    public BroadCastPresenter(BroadCastContract.View BobaoView) {
        this.BobaoView = BobaoView;
        this.BobaoView.setPresenter(this);
        bobaoModel = new BroadCastImpl();
    }

    @Override
    public void start() {
        bobaoModel.getPandaObserveItem(new INetWorkCallback<PandaBroadBean>() {

            @Override
            public void OnSuccess(PandaBroadBean pandaBroadBean) {
                BobaoView.setResult(pandaBroadBean);
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

                BobaoView.showAcache();
            }
        });
        bobaoModel.getPandaObserveHead(new INetWorkCallback<BroadHeaderBean>() {

            @Override
            public void OnSuccess(BroadHeaderBean broadHeaderBean) {
                BobaoView.setResultHeadler(broadHeaderBean);
                MyLog.e("aaa",broadHeaderBean.getData().getBigImg().toString());
            }

            @Override
            public void OnError(int ErrorCode, String ErrorMsg) {

            }
        });
    }
}
