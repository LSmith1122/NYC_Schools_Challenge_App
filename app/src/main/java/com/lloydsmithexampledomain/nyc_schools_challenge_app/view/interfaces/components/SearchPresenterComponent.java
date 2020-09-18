package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.components;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.MainActivity;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.ResultsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.modules.SearchPresenterModule;

import dagger.Component;

@Component(modules = { SearchPresenterModule.class })
public interface SearchPresenterComponent {

    void inject(MainActivity activity);
    void inject(ResultsFragment fragment);

}
