package test.bwie.jiyun.com.ins7566.ipandatv.internet.callback;

/**
 * Created by INS7566 on 2017/7/27.
 */

public interface INetWorkCallback<T> {
    void OnSuccess(T t);
    void OnError(int ErrorCode, String ErrorMsg);

}
