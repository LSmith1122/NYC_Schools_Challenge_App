package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.databinding.FragmentDetailsBinding;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.IDetailsFragment;

public class DetailsFragment extends BaseFragment implements IDetailsFragment {

    private static final String TAG = "DetailsFragment";
    private FragmentDetailsBinding mBinding;
    private ISchoolData mCompleteSchoolData;

    public DetailsFragment() {}

    public static DetailsFragment newInstance(ISchoolData completeSchoolData) {
        DetailsFragment fragment = new DetailsFragment();
        fragment.setCompleteSchoolData(completeSchoolData);
        return fragment;
    }

    @Override
    public void setCompleteSchoolData(ISchoolData completeSchoolData) {
        mCompleteSchoolData = completeSchoolData;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentDetailsBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

}
