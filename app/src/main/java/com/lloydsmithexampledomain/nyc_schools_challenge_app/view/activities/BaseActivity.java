package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseActivity extends AppCompatActivity {

    protected AlertDialog mDialog;

    public void showProgressDialog() {
        showInformationalDialog(getString(R.string.please_wait));
    }

    public void showInformationalDialog(String message) {
        mDialog = createInformationalDialog(message, false).create();
        if (mDialog != null) {
            mDialog.show();
        }
    }

    public AlertDialog.Builder createInformationalDialog(String message, boolean isCancelable) {
        return createInformationalDialog(message, isCancelable, null, null);
    }

    public AlertDialog.Builder createInformationalDialog(String message,
                                                         boolean isCancelable,
                                                         DialogInterface.OnClickListener positive,
                                                         DialogInterface.OnClickListener negative) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        if (StringUtils.isBlank(message)) {
            return null;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(message)
                .setCancelable(isCancelable);

        if (positive != null) {
            builder.setPositiveButton(getString(R.string.yes), positive);
        }
        if (negative != null) {
            builder.setPositiveButton(getString(R.string.no), negative);
        }
        if (positive == null && negative == null) {
            builder.setNeutralButton(R.string.ok, (dialog, which) -> dialog.dismiss());
        }
        return builder;
    }

    public void hideDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            View view = getCurrentFocus();
            if (view == null) {
                view = new View(this);
            }
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
