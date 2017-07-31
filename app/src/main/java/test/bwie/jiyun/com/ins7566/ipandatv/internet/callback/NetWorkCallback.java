package test.bwie.jiyun.com.ins7566.ipandatv.internet.callback;

import android.graphics.drawable.Drawable;

/**
 * Created by lx on 2017/7/21.
 */

public interface NetWorkCallback {
    void OnSucess(Drawable drawable);

    void OnError(int ErrorCode, String ErrorMsg);
}
