package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.AppFragmentFactory;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.BaseTest;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.models.SearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.utils.AppHelper;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(AndroidJUnit4.class)
public class ResultsFragmentTest extends BaseTest {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void testResultsFragment_OnCreateCalled_SearchPresenterIsCreated() {
        // If
        ISearchListener listener = mock(ISearchListener.class);
        doNothing().when(listener).onSearch(any());
        doNothing().when(listener).onCompleteDetailsRetrieved(any());

        ISearchPresenter searchPresenter = mock(ISearchPresenter.class);
        doNothing().when(searchPresenter).searchForSchools(any());

        // When
        AppFragmentFactory<ResultsFragment> factory = new AppFragmentFactory<>(null, listener, null);
        FragmentScenario<ResultsFragment> scenario = FragmentScenario
                .launchInContainer(ResultsFragment.class, null, factory)
                .moveToState(Lifecycle.State.CREATED);

        FragmentScenario.FragmentAction<ResultsFragment> action = new FragmentScenario.FragmentAction<ResultsFragment>() {
            @Override
            public void perform(@NonNull ResultsFragment fragment) {
                // Then
                assertNotNull(fragment.mSearchPresenter);
            }
        };

        scenario.onFragment(action::perform);
    }

    @Test
    public void onResultsFragment_UpdateResultsAndSearchParamsNull_ErrorDialogIsShown() {
        // If
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        ResultsFragment fragment = mock(ResultsFragment.class);
        when(fragment.getContext()).thenReturn(context);
        doCallRealMethod().when(fragment).updateResults(any());
        doCallRealMethod().when(fragment).onSchoolSearchError(anyString(), anyInt());
        doCallRealMethod().when(fragment).showErrorDialog(anyString());
        doCallRealMethod().when(fragment).showInformationalDialog(anyString(), anyBoolean());

        // When
        fragment.updateResults(null);

        // Then
        verify(fragment, times(1)).onSchoolSearchError(eq(null), eq(500));
        assertNotNull(AppHelper.getDialog());
        assertTrue(AppHelper.getDialog().isShowing());
    }

    @Test
    public void onResultsFragment_UpdateResultsAndSearchParamsNull_ErrorDialogIsNotShown() {
        // If
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        SearchParams searchParams = new SearchParams();
        searchParams.setSearchTypeOption(SearchTypeOption.SEARCH_BY_FILTER);

        ISearchListener listener = mock(ISearchListener.class);
        doNothing().when(listener).onSearch(any());
        doNothing().when(listener).onCompleteDetailsRetrieved(any());

        ISearchPresenter searchPresenter = mock(ISearchPresenter.class);
        doNothing().when(searchPresenter).searchForSchools(any());

        ResultsFragment fragment = mock(ResultsFragment.class);
        fragment.mSearchParams = searchParams;
        fragment.mSearchPresenter = searchPresenter;

        when(fragment.getContext()).thenReturn(context);
        doCallRealMethod().when(fragment).updateResults(any());
        doCallRealMethod().when(fragment).onSchoolSearchError(anyString(), anyInt());
        doCallRealMethod().when(fragment).showErrorDialog(anyString());
        doCallRealMethod().when(fragment).showInformationalDialog(anyString(), anyBoolean());

        // When
        fragment.updateResults(searchParams);

        // Then
        verify(fragment, times(0)).onSchoolSearchError(anyString(), anyInt());
        assertNull(AppHelper.getDialog());
        verify(searchPresenter, times(1)).searchForSchools(eq(searchParams));
    }

    @Test
    public void testResultsFragment_SearchForSchoolsSuccessful_OnSchoolSearchCompleteWithValidData() {
        // If
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        ISearchListener listener = mock(ISearchListener.class);
        doNothing().when(listener).onSearch(any());
        doNothing().when(listener).onCompleteDetailsRetrieved(any());

        ResultsFragment fragment = mock(ResultsFragment.class);
        when(fragment.getContext()).thenReturn(context);
        doCallRealMethod().when(fragment).onSchoolSearchComplete(any());
        doCallRealMethod().when(fragment).onSchoolSearchError(anyString(), anyInt());
        doCallRealMethod().when(fragment).showErrorDialog(anyString());
        doCallRealMethod().when(fragment).showInformationalDialog(anyString(), anyBoolean());

        AppFragmentFactory<ResultsFragment> factory = new AppFragmentFactory<>(null, listener, null);
        FragmentScenario<ResultsFragment> scenario = FragmentScenario
                .launchInContainer(ResultsFragment.class, null, factory)
                .moveToState(Lifecycle.State.CREATED);

        FragmentScenario.FragmentAction<ResultsFragment> action = new FragmentScenario.FragmentAction<ResultsFragment>() {
            @Override
            public void perform(@NonNull ResultsFragment fragment) {
                RecyclerView recyclerView = mock(RecyclerView.class);
                doCallRealMethod().when(recyclerView).setLayoutManager(any());
                doCallRealMethod().when(recyclerView).setAdapter(any());

                List<ISchoolData> list = new ArrayList<>();
                ISchoolData schoolData = mock(ISchoolData.class);
                when(schoolData.getSchoolName()).thenReturn("School Name");
                when(schoolData.getGraduationRatePercentage()).thenReturn(0.9);
                when(schoolData.getStudentSafetyPercentage()).thenReturn(1.0);
                when(schoolData.getCity()).thenReturn("Dumbo");
                when(schoolData.getStateCode()).thenReturn("NY");
                list.add(schoolData);

                // Intentionally clearing this until a solution is reached to better control
                // the dependency injected Presenter/Service objects and prevent service calls from
                // making made...
                AppHelper.hideDialog();

                // When
                fragment.onSchoolSearchComplete(list);

                // Then
                assertNotNull(fragment);
                assertNotNull(fragment.mSearchPresenter);
                assertNotNull(fragment.mBinding);
                assertNotNull(fragment.mBinding.resultsRecyclerview);
                assertNotNull(fragment.mBinding.resultsRecyclerview.getAdapter());
                assertEquals(1, fragment.mBinding.resultsRecyclerview.getAdapter().getItemCount());
                assertNull(AppHelper.getDialog());
            }
        };

        scenario.onFragment(action::perform);
    }

    @Test
    public void testResultsFragment_SearchForSchoolsUnsuccessful_OnSchoolSearchCompleteWithInvalidData() {
        // If
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        ISearchListener listener = mock(ISearchListener.class);
        doNothing().when(listener).onSearch(any());
        doNothing().when(listener).onCompleteDetailsRetrieved(any());

        ResultsFragment fragment = mock(ResultsFragment.class);
        when(fragment.getContext()).thenReturn(context);
        doCallRealMethod().when(fragment).onSchoolSearchComplete(any());
        doCallRealMethod().when(fragment).onSchoolSearchError(anyString(), anyInt());
        doCallRealMethod().when(fragment).showErrorDialog(anyString());
        doCallRealMethod().when(fragment).showInformationalDialog(anyString(), anyBoolean());

        AppFragmentFactory<ResultsFragment> factory = new AppFragmentFactory<>(null, listener, null);
        FragmentScenario<ResultsFragment> scenario = FragmentScenario
                .launchInContainer(ResultsFragment.class, null, factory)
                .moveToState(Lifecycle.State.CREATED);

        FragmentScenario.FragmentAction<ResultsFragment> action = new FragmentScenario.FragmentAction<ResultsFragment>() {
            @Override
            public void perform(@NonNull ResultsFragment fragment) {
                RecyclerView recyclerView = mock(RecyclerView.class);
                doCallRealMethod().when(recyclerView).setLayoutManager(any());
                doCallRealMethod().when(recyclerView).setAdapter(any());

                List<ISchoolData> emptyList = new ArrayList<>();
                AppHelper.hideDialog();

                // When
                fragment.onSchoolSearchComplete(emptyList);

                // Then
                assertNotNull(fragment);
                assertNotNull(fragment.mSearchPresenter);
                assertNotNull(fragment.mBinding);
                assertNotNull(fragment.mBinding.resultsRecyclerview);
                assertNull(fragment.mBinding.resultsRecyclerview.getAdapter());
                assertNotNull(AppHelper.getDialog());
                assertTrue(AppHelper.getDialog().isShowing());
            }
        };

        scenario.onFragment(action::perform);
    }

    @Ignore
    @Test
    public void onSATDetailsSearchComplete() {
        // If


        // When


        // Then

    }

    @Ignore
    @Test
    public void onNoSATDetailsFound() {
        // If


        // When


        // Then

    }

    @Ignore
    @Test
    public void onSearchError() {
        // If


        // When


        // Then

    }

    @Ignore
    @Test
    public void setSearchListener() {
        // If


        // When


        // Then

    }
}