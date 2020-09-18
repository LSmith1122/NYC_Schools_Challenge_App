package com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.services;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.data.SATData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.data.SchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.utils.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ISchoolDirectoryService {

    @GET(ServiceConstants.PATH_SCHOOL_LOOKUP_SEARCH)
    Call<List<SchoolData>> getAllSchools();

    @GET(ServiceConstants.PATH_SCHOOL_SAT_SEARCH)
    Call<SATData> getSATDataForSchoolDbn(@Query(value = "dbn") String dbn);

}
