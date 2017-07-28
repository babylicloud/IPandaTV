package test.bwie.jiyun.com.ins7566.ipandatv.utils;

import android.app.Dialog;
import android.content.Context;

import test.bwie.jiyun.com.ins7566.ipandatv.R;

/**
 * Created by INS7566 on 2017/7/27.
 */

public class ShowDialog {
    private static ShowDialog showPopuUtils;

    private ShowDialog() {
    }

    private Dialog loadDialog;

    public static ShowDialog getInsent() {
        if (showPopuUtils == null) {
            synchronized (ShowDialog.class) {
                if (showPopuUtils == null) {
                    showPopuUtils = new ShowDialog();
                }
            }
        }
        return showPopuUtils;
    }

    public ShowDialog create(Context context) {

        loadDialog = new Dialog(context, R.style.dialog);
        loadDialog.setCanceledOnTouchOutside(false);

        loadDialog.setContentView(R.layout.progressdialog_item);
        loadDialog.show();

        return this;
    }

    public ShowDialog popuUtilsDismiss() {

        loadDialog.dismiss();
        return this;
    }
}
