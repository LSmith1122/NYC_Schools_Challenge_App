package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.utils;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.BaseActivity;

import org.apache.commons.lang3.StringUtils;

public final class SchoolDetailsHelper {

    private static final String TAG = "SchoolDetailsHelper";

    public static void goToWebsite(BaseActivity activity, ISchoolData schoolData) {
        if (StringUtils.isNotBlank(schoolData.getWebsite())) {
            Intent website = new Intent(Intent.ACTION_VIEW);
            website.setData(Uri.parse("https://" + schoolData.getWebsite()));
            activity.startActivity(website);
        } else {
            Log.e(TAG, "goToWebsite: School Name must not be null", new NullPointerException());
            showError(activity);
        }
    }

    public static void goToLocation(BaseActivity activity, ISchoolData schoolData) {
        if (isLocationPrimaryAvailable(schoolData) || isLocationSecondaryAvailable(schoolData)) {
            Uri uri;
            if (isLocationPrimaryAvailable(schoolData)) {
                uri = Uri.parse(String.format("geo:%s\\,%s?", schoolData.getLatitude(), schoolData.getLongitude()))
                        .buildUpon()
                        .appendQueryParameter("q", schoolData.getSchoolName())
                        .build();
            } else {
                uri = Uri.parse("geo:0,0?")
                        .buildUpon()
                        .appendQueryParameter("q", String.format(
                                "%s %s %s %s",
                                schoolData.getSchoolName(),
                                schoolData.getPrimaryAddressLine(),
                                schoolData.getCity(),
                                schoolData.getStateCode()))
                        .build();
            }
            Intent location = new Intent(Intent.ACTION_VIEW);
            location.setData(uri);
            if (location.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivity(location);
            } else {
                Log.e(TAG, "goToLocation: Failed to launch Map", new UnsupportedOperationException());
                showError(activity);
            }
        } else {
            Log.e(TAG, "goToLocation: Proper location data is not available", new NullPointerException());
            showError(activity);
        }
    }

    public static boolean isLocationPrimaryAvailable(ISchoolData schoolData) {
        return StringUtils.isNotBlank(schoolData.getSchoolName())
                && StringUtils.isNotBlank(schoolData.getLatitude())
                && StringUtils.isNotBlank(schoolData.getLongitude());
    }

    public static boolean isLocationSecondaryAvailable(ISchoolData schoolData) {
        return StringUtils.isNotBlank(schoolData.getSchoolName())
                && (StringUtils.isNotBlank(schoolData.getPrimaryAddressLine())
                || StringUtils.isNotBlank(schoolData.getCity())
                || StringUtils.isNotBlank(schoolData.getStateCode()));
    }

    public static String getSchoolLocationText(ISchoolData schoolData) {
        StringBuilder output = new StringBuilder();
        if (StringUtils.isNotBlank(schoolData.getPrimaryAddressLine())) {
            output.append(schoolData.getPrimaryAddressLine());
        }
        if (StringUtils.isNotBlank(schoolData.getCity())) {
            if (StringUtils.isNotBlank(schoolData.getPrimaryAddressLine())) {
                output.append(",\\s");
            }
            output.append(schoolData.getCity());
        }
        if (StringUtils.isNotBlank(schoolData.getStateCode())) {
            if (StringUtils.isNotBlank(schoolData.getPrimaryAddressLine()) || StringUtils.isNotBlank(schoolData.getCity())) {
                output.append(",\\s");
            }
            output.append(schoolData.getStateCode());
        }
        if (StringUtils.isNotBlank(schoolData.getPostcode())) {
            if (StringUtils.isNotBlank(schoolData.getPrimaryAddressLine()) || StringUtils.isNotBlank(schoolData.getCity()) || StringUtils.isNotBlank(schoolData.getStateCode())) {
                output.append(",\\s");
            }
            output.append(schoolData.getPostcode());
        }

        return output.toString();
    }

    private static void showError(BaseActivity activity) {
        activity.showInformationalDialog(activity.getString(R.string.error_unexpected_error));
    }
}
