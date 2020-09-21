package com.lloydsmithexampledomain.nyc_schools_challenge_app;

import android.os.Build;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.NYCSchoolsApplication;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.utils.AppHelper;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Ignore
@Config(application = NYCSchoolsApplication.class,
        sdk = { Build.VERSION_CODES.LOLLIPOP, Build.VERSION_CODES.P })
@RunWith(RobolectricTestRunner.class)
public class BaseTest {

    @Before
    public void setup() throws Exception {
        // This dialog is static, so it will need to be dismissed/null at the beginning of each test
        // to have a clean test every time.
        AppHelper.hideDialog();
    }

}
