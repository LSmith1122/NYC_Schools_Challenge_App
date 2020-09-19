package com.lloydsmithexampledomain.nyc_schools_challenge_app.di.components;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.di.modules.SearchServiceModule;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.presenters.SearchPresenter;

import dagger.Component;

@Component(modules = SearchServiceModule.class )
public interface SearchServiceComponent {

    void inject(SearchPresenter presenter);

}
