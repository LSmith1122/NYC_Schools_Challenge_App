package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchOptionEnum;

public enum LimitTypeOption implements ISearchOptionEnum {
    GRADUATION_RATE_MIN(R.string.limit_by_items_graduation_rate_min),
    GRADUATION_RATE_MAX(R.string.limit_by_items_graduation_rate_max),
    TOTAL_STUDENTS_MIN(R.string.limit_by_items_total_students_min),
    TOTAL_STUDENTS_MAX(R.string.limit_by_items_total_students_max);

    private int stringID;

    LimitTypeOption(int id) {
        this.stringID = id;
    }

    @Override
    public int getStringID() {
        return this.stringID;
    }

}