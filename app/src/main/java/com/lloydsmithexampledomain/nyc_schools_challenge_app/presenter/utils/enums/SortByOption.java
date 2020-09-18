package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchOptionEnum;

public enum SortByOption implements ISearchOptionEnum {
    ALPHA_SCHOOL_NAME_AZ(R.string.sort_by_items_school_desc),
    ALPHA_SCHOOL_NAME_ZA(R.string.sort_by_items_school_asc),
    ALPHA_CITY_AZ(R.string.sort_by_items_city_desc),
    ALPHA_CITY_ZA(R.string.sort_by_items_city_asc),
    GRADUATION_RATE_DESC(R.string.sort_by_items_graduation_rate_desc),
    GRADUATION_RATE_ASC(R.string.sort_by_items_graduation_rate_asc);

    private int stringID;

    SortByOption(int stringID) {
        this.stringID = stringID;
    }

    @Override
    public int getStringID() {
        return this.stringID;
    }

}
