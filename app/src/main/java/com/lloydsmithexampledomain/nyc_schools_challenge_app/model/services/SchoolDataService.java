package com.lloydsmithexampledomain.nyc_schools_challenge_app.model.services;

import android.util.Log;

import androidx.annotation.NonNull;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.data.SATData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.data.SchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts.ISchoolDataCallback;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts.ISchoolDataService;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.services.ISchoolDirectoryService;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.utils.ServiceConstants;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISATData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolDataService implements ISchoolDataService {

    private static final String TAG = "SchoolDirectoryService";
    private List<Call<?>> mCallCache = new ArrayList<>();

    @Inject
    public SchoolDataService() {}

    @Override
    public void getAllSchools(final ISchoolDataCallback<List<ISchoolData>> callback) {
        Retrofit retrofit = getRetrofit();

        ISchoolDirectoryService schoolDirectoryService = retrofit.create(ISchoolDirectoryService.class);
        Call<List<SchoolData>> call = schoolDirectoryService.getAllSchools();

        // Adding to cached collection - just in case if there is a need to cancel the call prematurely
        mCallCache.add(call);

        // Asynchronous call
        call.enqueue(new Callback<List<SchoolData>>() {
            @Override
            public void onResponse(@NonNull Call<List<SchoolData>> call, @NonNull Response<List<SchoolData>> response) {
                mCallCache.remove(call);
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    List<ISchoolData> schoolDataList = new ArrayList<>(response.body());
                    callback.onSuccess(schoolDataList, response.code());
                } else {
                    NullPointerException throwable = new NullPointerException("Null response or body.");
                    Log.e(TAG, "onResponse: getAllSchools", throwable);
                    callback.onError(response.code(), throwable);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<SchoolData>> call, @NonNull Throwable throwable) {
                mCallCache.remove(call);
                Log.e(TAG, "onFailure: getAllSchools", throwable);
                callback.onError(500, throwable);
            }
        });
    }

    @Override
    public void getACTDataForDbn(String dbn, final ISchoolDataCallback<ISATData> callback) {
        Retrofit retrofit = getRetrofit();

        ISchoolDirectoryService schoolDirectoryService = retrofit.create(ISchoolDirectoryService.class);
        Call<List<SATData>> call = schoolDirectoryService.getSATDataForSchoolDbn(dbn);

        // Adding to cached collection - just in case if there is a need to cancel the call prematurely
        mCallCache.add(call);

        // Asynchronous call
        call.enqueue(new Callback<List<SATData>>() {
            @Override
            public void onResponse(@NonNull Call<List<SATData>> call, @NonNull Response<List<SATData>> response) {
                mCallCache.remove(call);
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    callback.onSuccess(response.body().get(0), response.code());
                } else {
                    if (response.isSuccessful()) {
                        callback.onSuccess(null, response.code());
                    } else {
                        NullPointerException throwable = new NullPointerException("Null response or body.");
                        Log.e(TAG, "onResponse: getACTDataForDbn", throwable);
                        callback.onError(response.code(), throwable);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<SATData>> call, @NonNull Throwable throwable) {
                mCallCache.remove(call);
                Log.e(TAG, "onFailure: getACTDataForDbn", throwable);
                callback.onError(500, throwable);
            }
        });
    }

    Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ServiceConstants.URL_SCHOOL_SEARCH)
                .build();
    }

    private void abortCalls() {
        for (Call<?> call : mCallCache){
            if (call != null && call.isExecuted() && !call.isCanceled()) {
                call.cancel();
            }
        }
    }

    @Override
    public void onCancelCalled() {
        abortCalls();
    }

    @Override
    public void onDestroy() {
        abortCalls();
    }
}
