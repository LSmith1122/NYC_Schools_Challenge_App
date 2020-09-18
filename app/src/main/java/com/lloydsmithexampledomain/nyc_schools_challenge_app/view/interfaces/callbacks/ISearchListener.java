package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;

public interface ISearchListener {
    void onSearch(ISearchParams searchParams);
    void onCompleteDetailsRetrieved(ISchoolData completeSchoolData);
}
