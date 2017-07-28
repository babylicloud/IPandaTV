package test.bwie.jiyun.com.ins7566.ipandatv.widget.manger;

import android.util.Log;

/**
 * Created by INS7566 on 2017/7/27.
 */

public class MyLog {
    private static boolean isOpen = true;
    public static void e(String tag,String meg){
        if(isOpen) {
            Log.e(tag,meg);
        }
    }
}
