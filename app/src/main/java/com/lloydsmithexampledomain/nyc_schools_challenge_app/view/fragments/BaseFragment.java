package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.fragment.app.Fragment;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.BaseActivity;

public abstract class BaseFragment extends Fragment {

    protected AlertDialog mDialog;

    protected void showProgressDialog() {
        showInformationalDialog(getString(R.string.please_wait), false);
    }

    protected void showInformationalDialog(String message) {
        showInformationalDialog(message, false);
    }

    protected void showErrorDialog(String message) {
        showInformationalDialog(message, true);
    }

    protected void showInformationalDialog(String message, boolean isError) {
        if (getActivity() != null) {
            DialogInterface.OnClickListener onClickListener = null;
            if (isError) {
                onClickListener = (dialog, which) -> dialog.dismiss();
            }
            ((BaseActivity) getActivity()).showInformationalDialog(message, onClickListener);
        }
    }

    protected void hideDialog() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).hideDialog();
        }
    }

    protected void hideKeyboard(BaseActivity activity) {
        activity.hideKeyboard();
    }

}
