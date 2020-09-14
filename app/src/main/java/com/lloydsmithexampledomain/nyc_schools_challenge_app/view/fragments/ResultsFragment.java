package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.databinding.FragmentResultsBinding;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.SearchParams;

public class ResultsFragment extends Fragment {

    private static final String ARG_SEARCH_PARAMS = "arg_search_params";
    private SearchParams mSearchParams;
    private FragmentResultsBinding mBinding;

    public ResultsFragment() {
        // Required empty public constructor
    }

    public static ResultsFragment newInstance(SearchParams searchParams) {
        ResultsFragment fragment = new ResultsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SEARCH_PARAMS, searchParams);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSearchParams = (SearchParams) getArguments().getSerializable(ARG_SEARCH_PARAMS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentResultsBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}