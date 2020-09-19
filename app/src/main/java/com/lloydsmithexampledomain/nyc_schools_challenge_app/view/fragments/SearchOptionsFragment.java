package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.databinding.FragmentSearchOptionsBinding;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.models.SearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.FilterByOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.LimitTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SortByOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.BaseActivity;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.ISearchOptionsFragmentView;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class SearchOptionsFragment extends BaseFragment implements ISearchOptionsFragmentView {

    public static final String TAG = "MainFragment";

    private FragmentSearchOptionsBinding mBinding;
    private SearchParams mSearchParams;
    private String[] mSortByItems;
    private String[] mFilterByItems;
    private String[] mLimitByItems;
    private String[] mResultsMaxCountItems;
    private ISearchListener mListener;
    private TextView.OnEditorActionListener mOnEditorActionListenerForSearch = (textView, actionID, keyEvent) -> {
        if (actionID == EditorInfo.IME_ACTION_SEARCH) {
            if (getActivity() instanceof BaseActivity) {
                hideKeyboard((BaseActivity) getActivity());
            }
            searchForSchools();
            return true;
        }
        return false;
    };
    private TextView.OnEditorActionListener mOnEditorActionListenerDefault = (textView, actionID, keyEvent) -> {
        if (actionID == EditorInfo.IME_ACTION_DONE && getActivity() instanceof BaseActivity) {
            hideKeyboard((BaseActivity) getActivity());
            return true;
        }
        return false;
    };

    public SearchOptionsFragment() {}

    void initValues() {
        if (getActivity() != null && getActivity().getResources() != null) {
            mSortByItems = getDisplayNamesForSortByOption();
            mFilterByItems = getDisplayNamesForFilterByOption();
            mLimitByItems = getDisplayNamesForLimitTypeOption();
            int[] intArray = getActivity().getResources().getIntArray(R.array.result_max_count);
            mResultsMaxCountItems = new String[intArray.length];
            for (int index = 0; index < intArray.length; index++) {
                if (index == 0) {
                    mResultsMaxCountItems[index] = getString(R.string.unlimited);
                    continue;
                }
                mResultsMaxCountItems[index] = String.valueOf(intArray[index]);
            }
        }
    }

    void initViews() {
        // Change visibility of search options
        mBinding.mainActivitySearchByRadiogroup.setOnCheckedChangeListener((radioGroup, checkedItemID) -> {
            if (checkedItemID == mBinding.mainActivitySearchByNameRadio.getId()) {
                mSearchParams = new SearchParams();
                mSearchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_NAME);
                populateSearchOptions(false);
                mBinding.mainContentSearchByNameGroup.setVisibility(View.VISIBLE);
                mBinding.mainContentSearchByFilterGroup.setVisibility(View.GONE);
            } else {
                mSearchParams = new SearchParams();
                mSearchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_FILTER);
                populateSearchOptions(false);
                mBinding.mainContentSearchByNameGroup.setVisibility(View.GONE);
                mBinding.mainContentSearchByFilterGroup.setVisibility(View.VISIBLE);
            }
        });

        // Set the default RadioButton for the search options
        mBinding.mainActivitySearchByRadiogroup.check(mBinding.mainActivitySearchByFilterRadio.getId());

        // Set OnEditorActionListeners for Special Actions on EditTexts
        mBinding.mainSearchByNameEdittext.setOnEditorActionListener(mOnEditorActionListenerForSearch);
        mBinding.mainActivityFilterLimitByEdittext.setOnEditorActionListener(mOnEditorActionListenerDefault);
        mBinding.mainActivityFilterFilterByEdittext.setOnEditorActionListener(mOnEditorActionListenerForSearch);

        // Initialize Spinners
        initSpinner(mBinding.mainActivityFilterSortByDropdown, mSortByItems);
        initSpinner(mBinding.mainActivityFilterFilterByDropdown, mFilterByItems);
        initSpinner(mBinding.mainActivityFilterLimitByDropdown, mLimitByItems);
        initSpinner(mBinding.mainActivityFilterResultCountDropdown, mResultsMaxCountItems);
        setOnDropDownItemSelectedListener(mBinding.mainActivityFilterSortByDropdown, mSortByItems);
        setOnDropDownItemSelectedListener(mBinding.mainActivityFilterFilterByDropdown, mFilterByItems);
        setOnDropDownItemSelectedListener(mBinding.mainActivityFilterLimitByDropdown, mLimitByItems);
        setOnDropDownItemSelectedListener(mBinding.mainActivityFilterResultCountDropdown, mResultsMaxCountItems);

        mBinding.mainSearchByNameEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No op...
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No op...
            }

            @Override
            public void afterTextChanged(Editable input) {
                if (input == null || StringUtils.isBlank(input.toString())) {
                    return;
                }

                mSearchParams.setSchoolNameQuery(input.toString());
            }
        });

        // Click listener for search button
        mBinding.mainSearchButton.setOnClickListener((v) -> searchForSchools());
    }

    private void initSpinner(Spinner spinner, String[] items) {
        spinner.setSelection(0);
        spinner.setAdapter(getSpinnerAdapter(items));
    }

    private ArrayAdapter<String> getSpinnerAdapter(String[] items) {
        return new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                items);
    }

    private void setOnDropDownItemSelectedListener(Spinner spinner, final String[] items) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mSearchParams == null) {
                    return;
                }
                if (position == 0 && items != mResultsMaxCountItems || position < 0) {
                    mSearchParams.setResultMaxCount(null);
                    mSearchParams.setSortByOption(null);
                    mSearchParams.setFilterByOption(null);
                    mSearchParams.setLimitByOption(null);
                    return;
                }

                if (items == mResultsMaxCountItems) {
                    int item = position == 0 ? -1 : Integer.parseInt(mResultsMaxCountItems[position]);
                    mSearchParams.setResultMaxCount(item);
                } else if (items == mSortByItems) {
                    mSearchParams.setSortByOption(SortByOption.values()[position - 1]);
                } else if (items == mFilterByItems) {
                    mSearchParams.setFilterByOption(FilterByOption.values()[position - 1]);
                } else if (items == mLimitByItems) {
                    mSearchParams.setLimitByOption(LimitTypeOption.values()[position - 1]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (mSearchParams == null) {
                    return;
                }
                if (items == mResultsMaxCountItems) {
                    mSearchParams.setResultMaxCount(null);
                } else if (items == mSortByItems) {
                    mSearchParams.setSortByOption(null);
                } else if (items == mFilterByItems) {
                    mSearchParams.setFilterByOption(null);
                    mBinding.mainActivityFilterFilterByEdittext.setText(null);
                } else if (items == mLimitByItems) {
                    mSearchParams.setLimitByOption(null);
                    mBinding.mainActivityFilterLimitByEdittext.setText(null);
                }
            }
        });
    }

    boolean populateSearchOptions(boolean showError) {
        if (mSearchParams == null) {
            showInformationalDialog(getString(R.string.error_unexpected_error));
            return false;
        }
        if (mSearchParams.getSearchTypeOption() == SearchTypeOption.SEARCH_BY_NAME) {
            if (isInputValidForNameSearch()) {
                mSearchParams.setSchoolNameQuery(Objects.requireNonNull(mBinding.mainSearchByNameEdittext.getText()).toString());
                return true;
            }
            if (showError) {
                showInformationalDialog(getString(R.string.main_activity_error_missing_name_criteria));
            }
            return false;
        } else {
            if (isInputValidForFilterSearch()) {
                int sortByPosition = mBinding.mainActivityFilterSortByDropdown.getSelectedItemPosition();
                int filterByPosition = mBinding.mainActivityFilterFilterByDropdown.getSelectedItemPosition();
                int limitByPosition = mBinding.mainActivityFilterLimitByDropdown.getSelectedItemPosition();
                int resultCountPosition = mBinding.mainActivityFilterResultCountDropdown.getSelectedItemPosition();

                boolean isDataAvailable = false;
                SortByOption sortByOption = null;
                if (sortByPosition > 0) {
                    sortByOption = SortByOption.values()[sortByPosition - 1];
                    isDataAvailable = true;
                }

                FilterByOption filterByOption = null;
                if (filterByPosition > 0) {
                    filterByOption = FilterByOption.values()[filterByPosition - 1];
                    isDataAvailable = true;
                }

                LimitTypeOption limitByOption = null;
                if (limitByPosition > 0) {
                    limitByOption = LimitTypeOption.values()[limitByPosition - 1];
                    isDataAvailable = true;
                }

                Integer resultCount = null;
                if (resultCountPosition > 0) {
                    resultCount = Integer.parseInt(mResultsMaxCountItems[mBinding.mainActivityFilterResultCountDropdown.getSelectedItemPosition()]);
                    isDataAvailable = true;
                }

                if (!isDataAvailable) {
                    if (showError) {
                        showInformationalDialog(getString(R.string.main_activity_error_missing_filter_criteria));
                    }
                    return false;
                }
;
                mSearchParams.setSortByOption(sortByOption);
                mSearchParams.setFilterByOption(filterByOption);
                mSearchParams.setLimitByOption(limitByOption);
                mSearchParams.setResultMaxCount(resultCount);
                mSearchParams.setFilterByOptionQuery(Objects.requireNonNull(mBinding.mainActivityFilterFilterByEdittext.getText()).toString());
                mSearchParams.setLimitQuery(Objects.requireNonNull(mBinding.mainActivityFilterLimitByEdittext.getText()).toString());
                return true;
            }
        }
        if (showError) {
            showInformationalDialog(getString(R.string.main_activity_error_missing_filter_criteria));
        }
        return false;
    }

    void searchForSchools() {
        if (mSearchParams == null || mSearchParams.getSearchTypeOption() == null) {
            Log.e(TAG, "searchForSchools: SearchParams or Search Options is null", new NullPointerException());
            return;
        }

        // Launch Results Fragment by signaling the Activity
        if (populateSearchOptions(true)) {
            if (getActivity() instanceof BaseActivity) {
                hideKeyboard((BaseActivity) getActivity());
            }
            mListener.onSearch(mSearchParams);
        }
    }

    private boolean isInputValidForNameSearch() {
        return mBinding.mainSearchByNameEdittext.getText() != null && StringUtils.isNotBlank(mBinding.mainSearchByNameEdittext.getText().toString());
    }

    private boolean isInputValidForFilterSearch() {
        return mBinding.mainActivityFilterResultCountDropdown.getSelectedItemPosition() > 0
                || mBinding.mainActivityFilterSortByDropdown.getSelectedItemPosition() > 0
                || (mBinding.mainActivityFilterFilterByDropdown.getSelectedItemPosition() > 0 && StringUtils.isNotBlank(mBinding.mainActivityFilterFilterByEdittext.getText())
                || (mBinding.mainActivityFilterLimitByDropdown.getSelectedItemPosition() > 0 && StringUtils.isNotBlank(mBinding.mainActivityFilterLimitByEdittext.getText())));
    }

    public static SearchOptionsFragment newInstance(ISearchListener searchListener) {
        SearchOptionsFragment fragment = new SearchOptionsFragment();
        fragment.setSearchListener(searchListener);
        return fragment;
    }

    @Override
    public void setSearchListener(ISearchListener searchListener) {
        this.mListener = searchListener;
    }

    @Override
    public String[] getDisplayNamesForSortByOption() {
        String[] array = new String[SortByOption.values().length + 1];
        array[0] = "";
        int index = 0;
        for (SortByOption option : SortByOption.values()) {
            array[index + 1] = getString(option.getStringID());
            index++;
        }

        return array;
    }

    @Override
    public String[] getDisplayNamesForFilterByOption() {
        String[] array = new String[FilterByOption.values().length + 1];
        array[0] = "";
        int index = 0;
        for (FilterByOption option : FilterByOption.values()) {
            array[index + 1] = getString(option.getStringID());
            index++;
        }

        return array;
    }

    @Override
    public String[] getDisplayNamesForLimitTypeOption() {
        String[] array = new String[LimitTypeOption.values().length + 1];
        array[0] = "";
        int index = 0;
        for (LimitTypeOption option : LimitTypeOption.values()) {
            array[index + 1] = getString(option.getStringID());
            index++;
        }

        return array;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentSearchOptionsBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        initValues();
        initViews();
    }
}