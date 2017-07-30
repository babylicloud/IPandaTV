package test.bwie.jiyun.com.ins7566.ipandatv.utils;

import android.app.Dialog;
import android.content.Context;

import test.bwie.jiyun.com.ins7566.ipandatv.R;

/**
 * Created by INS7566 on 2017/7/27.
 */

public class ShowDialog {
    private static ShowDialog showDialog;
    private Dialog loadDialog;
    public static ShowDialog getInsent() {
        if (showDialog == null) {
            synchronized (ShowDialog.class) {
                if (showDialog == null) {
                    showDialog = new ShowDialog();
                }
            }
        }
        return showDialog;
    }

    public ShowDialog create(Context context) {

        loadDialog = new Dialog(context, R.style.dialog);
        loadDialog.setCanceledOnTouchOutside(false);

        loadDialog.setContentView(R.layout.progressdialog_item);
        loadDialog.show();

        return this;
    }

    public ShowDialog popuUtilsDismiss() {
        if(showDialog!=null) {
            loadDialog.dismiss();
        }
        return this;
    }
}
