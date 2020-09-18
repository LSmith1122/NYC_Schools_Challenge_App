package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;

public interface IDetailsFragment extends IFragmentView {
    void setCompleteSchoolData(ISchoolData completeSchoolData);
}
