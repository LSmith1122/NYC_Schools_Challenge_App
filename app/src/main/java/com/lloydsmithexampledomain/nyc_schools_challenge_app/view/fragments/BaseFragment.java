package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.BaseActivity;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.utils.AppHelper;

public abstract class BaseFragment extends Fragment {

    protected void showProgressDialog() {
        showInformationalDialog(getString(R.string.please_wait), false);
    }

    protected void showProgressDialog(String message) {
        showInformationalDialog(message, false);
    }

    protected void showErrorDialog(String message) {
        showInformationalDialog(message, true);
    }

    protected void showInformationalDialog(String message, boolean isDismissible) {
        if (getContext() != null) {
            DialogInterface.OnClickListener onClickListener = null;
            if (isDismissible) {
                onClickListener = (dialog, which) -> dialog.dismiss();
            }
            AppHelper.showInformationalDialog(getContext(), message, onClickListener);
        }
    }

    protected void showInformationalDialog(String message, DialogInterface.OnClickListener okButtonListener) {
        if (getContext() != null) {
            AppHelper.showInformationalDialog(getContext(), message, okButtonListener);
        }
    }

    protected void hideDialog() {
        if (getActivity() != null && getActivity() instanceof BaseActivity) {
            AppHelper.hideDialog();
        }
    }

    public void hideKeyboard() {
        if (getActivity() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                View view = getActivity().getCurrentFocus();
                if (view == null) {
                    view = new View(getContext());
                }
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

}
