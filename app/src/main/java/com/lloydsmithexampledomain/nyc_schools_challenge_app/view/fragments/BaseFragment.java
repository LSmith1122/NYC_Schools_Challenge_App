package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.app.AlertDialog;

import androidx.fragment.app.Fragment;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.BaseActivity;

public abstract class BaseFragment extends Fragment {

    protected AlertDialog mDialog;

    protected void showProgressDialog() {
        showInformationalDialog(getString(R.string.please_wait));
    }

    protected void showInformationalDialog(String message) {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showInformationalDialog(message);
        }
    }

    protected AlertDialog.Builder createInformationalDialog(String message, boolean isCancelable) {
        if (getActivity() != null) {
            return ((BaseActivity) getActivity()).createInformationalDialog(message, isCancelable);
        }
        return null;
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
