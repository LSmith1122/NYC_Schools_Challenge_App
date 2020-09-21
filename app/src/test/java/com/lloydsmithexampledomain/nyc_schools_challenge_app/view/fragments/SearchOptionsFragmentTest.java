package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.models.SearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.BaseTest;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.utils.AppHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(AndroidJUnit4.class)
public class SearchOptionsFragmentTest extends BaseTest {

    @Test
    public void testSearchForSchools_SearchBySchoolNameSearchParamsIsValid_ErrorDialogIsShown() {
        // If
        FragmentScenario<SearchOptionsFragment> scenario = FragmentScenario
                .launchInContainer(SearchOptionsFragment.class)
                .moveToState(Lifecycle.State.CREATED);

        SearchParams searchParams = new SearchParams();
        searchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_NAME);

        FragmentScenario.FragmentAction<SearchOptionsFragment> action = new FragmentScenario.FragmentAction<SearchOptionsFragment>() {
            @Override
            public void perform(@NonNull SearchOptionsFragment fragment) {
                fragment.mSearchParams = searchParams;

                // When
                fragment.searchForSchools();

                // Then
                assertNotNull(AppHelper.getDialog());
                assertTrue(AppHelper.getDialog().isShowing());
            }
        };

        scenario.onFragment(action::perform);
    }

    @Test
    public void testSearchForSchools_SearchBySchoolNameSearchParamsIsNotValid_ErrorDialogIsNotShown() {
        // If
        FragmentScenario<SearchOptionsFragment> scenario = FragmentScenario
                .launchInContainer(SearchOptionsFragment.class)
                .moveToState(Lifecycle.State.CREATED);

        SearchParams searchParams = new SearchParams();
        searchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_NAME);
        ISearchListener emptyListener = mock(ISearchListener.class);
        FragmentScenario.FragmentAction<SearchOptionsFragment> action = new FragmentScenario.FragmentAction<SearchOptionsFragment>() {
            @Override
            public void perform(@NonNull SearchOptionsFragment fragment) {
                fragment.mListener = emptyListener;
                fragment.mSearchParams = searchParams;
                fragment.mBinding.mainSearchByNameEdittext.setText("School Name");

                // When
                fragment.searchForSchools();

                // Then
                assertNull(AppHelper.getDialog());
            }
        };

        scenario.onFragment(action);
    }

    @Test
    public void testSearchForSchools_SearchByFilterGroupParamsIsNotValid_ErrorDialogIsShown() {
        // If
        FragmentScenario<SearchOptionsFragment> scenario = FragmentScenario
                .launchInContainer(SearchOptionsFragment.class)
                .moveToState(Lifecycle.State.CREATED);

        SearchParams searchParams = new SearchParams();
        searchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_FILTER);

        FragmentScenario.FragmentAction<SearchOptionsFragment> action = new FragmentScenario.FragmentAction<SearchOptionsFragment>() {
            @Override
            public void perform(@NonNull SearchOptionsFragment fragment) {
                fragment.mSearchParams = searchParams;

                // When
                fragment.searchForSchools();

                // Then
                assertNotNull(AppHelper.getDialog());
                assertTrue(AppHelper.getDialog().isShowing());
            }
        };

        scenario.onFragment(action::perform);
    }

    @Test
    public void testSearchForSchools_SortBySearchParamsIsValid_ErrorDialogIsNotShown() {
        // If
        FragmentScenario<SearchOptionsFragment> scenario = FragmentScenario
                .launchInContainer(SearchOptionsFragment.class)
                .moveToState(Lifecycle.State.CREATED);

        SearchParams searchParams = new SearchParams();
        searchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_FILTER);
        ISearchListener emptyListener = mock(ISearchListener.class);
        FragmentScenario.FragmentAction<SearchOptionsFragment> action = new FragmentScenario.FragmentAction<SearchOptionsFragment>() {
            @Override
            public void perform(@NonNull SearchOptionsFragment fragment) {
                fragment.mListener = emptyListener;
                fragment.mSearchParams = searchParams;
                fragment.mBinding.mainActivityFilterSortByDropdown.setSelection(1);

                // When
                fragment.searchForSchools();

                // Then
                assertNull(AppHelper.getDialog());
            }
        };

        scenario.onFragment(action);
    }

    @Test
    public void testSearchForSchools_SortBySearchParamsIsPartiallyValid_ErrorDialogIsShown() {
        // If
        FragmentScenario<SearchOptionsFragment> scenario = FragmentScenario
                .launchInContainer(SearchOptionsFragment.class)
                .moveToState(Lifecycle.State.CREATED);

        SearchParams searchParams = new SearchParams();
        searchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_FILTER);
        ISearchListener emptyListener = mock(ISearchListener.class);
        FragmentScenario.FragmentAction<SearchOptionsFragment> action = new FragmentScenario.FragmentAction<SearchOptionsFragment>() {
            @Override
            public void perform(@NonNull SearchOptionsFragment fragment) {
                fragment.mListener = emptyListener;
                fragment.mSearchParams = searchParams;
                fragment.mBinding.mainActivityFilterSortByDropdown.setSelection(0);

                // When
                fragment.searchForSchools();

                // Then
                assertNotNull(AppHelper.getDialog());
                assertTrue(AppHelper.getDialog().isShowing());
            }
        };

        scenario.onFragment(action);
    }

    @Test
    public void testSearchForSchools_LimitBySearchParamsIsPartiallyValid_ErrorDialogIsShown() {
        // If
        FragmentScenario<SearchOptionsFragment> scenario = FragmentScenario
                .launchInContainer(SearchOptionsFragment.class)
                .moveToState(Lifecycle.State.CREATED);

        SearchParams searchParams = new SearchParams();
        searchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_FILTER);
        ISearchListener emptyListener = mock(ISearchListener.class);
        FragmentScenario.FragmentAction<SearchOptionsFragment> action = new FragmentScenario.FragmentAction<SearchOptionsFragment>() {
            @Override
            public void perform(@NonNull SearchOptionsFragment fragment) {
                fragment.mListener = emptyListener;
                fragment.mSearchParams = searchParams;
                fragment.mBinding.mainActivityFilterLimitByDropdown.setSelection(1);
                fragment.mBinding.mainActivityFilterLimitByEdittext.setText(null);

                // When
                fragment.searchForSchools();

                // Then
                assertNotNull(AppHelper.getDialog());
                assertTrue(AppHelper.getDialog().isShowing());
            }
        };

        scenario.onFragment(action);
    }

}
