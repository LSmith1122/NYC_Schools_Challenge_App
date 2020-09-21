package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.databinding.FragmentResultsBinding;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.di.components.DaggerSearchPresenterComponent;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.adapters.SchoolResultsAdapter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.IResultsFragmentView;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class ResultsFragment extends BaseFragment implements IResultsFragmentView {

    private static final String TAG = "ResultsFragment";
    protected static final String ARG_SEARCH_PARAMS = "arg_search_params";
    protected FragmentResultsBinding mBinding;
    protected ISearchListener mListener;
    protected ISearchParams mSearchParams;

    @Inject
    ISearchPresenter mSearchPresenter;

    public ResultsFragment() {}

    public static ResultsFragment newInstance(ISearchParams searchParams, ISearchListener listener) {
        Bundle bundle = new Bundle();
        ResultsFragment fragment = new ResultsFragment();
        bundle.putSerializable(ARG_SEARCH_PARAMS, searchParams);
        fragment.setArguments(bundle);
        fragment.setSearchListener(listener);
        return fragment;
    }

    @Override
    public void updateResults(ISearchParams searchParams) {
        showProgressDialog();
        if (searchParams != null) {
            mSearchParams = searchParams;
            mSearchPresenter.searchForSchools(mSearchParams);
        } else {
            onSchoolSearchError(null, 500);
        }
    }

    @Override
    public void onSchoolSearchComplete(List<ISchoolData> schoolDataList) {
        hideDialog();
        if (schoolDataList == null || schoolDataList.isEmpty()) {
            showErrorDialog(getString(R.string.error_unexpected_error));
            return;
        }
        SchoolResultsAdapter adapter = new SchoolResultsAdapter(getContext(), schoolDataList);
        adapter.setItemClickListener(schoolData -> {
            showProgressDialog();
            mSearchPresenter.searchForACTData(schoolData.getDbn());
        });
        mBinding.resultsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.resultsRecyclerview.setAdapter(adapter);
    }

    @Override
    public void onSATDetailsSearchComplete(ISchoolData completeSchoolData) {
        hideDialog();
        if (mListener != null) {
            mListener.onCompleteDetailsRetrieved(completeSchoolData);
        }
    }

    @Override
    public void onNoSATDetailsFound(ISchoolData schoolData) {
        // No Data found for DBN - rare, I know...
        hideDialog();
        Toast.makeText(getContext(), "No SAT Data found", Toast.LENGTH_SHORT).show();
        if (mListener != null) {
            mListener.onCompleteDetailsRetrieved(schoolData);
        }
    }

    @Override
    public void onSchoolSearchError(String errorMessage, int httpCode) {
        if (StringUtils.isBlank(errorMessage)) {
            errorMessage = getString(R.string.error_unexpected_error);
        }
        showErrorDialog(String.format(Locale.getDefault(), "%s\n\nResponse Code: %d", errorMessage, httpCode));
    }

    @Override
    public void setSearchListener(ISearchListener searchListener) {
        this.mListener = searchListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSearchPresenterComponent.builder().build().inject(this);
        mSearchPresenter.setResultsFragmentView(this);
        if (getArguments() != null && getArguments().containsKey(ARG_SEARCH_PARAMS)) {
            this.mSearchParams = (ISearchParams) getArguments().getSerializable(ARG_SEARCH_PARAMS);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentResultsBinding.inflate(inflater, container, false);
        mBinding.helpButton.setOnClickListener(v -> showInformationalDialog(getString(R.string.results_help), true));
        updateResults(mSearchParams);
        return mBinding.getRoot();
    }
}