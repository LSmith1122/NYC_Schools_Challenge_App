package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces;

public interface Consumer<TYPE> {
    void accept(TYPE data);
}
