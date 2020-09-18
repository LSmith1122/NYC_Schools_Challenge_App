package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.presenters;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts.ISchoolDataCallback;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.services.SchoolDirectoryService;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISATData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.FilterUtils;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums.SearchTypeOption;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.IResultsFragmentView;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;

public class SearchPresenter implements ISearchPresenter {

    @Inject
    SchoolDirectoryService mSchoolService;

    private IResultsFragmentView mResultsFragmentView;
    private ISearchParams mSearchParams;
    private List<ISchoolData> mCachedSchoolData = new ArrayList<>();
    private volatile LinkedHashMap<String, ISATData> mCachedSATData = new LinkedHashMap<>(); // dbn, ISATData

    @Inject
    public SearchPresenter() {}

    private void processAndDeliverSchoolData() {
        List<ISchoolData> filteredList;
        if (mSearchParams.getSearchTypeOption() == SearchTypeOption.SEARCH_BY_NAME) {
            filteredList = FilterUtils.filterBySchoolName(mCachedSchoolData, mSearchParams.getSchoolNameQuery());
        } else {
            filteredList = FilterUtils.filterSchoolData(mSearchParams, mCachedSchoolData);
        }
        mResultsFragmentView.onSchoolSearchComplete(filteredList);
    }

    private void processAndDeliverSchoolData(ISATData actDataForDbn) {
        if (actDataForDbn == null) {
            mResultsFragmentView.onSearchError("", -1);
            return;
        }

        for (ISchoolData schoolData : mCachedSchoolData) {
            if (schoolData.getDbn().equals(actDataForDbn.getDbn())) {
                if (actDataForDbn.getSatMathAvgScore() != null) {
                    schoolData.setSATForMath(Integer.parseInt(actDataForDbn.getSatMathAvgScore()));
                }
                if (actDataForDbn.getSatWritingAvgScore() != null) {
                    schoolData.setSATForWriting(Integer.parseInt(actDataForDbn.getSatWritingAvgScore()));
                }
                if (actDataForDbn.getSatReadingAvgScore() != null) {
                    schoolData.setSATForReading(Integer.parseInt(actDataForDbn.getSatReadingAvgScore()));
                }

                mResultsFragmentView.onSATDetailsSearchComplete(schoolData);
                break;
            }
        }
    }

    @Override
    public synchronized void searchForSchools(ISearchParams searchParams) {
        this.mSearchParams = searchParams;
        if (mResultsFragmentView != null) {
            if (mCachedSchoolData == null || mCachedSchoolData.isEmpty()) {
                ISchoolDataCallback<List<ISchoolData>> callback = new ISchoolDataCallback<List<ISchoolData>>() {
                    @Override
                    public void onSuccess(List<ISchoolData> schoolDataList, int httpResponseCode) {
                        mCachedSchoolData = schoolDataList;
                        processAndDeliverSchoolData();
                    }

                    @Override
                    public void onError(int httpResponseCode, Throwable throwable) {
                        mResultsFragmentView.onSearchError(null, httpResponseCode);
                    }
                };
                mSchoolService.getAllSchools(callback);
            } else {
                processAndDeliverSchoolData();
            }
        }
    }

    @Override
    public synchronized void searchForACTData(String dbn) {
        if (StringUtils.isBlank(dbn)) {
            mResultsFragmentView.onSearchError(null, 400);
            return;
        }

        ISATData actDataForDbn;
        if (!mCachedSATData.containsKey(dbn)) {
            ISchoolDataCallback<ISATData> callback = new ISchoolDataCallback<ISATData>() {
                @Override
                public void onSuccess(ISATData satData, int httpResponseCode) {
                    mCachedSATData.put(dbn, satData);
                    processAndDeliverSchoolData(satData);
                }

                @Override
                public void onError(int httpResponseCode, Throwable throwable) {

                }
            };
            mSchoolService.getACTDataForDbn(dbn, callback);
        } else {
            actDataForDbn = mCachedSATData.get(dbn);
            processAndDeliverSchoolData(actDataForDbn);
        }
    }

    @Override
    public void setResultsFragmentView(IResultsFragmentView resultsFragmentView) {
        mResultsFragmentView = resultsFragmentView;
    }

    @Override
    public void onDestroy() {
        mSchoolService.onDestroy();
    }
}
