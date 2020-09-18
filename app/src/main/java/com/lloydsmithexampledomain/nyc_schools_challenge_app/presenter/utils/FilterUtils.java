package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils;

import android.util.Log;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SortByOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FilterUtils {

    private static final String TAG = "FilterUtils";

    public FilterUtils() {}

    public static List<ISchoolData> filterBySchoolName(List<ISchoolData> schoolDataList, String schoolName) {
        List<ISchoolData> list = new ArrayList<>();
        for (ISchoolData school : schoolDataList) {
            if (school.getSchoolName().contains(schoolName)) {
                list.add(school);
            }
        }
        if (list.isEmpty()) {
            return null;
        }

        sortBySchoolNameAlphabetically(list, true);

        return list;
    }

    public static List<ISchoolData> filterSchoolData(ISearchParams searchParams, List<ISchoolData> schoolDataList) {
        final List<ISchoolData> list = new ArrayList<>();
        if (isDataForFilterInvalid(
                searchParams.getSearchTypeOption(),
                schoolDataList,
                searchParams.getSortByOption(),
                searchParams.getFilterByOption(),
                searchParams.getLimitByOption())) {
            return list;
        }

        for (ISchoolData schoolData : schoolDataList) {
            boolean hasFilters = false;
            if (searchParams.getResultMaxCount() != null && searchParams.getResultMaxCount() >= list.size()) {
                break;
            }
            if (searchParams.getLimitByOption() != null) {
                hasFilters = true;
                limitSchoolData(searchParams, list, schoolData);
            }
            if (searchParams.getFilterByOption() != null) {
                hasFilters = true;
                filterSchoolData(searchParams, list, schoolData);
            }

            if (!hasFilters) {
                break;
            }
        }

        if (list.isEmpty()) {
            list.addAll(schoolDataList);
        }
        if (!list.isEmpty()) {
            sortSchoolData(searchParams.getSearchTypeOption(), list, searchParams.getSortByOption());
        }

        return list;
    }

    private static void limitSchoolData(ISearchParams searchParams, List<ISchoolData> list, ISchoolData schoolData) {
        switch (searchParams.getLimitByOption()) {
            case GRADUATION_RATE_MIN:
                int queryAmountMin = Integer.parseInt(searchParams.getLimitByOptionQuery());
                double dataMin = Math.floor(schoolData.getGraduationRatePercentage() * 100);
                limitSchoolDataByAmount(list, schoolData, dataMin, queryAmountMin, true);
                break;
            case GRADUATION_RATE_MAX:
                int queryAmountMax = Integer.parseInt(searchParams.getLimitByOptionQuery());
                double dataMax = Math.floor(schoolData.getGraduationRatePercentage() * 100);
                limitSchoolDataByAmount(list, schoolData, dataMax, queryAmountMax, false);
                break;
            case TOTAL_STUDENTS_MIN:
                int totalStudentsQueryAmountMin = Integer.parseInt(searchParams.getLimitByOptionQuery());
                limitSchoolDataByAmount(list, schoolData, schoolData.getTotalStudents(), totalStudentsQueryAmountMin, true);
                break;
            case TOTAL_STUDENTS_MAX:
                int totalStudentsQueryAmountMax = Integer.parseInt(searchParams.getLimitByOptionQuery());
                limitSchoolDataByAmount(list, schoolData, schoolData.getTotalStudents(), totalStudentsQueryAmountMax, false);
                break;
        }
    }

    private static void limitSchoolDataByAmount(List<ISchoolData> list, ISchoolData schoolData, double data, int queryAmount, boolean isMin) {
        if (isMin) {
            if (data >= queryAmount) {
                list.add(schoolData);
            }
        } else {
            if (data < queryAmount) {
                list.add(schoolData);
            }
        }
    }

    private static void filterSchoolData(ISearchParams searchParams, List<ISchoolData> list, ISchoolData schoolData) {
        switch (searchParams.getFilterByOption()) {
            case CITY:
                filterSchoolDataByCity(searchParams, schoolData, list);
                break;
            case AVAILABLE_ACADEMICS:
                filterSchoolDataByAcademics(searchParams, schoolData, list);
                break;
            case AVAILABLE_SPORTS:
                filterSchoolDataBySports(searchParams, schoolData, list);
                break;
        }
    }

    public static boolean sortSchoolData(SearchTypeOption searchTypeOption, List<ISchoolData> schoolDataList, SortByOption sortByOption) {
        if (isDataForFilterInvalid(searchTypeOption, schoolDataList, sortByOption)) {
            return false;
        }

        switch (sortByOption) {
            case ALPHA_SCHOOL_NAME_AZ:
                return sortBySchoolNameAlphabetically(schoolDataList, true);
            case ALPHA_SCHOOL_NAME_ZA:
                return sortBySchoolNameAlphabetically(schoolDataList, false);
            case ALPHA_CITY_AZ:
                return sortBySchoolCityAlphabetically(schoolDataList, true);
            case ALPHA_CITY_ZA:
                return sortBySchoolCityAlphabetically(schoolDataList, false);
            case GRADUATION_RATE_DESC:
                return sortBySchoolGraduationRateAlphabetically(schoolDataList, true);
            case GRADUATION_RATE_ASC:
                return sortBySchoolGraduationRateAlphabetically(schoolDataList, false);
        }
        return false;
    }

    private static boolean sortBySchoolNameAlphabetically(List<ISchoolData> schoolDataList, boolean shouldDescend) {
        if (schoolDataList == null || schoolDataList.isEmpty()) {
            return false;
        }

        Collections.sort(schoolDataList, (school1, school2) -> {
            if (shouldDescend) {
                return school2.getSchoolName().compareTo(school1.getSchoolName());
            } else {
                return school1.getSchoolName().compareTo(school2.getSchoolName());
            }
        });
        return true;
    }

    private static boolean sortBySchoolCityAlphabetically(List<ISchoolData> schoolDataList, boolean shouldDescend) {
        if (schoolDataList == null || schoolDataList.isEmpty()) {
            return false;
        }

        Collections.sort(schoolDataList, (school1, school2) -> {
            if (shouldDescend) {
                return school2.getCity().compareTo(school1.getCity());
            } else {
                return school1.getCity().compareTo(school2.getCity());
            }
        });
        return true;
    }

    private static boolean sortBySchoolGraduationRateAlphabetically(List<ISchoolData> schoolDataList, boolean shouldDescend) {
        if (schoolDataList == null || schoolDataList.isEmpty()) {
            return false;
        }

        Collections.sort(schoolDataList, (school1, school2) -> {
            if (shouldDescend) {
                return school2.getGraduationRatePercentage().compareTo(school1.getGraduationRatePercentage());
            } else {
                return school1.getGraduationRatePercentage().compareTo(school2.getGraduationRatePercentage());
            }
        });
        return true;
    }

    private static void filterSchoolDataByCity(ISearchParams searchParams, ISchoolData schoolData, List<ISchoolData> list) {
        try {
            if (schoolData.getCity().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "filterSchoolData: CITY", e);
        }
    }

    private static void filterSchoolDataByAcademics(ISearchParams searchParams, ISchoolData schoolData, List<ISchoolData> list) {
        try {
            if (schoolData.getAcademicOpportunities1().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            } else if (schoolData.getAcademicOpportunities2().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            } else if (schoolData.getAcademicOpportunities3().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            } else if (schoolData.getAcademicOpportunities4().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            } else if (schoolData.getAcademicOpportunities5().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "filterSchoolData: AVAILABLE_ACADEMICS", e);
        }
    }

    private static void filterSchoolDataBySports(ISearchParams searchParams,ISchoolData schoolData, List<ISchoolData> list) {
        try {
            if (schoolData.getSchoolSports().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            } else if (schoolData.getSportsBoys().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            } else if (schoolData.getSportsGirls().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            } else if (schoolData.getSportsCoed().contains(searchParams.getFilterByOptionQuery())) {
                list.add(schoolData);
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "filterSchoolData: AVAILABLE_SPORTS", e);
        }
    }

    static boolean isDataForFilterInvalid(SearchTypeOption searchTypeOption, List<ISchoolData> schoolDataList, Enum<?>... enumOptions) {
        boolean hasEnumOption = false;
        for (Enum<?> enumOption : enumOptions) {
            if (enumOption != null) {
                hasEnumOption = true;
                break;
            }
        }
        return schoolDataList == null
                || schoolDataList.isEmpty()
                || !hasEnumOption
                || searchTypeOption != SearchTypeOption.SEARCH_BY_FILTER;
    }

}
