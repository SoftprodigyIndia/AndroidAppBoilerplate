package com.sampleapp.utils;

import android.app.AlertDialog;
import android.content.Context;

import com.sampleapp.R;
import com.sampleapp.interfaces.OnDialogButtonClickListener;

/**
 * contains Dialogs to be used in the application
 */
public class DialogsUtil {

    /**
     * Return an alert dialog
     *
     * @param message  message for the alert dialog
     * @param listener listener to trigger selection methods
     */
    public void openAlertDialog(Context context, String message, String positiveBtnText, String negativeBtnText,
                                final OnDialogButtonClickListener listener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton(positiveBtnText, (dialog, which) -> {
            dialog.dismiss();
            listener.onPositiveButtonClicked();

        });

        builder.setNegativeButton(negativeBtnText, (dialog, which) -> {
            dialog.dismiss();
            listener.onNegativeButtonClicked();

        });
        builder.setTitle(context.getResources().getString(R.string.app_name));
        builder.setMessage(message);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setCancelable(false);
        builder.create().show();
    }
}