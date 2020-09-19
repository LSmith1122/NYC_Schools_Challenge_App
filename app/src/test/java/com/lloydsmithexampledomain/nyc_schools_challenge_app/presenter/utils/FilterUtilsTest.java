package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.LimitTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SortByOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.BaseTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class FilterUtilsTest extends BaseTest {

    @Test
    public void testFilterUtils_SortSchoolData_SuccessfullySortsByNameAZ() {
        // If
        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("School Name2");

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("School Name3");

        List<ISchoolData> expected = new ArrayList<>();
        expected.add(schoolData1);
        expected.add(schoolData2);
        expected.add(schoolData3);

        List<ISchoolData> actual = new ArrayList<>();
        actual.add(schoolData3);
        actual.add(schoolData1);
        actual.add(schoolData2);

        // When
        boolean finishedFiltering = FilterUtils.sortSchoolData(SearchTypeOption.SEARCH_BY_NAME, actual, SortByOption.ALPHA_SCHOOL_NAME_AZ);

        // Then
        assertTrue(finishedFiltering);
        assertEquals(expected.get(0).getDbn(), actual.get(0).getDbn());
        assertEquals(expected.get(1).getDbn(), actual.get(1).getDbn());
        assertEquals(expected.get(2).getDbn(), actual.get(2).getDbn());
        assertEquals(expected.get(0).getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(expected.get(1).getSchoolName(), actual.get(1).getSchoolName());
        assertEquals(expected.get(2).getSchoolName(), actual.get(2).getSchoolName());
    }

    @Test
    public void testFilterUtils_SortSchoolData_SuccessfullySortsByNameZA() {
        // If
        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("School Name2");

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("School Name3");

        List<ISchoolData> expected = new ArrayList<>();
        expected.add(schoolData3);
        expected.add(schoolData2);
        expected.add(schoolData1);

        List<ISchoolData> actual = new ArrayList<>();
        actual.add(schoolData3);
        actual.add(schoolData1);
        actual.add(schoolData2);

        // When
        boolean finishedFiltering = FilterUtils.sortSchoolData(SearchTypeOption.SEARCH_BY_NAME, actual, SortByOption.ALPHA_SCHOOL_NAME_ZA);

        // Then
        assertTrue(finishedFiltering);
        assertEquals(expected.get(0).getDbn(), actual.get(0).getDbn());
        assertEquals(expected.get(1).getDbn(), actual.get(1).getDbn());
        assertEquals(expected.get(2).getDbn(), actual.get(2).getDbn());
        assertEquals(expected.get(0).getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(expected.get(1).getSchoolName(), actual.get(1).getSchoolName());
        assertEquals(expected.get(2).getSchoolName(), actual.get(2).getSchoolName());
    }

    @Test
    public void testFilterUtils_SortSchoolData_SuccessfullySortsByCityAZ() {
        // If
        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");
        when(schoolData1.getCity()).thenReturn("City Name1");

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("School Name2");
        when(schoolData2.getCity()).thenReturn("City Name2");

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("School Name3");
        when(schoolData3.getCity()).thenReturn("City Name3");

        List<ISchoolData> expected = new ArrayList<>();
        expected.add(schoolData1);
        expected.add(schoolData2);
        expected.add(schoolData3);

        List<ISchoolData> actual = new ArrayList<>();
        actual.add(schoolData3);
        actual.add(schoolData1);
        actual.add(schoolData2);

        // When
        boolean finishedFiltering = FilterUtils.sortSchoolData(SearchTypeOption.SEARCH_BY_NAME, actual, SortByOption.ALPHA_CITY_AZ);

        // Then
        assertTrue(finishedFiltering);
        assertEquals(expected.get(0).getDbn(), actual.get(0).getDbn());
        assertEquals(expected.get(1).getDbn(), actual.get(1).getDbn());
        assertEquals(expected.get(2).getDbn(), actual.get(2).getDbn());
        assertEquals(expected.get(0).getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(expected.get(1).getSchoolName(), actual.get(1).getSchoolName());
        assertEquals(expected.get(2).getSchoolName(), actual.get(2).getSchoolName());
        assertEquals(expected.get(0).getCity(), actual.get(0).getCity());
        assertEquals(expected.get(1).getCity(), actual.get(1).getCity());
        assertEquals(expected.get(2).getCity(), actual.get(2).getCity());
    }

    @Test
    public void testFilterUtils_SortSchoolData_SuccessfullySortsByCityZA() {
        // If
        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");
        when(schoolData1.getCity()).thenReturn("City Name1");

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("School Name2");
        when(schoolData2.getCity()).thenReturn("City Name2");

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("School Name3");
        when(schoolData3.getCity()).thenReturn("City Name3");

        List<ISchoolData> expected = new ArrayList<>();
        expected.add(schoolData3);
        expected.add(schoolData2);
        expected.add(schoolData1);

        List<ISchoolData> actual = new ArrayList<>();
        actual.add(schoolData3);
        actual.add(schoolData1);
        actual.add(schoolData2);

        // When
        boolean finishedFiltering = FilterUtils.sortSchoolData(SearchTypeOption.SEARCH_BY_NAME, actual, SortByOption.ALPHA_CITY_ZA);

        // Then
        assertTrue(finishedFiltering);
        assertEquals(expected.get(0).getDbn(), actual.get(0).getDbn());
        assertEquals(expected.get(1).getDbn(), actual.get(1).getDbn());
        assertEquals(expected.get(2).getDbn(), actual.get(2).getDbn());
        assertEquals(expected.get(0).getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(expected.get(1).getSchoolName(), actual.get(1).getSchoolName());
        assertEquals(expected.get(2).getSchoolName(), actual.get(2).getSchoolName());
        assertEquals(expected.get(0).getCity(), actual.get(0).getCity());
        assertEquals(expected.get(1).getCity(), actual.get(1).getCity());
        assertEquals(expected.get(2).getCity(), actual.get(2).getCity());
    }

    @Test
    public void testFilterUtils_SortSchoolData_SuccessfullySortsByGraduationRateDescend() {
        // If
        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");
        when(schoolData1.getGraduationRatePercentage()).thenReturn(0.80);

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("School Name2");
        when(schoolData2.getGraduationRatePercentage()).thenReturn(0.82);

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("School Name3");
        when(schoolData3.getGraduationRatePercentage()).thenReturn(0.84);

        List<ISchoolData> expected = new ArrayList<>();
        expected.add(schoolData3);
        expected.add(schoolData2);
        expected.add(schoolData1);

        List<ISchoolData> actual = new ArrayList<>();
        actual.add(schoolData3);
        actual.add(schoolData1);
        actual.add(schoolData2);

        // When
        boolean finishedFiltering = FilterUtils.sortSchoolData(SearchTypeOption.SEARCH_BY_NAME, actual, SortByOption.GRADUATION_RATE_DESC);

        // Then
        assertTrue(finishedFiltering);
        assertEquals(expected.get(0).getDbn(), actual.get(0).getDbn());
        assertEquals(expected.get(1).getDbn(), actual.get(1).getDbn());
        assertEquals(expected.get(2).getDbn(), actual.get(2).getDbn());
        assertEquals(expected.get(0).getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(expected.get(1).getSchoolName(), actual.get(1).getSchoolName());
        assertEquals(expected.get(2).getSchoolName(), actual.get(2).getSchoolName());
        assertEquals(expected.get(0).getGraduationRatePercentage(), actual.get(0).getGraduationRatePercentage());
        assertEquals(expected.get(1).getGraduationRatePercentage(), actual.get(1).getGraduationRatePercentage());
        assertEquals(expected.get(2).getGraduationRatePercentage(), actual.get(2).getGraduationRatePercentage());
    }

    @Test
    public void testFilterUtils_SortSchoolData_SuccessfullySortsByGraduationRateAscend() {
        // If
        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");
        when(schoolData1.getGraduationRatePercentage()).thenReturn(0.80);

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("School Name2");
        when(schoolData2.getGraduationRatePercentage()).thenReturn(0.82);

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("School Name3");
        when(schoolData3.getGraduationRatePercentage()).thenReturn(0.84);

        List<ISchoolData> expected = new ArrayList<>();
        expected.add(schoolData1);
        expected.add(schoolData2);
        expected.add(schoolData3);

        List<ISchoolData> actual = new ArrayList<>();
        actual.add(schoolData3);
        actual.add(schoolData1);
        actual.add(schoolData2);

        // When
        boolean finishedFiltering = FilterUtils.sortSchoolData(SearchTypeOption.SEARCH_BY_NAME, actual, SortByOption.GRADUATION_RATE_ASC);

        // Then
        assertTrue(finishedFiltering);
        assertEquals(expected.get(0).getDbn(), actual.get(0).getDbn());
        assertEquals(expected.get(1).getDbn(), actual.get(1).getDbn());
        assertEquals(expected.get(2).getDbn(), actual.get(2).getDbn());
        assertEquals(expected.get(0).getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(expected.get(1).getSchoolName(), actual.get(1).getSchoolName());
        assertEquals(expected.get(2).getSchoolName(), actual.get(2).getSchoolName());
        assertEquals(expected.get(0).getGraduationRatePercentage(), actual.get(0).getGraduationRatePercentage());
        assertEquals(expected.get(1).getGraduationRatePercentage(), actual.get(1).getGraduationRatePercentage());
        assertEquals(expected.get(2).getGraduationRatePercentage(), actual.get(2).getGraduationRatePercentage());
    }

    @Test
    public void testFilterUtils_FilterBySchoolName_SuccessfullyFiltersByName() {
        // If
        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("Expected School Name2");

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("SchoolExpected Name3");

        List<ISchoolData> input = new ArrayList<>();
        input.add(schoolData1);
        input.add(schoolData2);
        input.add(schoolData3);

        // When
        List<ISchoolData> actual = FilterUtils.filterBySchoolName(input, "Expected");

        // Then
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        assertNotEquals(schoolData1.getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(schoolData2.getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(schoolData3.getSchoolName(), actual.get(1).getSchoolName());
    }

    @Test
    public void testFilterUtils_LimitSchoolData_SuccessfullyLimitByGraduationRateMin() {
        // If
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_FILTER);
        when(searchParams.getLimitByOption()).thenReturn(LimitTypeOption.GRADUATION_RATE_MIN);
        when(searchParams.getLimitByOptionQuery()).thenReturn(String.valueOf(81));
        when(searchParams.getResultMaxCount()).thenReturn(null);

        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");
        when(schoolData1.getGraduationRatePercentage()).thenReturn(0.80);

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("Expected School Name2");
        when(schoolData2.getGraduationRatePercentage()).thenReturn(0.82);

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("SchoolExpected Name3");
        when(schoolData3.getGraduationRatePercentage()).thenReturn(0.84);

        List<ISchoolData> input = new ArrayList<>();
        input.add(schoolData1);
        input.add(schoolData2);
        input.add(schoolData3);

        // When
        List<ISchoolData> actual = FilterUtils.filterSchoolData(searchParams, input);

        // Then
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        assertNotEquals(schoolData1.getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(schoolData2.getSchoolName(), actual.get(0).getSchoolName());
        assertEquals(schoolData3.getSchoolName(), actual.get(1).getSchoolName());
    }

    @Test
    public void testFilterUtils_LimitSchoolData_SuccessfullyLimitByGraduationRateMax() {
        // If
        ISearchParams searchParams = mock(ISearchParams.class);
        when(searchParams.getSearchTypeOption()).thenReturn(SearchTypeOption.SEARCH_BY_FILTER);
        when(searchParams.getLimitByOption()).thenReturn(LimitTypeOption.GRADUATION_RATE_MAX);
        when(searchParams.getLimitByOptionQuery()).thenReturn(String.valueOf(81));
        when(searchParams.getResultMaxCount()).thenReturn(null);

        ISchoolData schoolData1 = mock(ISchoolData.class);
        when(schoolData1.getDbn()).thenReturn("123");
        when(schoolData1.getSchoolName()).thenReturn("School Name1");
        when(schoolData1.getGraduationRatePercentage()).thenReturn(0.80);

        ISchoolData schoolData2 = mock(ISchoolData.class);
        when(schoolData2.getDbn()).thenReturn("456");
        when(schoolData2.getSchoolName()).thenReturn("Expected School Name2");
        when(schoolData2.getGraduationRatePercentage()).thenReturn(0.82);

        ISchoolData schoolData3 = mock(ISchoolData.class);
        when(schoolData3.getDbn()).thenReturn("789");
        when(schoolData3.getSchoolName()).thenReturn("SchoolExpected Name3");
        when(schoolData3.getGraduationRatePercentage()).thenReturn(0.84);

        List<ISchoolData> input = new ArrayList<>();
        input.add(schoolData1);
        input.add(schoolData2);
        input.add(schoolData3);

        // When
        List<ISchoolData> actual = FilterUtils.filterSchoolData(searchParams, input);

        // Then
        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(1, actual.size());
        assertEquals(schoolData1.getSchoolName(), actual.get(0).getSchoolName());
    }

}
