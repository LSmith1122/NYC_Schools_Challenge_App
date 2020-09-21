package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities;

import androidx.fragment.app.FragmentManager;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.BaseTest;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.DetailsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.ResultsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.SearchOptionsFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest extends BaseTest {

    private ActivityController<MainActivity> mActivityController;

    @Before
    public void setup() {
        mActivityController = Robolectric.buildActivity(MainActivity.class);
    }

    @Test
    public void testMainActivity_OnCreateCalled_SearchPresenterInjected() {
        // If
        // When
        MainActivity activity = mActivityController.create().get();

        // Then
        assertNotNull(activity.mSearchPresenter);
    }

    @Test
    public void testMainActivity_OnCreateCalled_SearchOptionsFragmentCreated() {
        // If
        // When
        MainActivity activity = mActivityController.create().get();

        // Then
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        assertEquals(1, fragmentManager.getBackStackEntryCount());
        assertEquals(SearchOptionsFragment.class.getSimpleName(), fragmentManager.getBackStackEntryAt(0).getName());
    }

    @Test
    public void testMainActivity_OnSearch_ResultsFragmentCreated() {
        // If
        MainActivity activity = mActivityController.create().get();

        // When
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_NAME);
        when(searchParams.getSchoolNameQuery()).thenReturn("Test");
        assertEquals(SearchTypeOption.SEARCH_BY_NAME, searchParams.getSearchTypeOption());
        assertEquals("Test", searchParams.getSchoolNameQuery());

        activity.onSearch(searchParams);

        // Then
        assertEquals(2, activity.getSupportFragmentManager().getBackStackEntryCount());
        assertEquals(ResultsFragment.class.getSimpleName(), activity.getSupportFragmentManager().getBackStackEntryAt(1).getName());
    }

    @Test
    public void testMainActivity_OnCompleteDetailsRetrieved_DetailsFragmentCreated() {
        // If
        MainActivity activity = mActivityController.create().get();
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_NAME);
        when(searchParams.getSchoolNameQuery()).thenReturn("Test");
        assertEquals(SearchTypeOption.SEARCH_BY_NAME, searchParams.getSearchTypeOption());
        assertEquals("Test", searchParams.getSchoolNameQuery());

        activity.showOrUpdateResultsFragment(searchParams);

        assertEquals(2, activity.getSupportFragmentManager().getBackStackEntryCount());
        assertEquals(ResultsFragment.class.getSimpleName(), activity.getSupportFragmentManager().getBackStackEntryAt(1).getName());

        ISchoolData schoolData = mock(ISchoolData.class);
        when(schoolData.getSchoolName()).thenReturn("School Name");
        when(schoolData.getPrimaryAddressLine()).thenReturn("123 Elmo Street");
        when(schoolData.getSchoolEmail()).thenReturn("abc@email.com");
        when(schoolData.getOverviewParagraph()).thenReturn("Something something darkside...");
        when(schoolData.getSATForMath()).thenReturn(250);
        when(schoolData.getSATForReading()).thenReturn(250);
        when(schoolData.getSATForWriting()).thenReturn(250);

        // When
        activity.onCompleteDetailsRetrieved(schoolData);

        // Then
        assertEquals(3, activity.getSupportFragmentManager().getBackStackEntryCount());
        assertEquals(DetailsFragment.class.getSimpleName(), activity.getSupportFragmentManager().getBackStackEntryAt(2).getName());
    }

    @Test
    public void testSearchOptionsFragmentCreated_MainActivityOnBackPressed_ExitDialogShown() {
        // If
        MainActivity activity = mActivityController.create().get();
        assertEquals(1, activity.getSupportFragmentManager().getBackStackEntryCount());
        assertEquals(SearchOptionsFragment.class.getSimpleName(), activity.getSupportFragmentManager().getBackStackEntryAt(0).getName());
        assertNull(activity.mDialog);

        // When
        activity.onBackPressed();

        // Then
        assertEquals(1, activity.getSupportFragmentManager().getBackStackEntryCount());
        assertTrue(activity.mDialog.isShowing());
    }

    @Test
    public void testResultsFragmentCreated_MainActivityOnBackPressed_BackStackPopped() {
        // If
        MainActivity activity = mActivityController.create().get();
        assertEquals(1, activity.getSupportFragmentManager().getBackStackEntryCount());

        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_NAME);
        when(searchParams.getSchoolNameQuery()).thenReturn("Test");
        assertEquals(SearchTypeOption.SEARCH_BY_NAME, searchParams.getSearchTypeOption());
        assertEquals("Test", searchParams.getSchoolNameQuery());

        activity.showOrUpdateResultsFragment(searchParams);

        assertEquals(2, activity.getSupportFragmentManager().getBackStackEntryCount());
        assertEquals(ResultsFragment.class.getSimpleName(), activity.getSupportFragmentManager().getBackStackEntryAt(1).getName());

        // When
        activity.onBackPressed();

        // Then
        assertEquals(1, activity.getSupportFragmentManager().getBackStackEntryCount());
        assertNotEquals(ResultsFragment.class.getSimpleName(), activity.getSupportFragmentManager().getBackStackEntryAt(0).getName());
        assertEquals(SearchOptionsFragment.class.getSimpleName(), activity.getSupportFragmentManager().getBackStackEntryAt(0).getName());
        assertNull(activity.mDialog);
    }

}
