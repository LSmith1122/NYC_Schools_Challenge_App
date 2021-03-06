package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts;

import java.io.Serializable;

public interface ISATData extends Serializable {
    String getDbn();
    String getSchoolName();
    Integer getTestTakersAmount();
    Integer getSatReadingAvgScore();
    Integer getSatMathAvgScore();
    Integer getSatWritingAvgScore();
}
