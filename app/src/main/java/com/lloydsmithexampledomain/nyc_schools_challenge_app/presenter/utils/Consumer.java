package com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.utils;

public interface Consumer<TYPE> {
    void accept(TYPE data);
}
