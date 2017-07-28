package test.bwie.jiyun.com.ins7566.ipandatv.utils;

import android.app.Dialog;
import android.content.Context;

import test.bwie.jiyun.com.ins7566.ipandatv.App;
import test.bwie.jiyun.com.ins7566.ipandatv.R;

/**
 * Created by INS7566 on 2017/7/27.
 */

public class ShowDialog extends Dialog{
    private static ShowDialog showDialog;

    private Dialog loadDialog;

    public ShowDialog(Context context) {
        super(context);
    }

    public ShowDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ShowDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    public static ShowDialog getInsent() {
        if (showDialog == null) {
            synchronized (ShowDialog.class) {
                if (showDialog == null) {
                    showDialog = new ShowDialog(App.context);
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
        if(showDialog!=null&&showDialog.isShowing()) {
            loadDialog.dismiss();
        }
        return this;
    }
}
