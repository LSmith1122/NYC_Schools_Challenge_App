package com.lloydsmithexampledomain.nyc_schools_challenge_app.model.data;

import com.google.gson.annotations.SerializedName;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISATData;

public class SATData implements ISATData {

    @SerializedName("dbn")
    protected String dbn;
    @SerializedName("school_name")
    protected String schoolName;
    @SerializedName("num_of_sat_test_takers")
    protected Integer testTakersAmount;
    @SerializedName("sat_critical_reading_avg_score")
    protected Integer satReadingAvgScore;
    @SerializedName("sat_math_avg_score")
    protected Integer satMathAvgScore;
    @SerializedName("sat_writing_avg_score")
    protected Integer satWritingAvgScore;

    public SATData() {}

    @Override
    public String getDbn() {
        return dbn;
    }

    @Override
    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public Integer getTestTakersAmount() {
        return testTakersAmount;
    }

    @Override
    public Integer getSatReadingAvgScore() {
        return satReadingAvgScore;
    }

    @Override
    public Integer getSatMathAvgScore() {
        return satMathAvgScore;
    }

    @Override
    public Integer getSatWritingAvgScore() {
        return satWritingAvgScore;
    }
}
