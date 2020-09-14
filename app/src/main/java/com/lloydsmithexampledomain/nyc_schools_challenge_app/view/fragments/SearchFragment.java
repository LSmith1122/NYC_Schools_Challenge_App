package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.databinding.FragmentMainBinding;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.SearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.SearchParams.SearchOption;

public class SearchFragment extends Fragment {

    private static final String ARG_SEARCH_PARAMS = "arg_search_params";

    private FragmentMainBinding mBinding;
    private SearchParams mSearchParams;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSearchParams = (SearchParams) getArguments().getSerializable(ARG_SEARCH_PARAMS);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentMainBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    private void initViews() {
        // Change visibility of search options
        mBinding.mainActivitySearchByRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedItemID) {
                if (checkedItemID == mBinding.mainActivitySearchByNameRadio.getId()) {
                    mSearchParams.setSearchOption(SearchOption.SEARCH_BY_NAME);
                    mBinding.mainContentSearchByNameGroup.setVisibility(View.VISIBLE);
                    mBinding.mainContentSearchByNameGroup.setVisibility(View.GONE);
                } else {
                    mSearchParams.setSearchOption(SearchOption.SEARCH_BY_FILTER);
                    mBinding.mainContentSearchByNameGroup.setVisibility(View.GONE);
                    mBinding.mainContentSearchByNameGroup.setVisibility(View.VISIBLE);
                }
            }
        });

        // Set the default RadioButton for the search options
        mBinding.mainActivitySearchByRadiogroup.check(mBinding.mainActivitySearchByFilterRadio.getId());

        mBinding.mainSearchByNameEdittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                    searchForSchools();
                    return true;
                }
                return false;
            }
        });
    }

    private void searchForSchools() {
        if (mSearchParams.getSearchOption() == null) {
            return;
        }

        if (mSearchParams.getSearchOption() == SearchOption.SEARCH_BY_NAME) {
            // TODO: Finish implementation...

        } else {
            // TODO: Finish implementation...

        }
    }
}