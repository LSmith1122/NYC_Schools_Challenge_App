package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;

import java.util.List;

public interface IResultsFragmentView extends IFragmentView {
    void setSearchListener(ISearchListener searchListener);
    void updateResults(ISearchParams searchParams);
    void onSchoolSearchComplete(List<ISchoolData> schoolDataList);
    void onSATDetailsSearchComplete(ISchoolData completeSchoolData);
    void onNoSATDetailsFound(ISchoolData schoolData);
    void onSchoolSearchError(String errorMessage, int httpCode);
}
