package com.lloydsmithexampledomain.nyc_schools_challenge_app.model.data;

import com.google.gson.annotations.SerializedName;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISATData;

public class SATData implements ISATData {

    @SerializedName("DBN")
    protected String dbn;
    @SerializedName("School Name")
    protected String schoolName;
    @SerializedName("Num of SAT Test Takers")
    protected String testTakersAmount;
    @SerializedName("SAT Critical Reading Avg Score")
    protected String satReadingAvgScore;
    @SerializedName("SAT Math Avg. Score")
    protected String satMathAvgScore;
    @SerializedName("SAT Writing AVG Score")
    protected String satWritingAvgScore;

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
    public String getTestTakersAmount() {
        return testTakersAmount;
    }

    @Override
    public String getSatReadingAvgScore() {
        return satReadingAvgScore;
    }

    @Override
    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    @Override
    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }
}
