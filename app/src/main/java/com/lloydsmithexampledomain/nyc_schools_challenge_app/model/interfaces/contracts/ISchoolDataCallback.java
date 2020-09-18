package com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts;

public interface ISchoolDataCallback<RESPONSE> {
    void onSuccess(RESPONSE response, int httpResponseCode);
    void onError(int httpResponseCode, Throwable throwable);
}
