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
            if (school.getSchoolName().toLowerCase().contains(schoolName.toLowerCase().trim())) {
               list.add(school);
            }
        }
        if (list.isEmpty()) {
            return null;
        }

        sortBySchoolNameAlphabetically(list, false);

        return list;
    }

    public static List<ISchoolData> filterSchoolData(ISearchParams searchParams, List<ISchoolData> schoolDataList) {
        final List<ISchoolData> list = new ArrayList<>();
        if (isDataForFilterInvalid(
                schoolDataList,
                searchParams.getSortByOption(),
                searchParams.getFilterByOption(),
                searchParams.getLimitByOption())) {
            return list;
        }

        for (ISchoolData schoolData : schoolDataList) {
            boolean hasFilters = false;
            Integer resultMaxCount = searchParams.getResultMaxCount();
            if (resultMaxCount != null && resultMaxCount <= list.size()) {
                break;
            }
            if (searchParams.getLimitByOption() == null && searchParams.getFilterByOption() == null && resultMaxCount != null) {
                list.add(schoolData);
            } else {
                boolean isLimitSuccessful = true;
                boolean isFilterSuccessful = true;
                if (searchParams.getLimitByOption() != null) {
                    hasFilters = true;
                    isLimitSuccessful = limitSchoolData(searchParams, list, schoolData);
                }
                if (searchParams.getFilterByOption() != null) {
                    hasFilters = true;
                    isFilterSuccessful = filterSchoolData(searchParams, list, schoolData);
                }

                if (!hasFilters) {
                    break;
                }

                if (isFilterSuccessful && isLimitSuccessful) {
                    list.add(schoolData);
                }
            }
        }

        if (list.isEmpty()) {
            list.addAll(schoolDataList);
        }
        if (!list.isEmpty()) {
            sortSchoolData(list, searchParams.getSortByOption());
        }

        return list;
    }

    private static boolean limitSchoolData(ISearchParams searchParams, List<ISchoolData> list, ISchoolData schoolData) {
        Double graduationRatePercentage = schoolData.getGraduationRatePercentage();
        Integer totalStudents = schoolData.getTotalStudents();
        switch (searchParams.getLimitByOption()) {
            case GRADUATION_RATE_MIN:
                if (graduationRatePercentage == null) {
                    return false;
                }
                int queryAmountMin = Integer.parseInt(searchParams.getLimitByOptionQuery());
                double dataMin = Math.floor(graduationRatePercentage * 100);
                return limitSchoolDataByAmount(list, schoolData, dataMin, queryAmountMin, true);
            case GRADUATION_RATE_MAX:
                if (graduationRatePercentage == null) {
                    return false;
                }
                int queryAmountMax = Integer.parseInt(searchParams.getLimitByOptionQuery());
                double dataMax = Math.floor(graduationRatePercentage * 100);
                return limitSchoolDataByAmount(list, schoolData, dataMax, queryAmountMax, false);
            case TOTAL_STUDENTS_MIN:
                if (totalStudents == null) {
                    return false;
                }
                int totalStudentsQueryAmountMin = Integer.parseInt(searchParams.getLimitByOptionQuery());
                return limitSchoolDataByAmount(list, schoolData, totalStudents, totalStudentsQueryAmountMin, true);
            case TOTAL_STUDENTS_MAX:
                if (totalStudents == null) {
                    return false;
                }
                int totalStudentsQueryAmountMax = Integer.parseInt(searchParams.getLimitByOptionQuery());
                return limitSchoolDataByAmount(list, schoolData, totalStudents, totalStudentsQueryAmountMax, false);
        }
        return false;
    }

    private static boolean limitSchoolDataByAmount(List<ISchoolData> list, ISchoolData schoolData, double data, int queryAmount, boolean isMin) {
        if (isMin) {
            if (data >= queryAmount) {
                return true;
            }
        } else {
            if (data < queryAmount) {
                return true;
            }
        }
        return false;
    }

    private static boolean filterSchoolData(ISearchParams searchParams, List<ISchoolData> list, ISchoolData schoolData) {
        switch (searchParams.getFilterByOption()) {
            case CITY:
                return filterSchoolDataByCity(searchParams, schoolData, list);
            case AVAILABLE_ACADEMICS:
                return filterSchoolDataByAcademics(searchParams, schoolData, list);
            case AVAILABLE_SPORTS:
                return filterSchoolDataBySports(searchParams, schoolData, list);
        }
        return false;
    }

    public static boolean sortSchoolData(List<ISchoolData> schoolDataList, SortByOption sortByOption) {
        if (isDataForFilterInvalid(schoolDataList, sortByOption)) {
            return false;
        }

        switch (sortByOption) {
            case ALPHA_SCHOOL_NAME_AZ:
                return sortBySchoolNameAlphabetically(schoolDataList, false);
            case ALPHA_SCHOOL_NAME_ZA:
                return sortBySchoolNameAlphabetically(schoolDataList, true);
            case ALPHA_CITY_AZ:
                return sortBySchoolCityAlphabetically(schoolDataList, false);
            case ALPHA_CITY_ZA:
                return sortBySchoolCityAlphabetically(schoolDataList, true);
            case GRADUATION_RATE_DESC:
                return sortBySchoolGraduationRate(schoolDataList, true);
            case GRADUATION_RATE_ASC:
                return sortBySchoolGraduationRate(schoolDataList, false);
        }
        return false;
    }

    private static boolean sortBySchoolNameAlphabetically(List<ISchoolData> schoolDataList, boolean shouldAscend) {
        if (schoolDataList == null || schoolDataList.isEmpty()) {
            return false;
        }

        Collections.sort(schoolDataList, (school1, school2) -> {
            if (shouldAscend) {
                return school2.getSchoolName().compareTo(school1.getSchoolName());
            } else {
                return school1.getSchoolName().compareTo(school2.getSchoolName());
            }
        });
        return true;
    }

    private static boolean sortBySchoolCityAlphabetically(List<ISchoolData> schoolDataList, boolean shouldAscend) {
        if (schoolDataList == null || schoolDataList.isEmpty()) {
            return false;
        }

        Collections.sort(schoolDataList, (school1, school2) -> {
            if (shouldAscend) {
                return school2.getCity().compareTo(school1.getCity());
            } else {
                return school1.getCity().compareTo(school2.getCity());
            }
        });
        return true;
    }

    private static boolean sortBySchoolGraduationRate(List<ISchoolData> schoolDataList, boolean shouldAscend) {
        if (schoolDataList == null || schoolDataList.isEmpty()) {
            return false;
        }

        Collections.sort(schoolDataList, (school1, school2) -> {
            Double graduationRatePercentage1 = school2.getGraduationRatePercentage() != null ? school2.getGraduationRatePercentage() : -1;
            Double graduationRatePercentage2 = school1.getGraduationRatePercentage() != null ? school1.getGraduationRatePercentage() : -1;
            if (shouldAscend) {
                return graduationRatePercentage1.compareTo(graduationRatePercentage2);
            } else {
                return graduationRatePercentage2.compareTo(graduationRatePercentage1);
            }
        });
        return true;
    }

    private static boolean filterSchoolDataByCity(ISearchParams searchParams, ISchoolData schoolData, List<ISchoolData> list) {
        try {
            if (schoolData.getCity().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "filterSchoolData: CITY", e);
        }
        return false;
    }

    private static boolean filterSchoolDataByAcademics(ISearchParams searchParams, ISchoolData schoolData, List<ISchoolData> list) {
        try {
            if (schoolData.getAcademicOpportunities1().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getAcademicOpportunities2().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getAcademicOpportunities3().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getAcademicOpportunities4().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getAcademicOpportunities5().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "filterSchoolData: AVAILABLE_ACADEMICS", e);
        }
        return false;
    }

    private static boolean filterSchoolDataBySports(ISearchParams searchParams,ISchoolData schoolData, List<ISchoolData> list) {
        try {
            if (schoolData.getSchoolSports().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getSportsBoys().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getSportsGirls().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getSportsCoed().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            } else if (schoolData.getSchoolSports().toLowerCase().contains(searchParams.getFilterByOptionQuery().toLowerCase().trim())) {
                return true;
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "filterSchoolData: AVAILABLE_SPORTS", e);
        }
        return false;
    }

    static boolean isDataForFilterInvalid(List<ISchoolData> schoolDataList, Enum<?>... enumOptions) {
        boolean hasEnumOption = false;
        for (Enum<?> enumOption : enumOptions) {
            if (enumOption != null) {
                hasEnumOption = true;
                break;
            }
        }
        return schoolDataList == null
                || schoolDataList.isEmpty()
                || !hasEnumOption;
    }
}
