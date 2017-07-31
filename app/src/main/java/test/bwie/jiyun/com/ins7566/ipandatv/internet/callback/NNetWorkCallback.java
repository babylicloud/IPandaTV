package test.bwie.jiyun.com.ins7566.ipandatv.internet.callback;

/**
 * Created by lx on 2017/7/21.
 */

public interface NNetWorkCallback {


    void OnSuccess(String s);
    void OnError(int ErrorCode, String ErrorMsg);
}
