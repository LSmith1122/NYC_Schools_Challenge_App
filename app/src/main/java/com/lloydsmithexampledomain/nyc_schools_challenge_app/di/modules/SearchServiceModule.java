package com.lloydsmithexampledomain.nyc_schools_challenge_app.di.modules;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts.ISchoolDataService;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.services.SchoolDataService;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SearchServiceModule {

    @Binds
    abstract ISchoolDataService providesService(SchoolDataService service);
}
