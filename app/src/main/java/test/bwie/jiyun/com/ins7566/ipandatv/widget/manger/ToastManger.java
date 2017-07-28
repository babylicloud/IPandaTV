package test.bwie.jiyun.com.ins7566.ipandatv.widget.manger;

import android.widget.Toast;

import test.bwie.jiyun.com.ins7566.ipandatv.App;

/**
 * Created by INS7566 on 2017/7/27.
 */


public class ToastManger {
    public static void show(String msg){
       Toast.makeText(App.context,msg,Toast.LENGTH_SHORT);
    }
}
