package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.presenters;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.di.components.DaggerSearchServiceComponent;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts.ISchoolDataCallback;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.model.services.SchoolDataService;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISATData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
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
    SchoolDataService mSchoolService;

    protected IResultsFragmentView mResultsFragmentView;
    protected ISearchParams mSearchParams;
    protected String mCurrentDbnForSATDetails;
    protected static volatile  List<ISchoolData> mCachedSchoolData = new ArrayList<>();
    protected static volatile LinkedHashMap<String, ISATData> mCachedSATData = new LinkedHashMap<>(); // dbn, ISATData
    protected volatile ISchoolDataCallback<List<ISchoolData>> getAllSchoolsCallback = new ISchoolDataCallback<List<ISchoolData>>() {
        @Override
        public void onSuccess(List<ISchoolData> schoolDataList, int httpResponseCode) {
            mCachedSchoolData = schoolDataList;
            processAndDeliverSchoolData();
        }

        @Override
        public void onError(int httpResponseCode, Throwable throwable) {
            mResultsFragmentView.onSchoolSearchError(null, httpResponseCode);
        }
    };
    protected volatile ISchoolDataCallback<ISATData> mSearchForACTDataCallback = new ISchoolDataCallback<ISATData>() {
        @Override
        public void onSuccess(ISATData satData, int httpResponseCode) {
            if (satData != null && satData.getDbn() != null
                    && satData.getSatMathAvgScore() != null
                    && satData.getSatReadingAvgScore() != null
                    && satData.getSatWritingAvgScore() != null) {
                mCachedSATData.put(satData.getDbn(), satData);
            } else {
                // No Data found for DBN - rare, I know...
                for (ISchoolData schoolData : mCachedSchoolData) {
                    if (schoolData.getDbn().equals(mCurrentDbnForSATDetails)) {
                        mResultsFragmentView.onNoSATDetailsFound(schoolData);
                        return;
                    }
                }
                mResultsFragmentView.onSchoolSearchError(null, httpResponseCode);
                return;
            }
            processAndDeliverSchoolData(satData);
        }

        @Override
        public void onError(int httpResponseCode, Throwable throwable) {
            mResultsFragmentView.onSchoolSearchError(null, httpResponseCode);
        }
    };

    @Inject
    public SearchPresenter() {
        DaggerSearchServiceComponent.builder()
                .build()
                .inject(this);
    }

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
            mResultsFragmentView.onSchoolSearchError(null, -1);
            return;
        }

        for (ISchoolData schoolData : mCachedSchoolData) {
            if (schoolData.getDbn().equals(actDataForDbn.getDbn())) {
                if (actDataForDbn.getSatMathAvgScore() != null) {
                    schoolData.setSATForMath(actDataForDbn.getSatMathAvgScore());
                }
                if (actDataForDbn.getSatWritingAvgScore() != null) {
                    schoolData.setSATForWriting(actDataForDbn.getSatWritingAvgScore());
                }
                if (actDataForDbn.getSatReadingAvgScore() != null) {
                    schoolData.setSATForReading(actDataForDbn.getSatReadingAvgScore());
                }

                mResultsFragmentView.onSATDetailsSearchComplete(schoolData);
                return;
            }
        }
        mResultsFragmentView.onSchoolSearchError(null, 500);
    }

    @Override
    public void searchForSchools(ISearchParams searchParams) {
        this.mSearchParams = searchParams;
        if (mResultsFragmentView != null) {
            if (mCachedSchoolData == null || mCachedSchoolData.isEmpty()) {
                mSchoolService.getAllSchools(getAllSchoolsCallback);
            } else {
                processAndDeliverSchoolData();
            }
        }
    }

    @Override
    public void searchForACTData(String dbn) {
        if (StringUtils.isBlank(dbn)) {
            mResultsFragmentView.onSchoolSearchError(null, 400);
            return;
        }

        mCurrentDbnForSATDetails = dbn;

        if (!mCachedSATData.containsKey(dbn)) {
            mSchoolService.getACTDataForDbn(mCurrentDbnForSATDetails, mSearchForACTDataCallback);
        } else {
            ISATData actDataForDbn = mCachedSATData.get(dbn);
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
