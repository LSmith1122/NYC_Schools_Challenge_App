package com.lloydsmithexampledomain.nyc_schools_challenge_app.model.interfaces.contracts;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISATData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;

import java.util.List;

public interface ISchoolDataService extends IService {
   void getAllSchools(ISchoolDataCallback<List<ISchoolData>> callback);
   void getACTDataForDbn(String dbn, ISchoolDataCallback<ISATData> callback);
}
