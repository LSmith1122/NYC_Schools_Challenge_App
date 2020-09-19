package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities;

import android.os.Build;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.NYCSchoolsApplication;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Ignore
@Config(application = NYCSchoolsApplication.class,
        sdk = { Build.VERSION_CODES.LOLLIPOP, Build.VERSION_CODES.P })
@RunWith(RobolectricTestRunner.class)
public class BaseTest {


}
