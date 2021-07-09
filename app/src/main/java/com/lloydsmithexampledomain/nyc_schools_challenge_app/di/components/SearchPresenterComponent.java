package com.lloydsmithexampledomain.nyc_schools_challenge_app.di.components;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.di.modules.SearchPresenterModule;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.di.modules.SearchServiceModule;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.MainActivity;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.ResultsFragment;

import dagger.Component;

@Component(modules = {
        SearchPresenterModule.class,
        SearchServiceModule.class
})
public interface SearchPresenterComponent {

    void inject(MainActivity activity);
    void inject(ResultsFragment fragment);

}
