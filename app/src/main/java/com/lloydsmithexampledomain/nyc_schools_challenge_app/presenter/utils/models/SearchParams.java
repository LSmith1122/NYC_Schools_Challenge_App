package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.models;

import com.google.gson.annotations.SerializedName;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.FilterByOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.LimitTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SortByOption;

public class SearchParams implements ISearchParams {

    @SerializedName("searchOption")
    protected SearchTypeOption searchTypeOption;
    @SerializedName("schoolNameQuery")
    protected String schoolNameQuery;
    @SerializedName("sortBy")
    protected SortByOption sortByOption;
    @SerializedName("filterBy")
    protected FilterByOption filterByOption;
    @SerializedName("filterByQuery")
    protected String filterByOptionQuery;
    @SerializedName("limit")
    protected LimitTypeOption limit;
    @SerializedName("limitQuery")
    protected String limitQuery;
    @SerializedName("resultMaxCount")
    protected Integer resultMaxCount;

    public enum ResultMaxCountOption{}

    public SearchParams() {}

    public SearchParams(SearchTypeOption searchTypeOption,
                        String schoolNameQuery,
                        SortByOption sortByOption,
                        FilterByOption filterByOption,
                        LimitTypeOption limitByOption,
                        Integer resultMaxCount) {
        this.searchTypeOption = searchTypeOption;
        this.schoolNameQuery = schoolNameQuery;
        this.sortByOption = sortByOption;
        this.filterByOption = filterByOption;
        this.limit = limitByOption;
        this.resultMaxCount = resultMaxCount;
    }

    @Override
    public SearchTypeOption getSearchTypeOption() {
        return searchTypeOption;
    }

    public void setSearchTypeOption(SearchTypeOption searchTypeOption) {
        this.searchTypeOption = searchTypeOption;
    }

    @Override
    public String getSchoolNameQuery() {
        return schoolNameQuery;
    }

    public void setSchoolNameQuery(String schoolNameQuery) {
        this.schoolNameQuery = schoolNameQuery;
    }

    @Override
    public SortByOption getSortByOption() {
        return sortByOption;
    }

    public void setSortByOption(SortByOption sortByOption) {
        this.sortByOption = sortByOption;
    }

    @Override
    public FilterByOption getFilterByOption() {
        return filterByOption;
    }

    public void setFilterByOption(FilterByOption filterByOption) {
        this.filterByOption = filterByOption;
    }

    @Override
    public String getFilterByOptionQuery() {
        return filterByOptionQuery;
    }

    public void setFilterByOptionQuery(String filterByOptionQuery) {
        this.filterByOptionQuery = filterByOptionQuery;
    }

    @Override
    public LimitTypeOption getLimitByOption() {
        return limit;
    }

    public void setLimitByOption(LimitTypeOption limit) {
        this.limit = limit;
    }

    @Override
    public String getLimitByOptionQuery() {
        return limitQuery;
    }

    public void setLimitQuery(String limitQuery) {
        this.limitQuery = limitQuery;
    }

    @Override
    public Integer getResultMaxCount() {
        return resultMaxCount;
    }

    public void setResultMaxCount(Integer resultMaxCount) {
        this.resultMaxCount = resultMaxCount;
    }
}
