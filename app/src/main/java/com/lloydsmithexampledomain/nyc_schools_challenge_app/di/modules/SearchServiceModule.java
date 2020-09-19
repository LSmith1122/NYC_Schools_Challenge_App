package com.lloydsmithexampledomain.nyc_schools_challenge_app.di.modules;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts.ISchoolDataService;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.services.SchoolDataService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchServiceModule {

    @Provides
    @Singleton
    ISchoolDataService providesService(SchoolDataService service) {
        return service;
    }
}
