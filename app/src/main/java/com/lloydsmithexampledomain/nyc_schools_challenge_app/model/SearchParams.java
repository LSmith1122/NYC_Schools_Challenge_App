package com.lloydsmithexampledomain.nyc_schools_challenge_app.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SearchParams implements Serializable {

    @SerializedName("searchOption")
    protected SearchOption searchOption;
    @SerializedName("schoolNameQuery")
    protected String schoolNameQuery;
    @SerializedName("sortBy")
    protected SortByOption sortByOption;
    @SerializedName("filterBy")
    protected FilterByOption filterByOption;
    @SerializedName("limit")
    protected LimitType limit;

    public enum SearchOption {
        SEARCH_BY_NAME,
        SEARCH_BY_FILTER }

    public enum SortByOption {
        ALPHA_SCHOOL_NAME_AZ,
        ALPHA_SCHOOL_NAME_ZA,
        ALPHA_CITY_AZ,
        ALPHA_CITY_ZA,
        GRADUATION_RATE
    }

    public enum FilterByOption {
        STATE,
        CITY
    }

    public enum LimitType {
        GRADUATION_RATE_MIN,
        GRADUATION_RATE_MAX,
        TOTAL_STUDENTS_MIN,
        TOTAL_STUDENTS_MAX
    }

    public SearchParams(SearchOption searchOption, String schoolNameQuery, SortByOption sortByOption, FilterByOption filterByOption, LimitType limit) {
        this.searchOption = searchOption;
        this.schoolNameQuery = schoolNameQuery;
        this.sortByOption = sortByOption;
        this.filterByOption = filterByOption;
        this.limit = limit;
    }

    public SearchOption getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(SearchOption searchOption) {
        this.searchOption = searchOption;
    }

    public String getSchoolNameQuery() {
        return schoolNameQuery;
    }

    public void setSchoolNameQuery(String schoolNameQuery) {
        this.schoolNameQuery = schoolNameQuery;
    }

    public SortByOption getSortByOption() {
        return sortByOption;
    }

    public void setSortByOption(SortByOption sortByOption) {
        this.sortByOption = sortByOption;
    }

    public FilterByOption getFilterByOption() {
        return filterByOption;
    }

    public void setFilterByOption(FilterByOption filterByOption) {
        this.filterByOption = filterByOption;
    }

    public LimitType getLimit() {
        return limit;
    }

    public void setLimit(LimitType limit) {
        this.limit = limit;
    }
}
