package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;

public interface ISearchOptionsFragmentView extends IFragmentView {
    void setSearchListener(ISearchListener searchListener);
    String[] getDisplayNamesForSortByOption();
    String[] getDisplayNamesForFilterByOption();
    String[] getDisplayNamesForLimitTypeOption();
}
