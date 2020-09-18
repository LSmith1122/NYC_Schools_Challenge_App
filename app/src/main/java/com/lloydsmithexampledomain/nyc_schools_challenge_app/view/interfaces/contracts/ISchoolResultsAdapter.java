package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;

public interface ISchoolResultsAdapter {
    void setItemClickListener(OnItemClickListener clickListener);

    interface OnItemClickListener {
        void onItemClicked(ISchoolData schoolData);
    }
}
