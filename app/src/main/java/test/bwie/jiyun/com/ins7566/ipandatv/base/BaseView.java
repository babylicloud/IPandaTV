package test.bwie.jiyun.com.ins7566.ipandatv.base;

/**
 * Created by INS7566 on 2017/7/27.
 */


public interface BaseView<T> {
    void setPresenter(T t);
    void showProgress();
    void dismissProgress();
    void showAcache();

}
