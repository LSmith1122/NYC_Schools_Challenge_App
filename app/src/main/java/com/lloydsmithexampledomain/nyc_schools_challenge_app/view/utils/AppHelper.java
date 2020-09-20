package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;

import org.apache.commons.lang3.StringUtils;

public class AppHelper {

    protected static AlertDialog mDialog;

    public static AlertDialog getDialog() {
        return mDialog;
    }

    public static void showProgressDialog(Context context) {
        showInformationalDialog(context, context.getString(R.string.please_wait));
    }

    public static void showInformationalDialog(Context context, String message) {
        showInformationalDialog(context, message, null);
    }

    public static void showInformationalDialog(Context context, String message, DialogInterface.OnClickListener neutral) {
        mDialog = createInformationalDialog(context, message, false, null, neutral, null).create();
        if (mDialog != null) {
            mDialog.show();
        }
    }

    public static AlertDialog.Builder createInformationalDialog(Context context, String message, boolean isCancelable) {
        return createInformationalDialog(context, message, isCancelable, null, null);
    }

    public static AlertDialog.Builder createInformationalDialog(Context context, String message,
                                                         boolean isCancelable,
                                                         DialogInterface.OnClickListener positive,
                                                         DialogInterface.OnClickListener negative) {
        return createInformationalDialog(context, message, isCancelable, positive, null, negative);
    }

    public static AlertDialog.Builder createInformationalDialog(Context context, String message,
                                                         boolean isCancelable,
                                                         DialogInterface.OnClickListener positive,
                                                         DialogInterface.OnClickListener neutral,
                                                         DialogInterface.OnClickListener negative) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        if (StringUtils.isBlank(message)) {
            return null;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(message)
                .setCancelable(isCancelable);

        if (positive != null) {
            builder.setPositiveButton(context.getString(R.string.yes), (dialog, which) -> {
                positive.onClick(dialog, which);
                dialog.dismiss();
            });
        }
        if (negative != null) {
            builder.setNegativeButton(context.getString(R.string.no), (dialog, which) -> {
                negative.onClick(dialog, which);
                dialog.dismiss();
            });
        }
        if (neutral != null) {
            builder.setNeutralButton(R.string.ok, (dialog, which) -> {
                neutral.onClick(dialog, which);
                dialog.dismiss();
            });
        }
        return builder;
    }

    public static void hideDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        mDialog = null;
    }

}
