package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils.enums;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchOptionEnum;

public enum FilterByOption implements ISearchOptionEnum {
    CITY(R.string.filter_by_items_city),
    AVAILABLE_ACADEMICS(R.string.filter_by_items_academics),
    AVAILABLE_SPORTS(R.string.filter_by_items_sports);

    private int stringID;

    FilterByOption(int id) {
        this.stringID = id;
    }

    @Override
    public int getStringID() {
        return this.stringID;
    }

}
