package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.IResultsFragmentView;

public interface ISearchPresenter extends IPresenter {
    void setResultsFragmentView(IResultsFragmentView resultsFragmentView);
    void searchForSchools(ISearchParams searchParams);
    void searchForACTData(String dbn);
}
