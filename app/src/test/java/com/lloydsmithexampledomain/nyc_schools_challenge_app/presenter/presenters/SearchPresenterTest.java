package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.presenters;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.services.SchoolDataService;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.BaseTest;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.IResultsFragmentView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class SearchPresenterTest extends BaseTest {

    private SearchPresenter mSearchPresenter;

    @Before
    public void setup() {
        IResultsFragmentView mFragmentView = mock(IResultsFragmentView.class);
        mSearchPresenter = new SearchPresenter();
        mSearchPresenter.mResultsFragmentView = mFragmentView;
        mSearchPresenter.mSchoolService = mock(SchoolDataService.class);
    }

    @After
    public void tearDown() {
        if (mSearchPresenter.mResultsFragmentView != null) {
            reset(mSearchPresenter.mResultsFragmentView);
        }
        if (mSearchPresenter.mSchoolService != null) {
            reset(mSearchPresenter.mSchoolService);
        }
        mSearchPresenter = null;
    }

    /**
     * For some reason, this test passes individually, but fails when tested with others
     */
    @Test
    public void testSchoolDataService_SearchForSchools_GetAllSchoolsCalled() {
        // If
        assertNotNull(mSearchPresenter.mSchoolService);
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_NAME);
        when(searchParams.getSchoolNameQuery()).thenReturn("School Name");

        // When
        mSearchPresenter.searchForSchools(searchParams);

        // Then
        verify(mSearchPresenter.mSchoolService, times(1)).getAllSchools(eq(mSearchPresenter.getAllSchoolsCallback));
    }

    @Test
    public void testSchoolDataService_SearchForSchoolsAndViewIsNull_GetAllSchoolsNotCalled() {
        // If
        assertNotNull(mSearchPresenter.mSchoolService);
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_NAME);
        when(searchParams.getSchoolNameQuery()).thenReturn("School Name");
        mSearchPresenter.mResultsFragmentView = null;

        // When
        mSearchPresenter.searchForSchools(searchParams);

        // Then
        verify(mSearchPresenter.mSchoolService, times(0)).getAllSchools(eq(mSearchPresenter.getAllSchoolsCallback));
    }

    @Test
    public void testFragmentView_SearchForSchoolsAndDataIsCached_OnSchoolSearchCompleteCalled() {
        // If
        assertNotNull(mSearchPresenter.mSchoolService);
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_NAME);
        when(searchParams.getSchoolNameQuery()).thenReturn("School Name");

        ISchoolData schoolData = mock(ISchoolData.class);
        when(schoolData.getDbn()).thenReturn("123");
        when(schoolData.getSchoolName()).thenReturn("School Name");

        List<ISchoolData> mockedList = new ArrayList<>();
        mockedList.add(schoolData);
        mockedList.add(schoolData);
        mockedList.add(schoolData);
        mSearchPresenter.mCachedSchoolData = (List<ISchoolData>) mockedList;

        // When
        mSearchPresenter.searchForSchools(searchParams);

        // Then
        verify(mSearchPresenter.mResultsFragmentView, times(1)).onSchoolSearchComplete(mockedList);
    }

    @Test
    public void testFragmentView_SearchForSchoolsAndDataIsNotCached_OnSchoolSearchCompleteCalled() {
        // If
        assertNotNull(mSearchPresenter.mSchoolService);
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_NAME);
        when(searchParams.getSchoolNameQuery()).thenReturn("School Name");

        List<ISchoolData> emptyList = new ArrayList<>();
        mSearchPresenter.mCachedSchoolData = (List<ISchoolData>) emptyList;

        ISchoolData schoolData = mock(ISchoolData.class);
        when(schoolData.getDbn()).thenReturn("123");
        when(schoolData.getSchoolName()).thenReturn("School Name");

        List<ISchoolData> expectedList = new ArrayList<>();
        expectedList.add(schoolData);
        expectedList.add(schoolData);
        expectedList.add(schoolData);

        doAnswer(invocation -> {
            mSearchPresenter.getAllSchoolsCallback.onSuccess(expectedList, 200);
            return null;
        }).when(mSearchPresenter.mSchoolService).getAllSchools(eq(mSearchPresenter.getAllSchoolsCallback));

        // When
        mSearchPresenter.searchForSchools(searchParams);

        // Then
        verify(mSearchPresenter.mResultsFragmentView, times(1)).onSchoolSearchComplete(expectedList);
    }

}
