package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.FilterByOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.LimitTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SortByOption;

import java.io.Serializable;

public interface ISearchParams extends Serializable {
    SearchTypeOption getSearchTypeOption();
    String getSchoolNameQuery();
    SortByOption getSortByOption();
    FilterByOption getFilterByOption();
    String getFilterByOptionQuery();
    LimitTypeOption getLimitByOption();
    String getLimitByOptionQuery();
    Integer getResultMaxCount();
}
