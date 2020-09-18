package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.modules;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.presenters.SearchPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchPresenterModule {

    @Provides
    ISearchPresenter providesPresenter(SearchPresenter presenter) {
        return presenter;
    }

}
