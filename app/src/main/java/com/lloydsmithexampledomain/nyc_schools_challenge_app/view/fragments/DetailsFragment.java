package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.databinding.FragmentDetailsBinding;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities.BaseActivity;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.IDetailsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.utils.SchoolDetailsHelper;

import org.apache.commons.lang3.StringUtils;

public class DetailsFragment extends BaseFragment implements IDetailsFragment {

    private static final String TAG = "DetailsFragment";
    private FragmentDetailsBinding mBinding;
    private ISchoolData mCompleteSchoolData;

    public DetailsFragment() {
    }

    public static DetailsFragment newInstance(ISchoolData completeSchoolData) {
        DetailsFragment fragment = new DetailsFragment();
        fragment.setCompleteSchoolData(completeSchoolData);
        return fragment;
    }

    private void init() {
        if (DetailsFragment.this.getActivity() instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) DetailsFragment.this.getActivity();
            mBinding.detailsSchoolName.setText(mCompleteSchoolData.getSchoolName());

            // Location
            if (SchoolDetailsHelper.isLocationPrimaryAvailable(mCompleteSchoolData) || SchoolDetailsHelper.isLocationSecondaryAvailable(mCompleteSchoolData)) {
                mBinding.detailsSchoolAddress.setText(SchoolDetailsHelper.getSchoolLocationText(mCompleteSchoolData));
            } else {
                mBinding.detailsSchoolAddress.setVisibility(View.GONE);
            }

            // Start / End Time
            if (StringUtils.isNotBlank(mCompleteSchoolData.getStartTime()) && StringUtils.isNotBlank(mCompleteSchoolData.getEndTime())) {
                mBinding.detailsSchoolStartEndTime.setText(String.format("%s - %s", mCompleteSchoolData.getStartTime(), mCompleteSchoolData.getEndTime()));
            } else {
                mBinding.detailsSchoolStartEndTime.setVisibility(View.GONE);
            }

            // Overview
            if (StringUtils.isNotBlank(mCompleteSchoolData.getOverviewParagraph())) {
                mBinding.detailsOverview.setText(mCompleteSchoolData.getOverviewParagraph());
            } else {
                mBinding.detailsOverview.setVisibility(View.GONE);
            }

            // SAT Scores
            if (mCompleteSchoolData.getSATForReading() != null
                    && mCompleteSchoolData.getSATForWriting() != null
                    && mCompleteSchoolData.getSATForMath() != null) {
                mBinding.detailsSatScoreReading.setText(String.valueOf(mCompleteSchoolData.getSATForReading()));
                mBinding.detailsSatScoreWriting.setText(String.valueOf(mCompleteSchoolData.getSATForWriting()));
                mBinding.detailsSatScoreMath.setText(String.valueOf(mCompleteSchoolData.getSATForMath()));
            }

            // Academics
            if (isAcademicsDataAvailable(mCompleteSchoolData)) {
                mBinding.detailsAcademics.setText(getAcademicsDisplayString(mCompleteSchoolData), TextView.BufferType.SPANNABLE);
            } else {
                mBinding.detailsAcademicsGroup.setVisibility(View.GONE);
            }

            // Sports
            if (isAcademicsDataAvailable(mCompleteSchoolData)) {
                mBinding.detailsSports.setText(getSportsDisplayString(mCompleteSchoolData), TextView.BufferType.SPANNABLE);
            } else {
                mBinding.detailsSportsGroup.setVisibility(View.GONE);
            }

            // Additional Information
            if (StringUtils.isNotBlank(mCompleteSchoolData.getAdditionalInfo())) {
                mBinding.detailsAdditionalInformation.setText(mCompleteSchoolData.getAdditionalInfo());
            } else {
                mBinding.detailsAdditionalInformationGroup.setVisibility(View.GONE);
            }

            mBinding.detailsSchoolAddress.setOnClickListener(v -> SchoolDetailsHelper.goToWebsite(activity, mCompleteSchoolData));
            mBinding.fab.setOnClickListener(v -> showFabItems());
            mBinding.fabWebsite.setOnClickListener(v -> SchoolDetailsHelper.goToWebsite(activity, mCompleteSchoolData));
            mBinding.fabLocation.setOnClickListener(v -> SchoolDetailsHelper.goToLocation(activity, mCompleteSchoolData));
            mBinding.fabCall.setOnClickListener(v -> SchoolDetailsHelper.goToDialPad(activity, mCompleteSchoolData));

            setFabVisibility();
        }
    }

    private SpannableStringBuilder getAcademicsDisplayString(ISchoolData schoolData) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        addBulletPoint(builder, schoolData.getAcademicOpportunities1());
        addBulletPoint(builder, schoolData.getAcademicOpportunities2());
        addBulletPoint(builder, schoolData.getAcademicOpportunities3());
        addBulletPoint(builder, schoolData.getAcademicOpportunities4());
        addBulletPoint(builder, schoolData.getAcademicOpportunities5());
        return builder;
    }

    private SpannableStringBuilder getSportsDisplayString(ISchoolData schoolData) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        addBulletPointsForSports(builder, getString(R.string.details_coed_sports_section_text), schoolData.getSportsCoed());
        builder.append("\n");
        addBulletPointsForSports(builder, getString(R.string.details_girls_sports_section_text), schoolData.getSportsGirls());
        builder.append("\n");
        addBulletPointsForSports(builder, getString(R.string.details_boys_sports_section_text), schoolData.getSportsBoys());
        return builder;
    }

    private void addBulletPointsForSports(SpannableStringBuilder builder, String sectionName, String sports) {
        if (!builder.toString().isEmpty()) {
            builder.append("\n");
        }
        if (StringUtils.isNotBlank(sports)) {
            builder.append(sectionName);
            String[] splitCoed = sports.split("\\, ");
            for (String sport : splitCoed) {
                addBulletPoint(builder, sport);
            }
        }
    }

    private void addBulletPoint(SpannableStringBuilder builder, String text) {
        if (StringUtils.isNotBlank(text)) {
            builder.append("\n");
            int start = builder.length();
            builder.append(text);
            builder.setSpan(
                    new BulletSpan(40, getContext().getResources().getColor(R.color.black)),
                    start,
                    start + text.length(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
    }

    boolean isAcademicsDataAvailable(ISchoolData schoolData) {
        return StringUtils.isNotBlank(schoolData.getAcademicOpportunities1())
                || StringUtils.isNotBlank(schoolData.getAcademicOpportunities2())
                || StringUtils.isNotBlank(schoolData.getAcademicOpportunities3())
                || StringUtils.isNotBlank(schoolData.getAcademicOpportunities4());
    }

    private void setFabVisibility() {
        int visibility = isFabLocationDataAvailable()
                || StringUtils.isNotBlank(mCompleteSchoolData.getWebsite())
                || StringUtils.isNotBlank(mCompleteSchoolData.getPhoneNumber())
                ? View.VISIBLE : View.GONE;
        mBinding.fab.setVisibility(visibility);
    }

    private void showFabItems() {
        if (isFabLocationDataAvailable()) {
            int visibility = mBinding.fabLocation.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
            mBinding.fabLocation.setVisibility(visibility);
        }

        if (StringUtils.isNotBlank(mCompleteSchoolData.getWebsite())) {
            int visibility = mBinding.fabWebsite.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
            mBinding.fabWebsite.setVisibility(visibility);
        }

        if (StringUtils.isNotBlank(mCompleteSchoolData.getPhoneNumber())) {
            int visibility = mBinding.fabCall.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
            mBinding.fabCall.setVisibility(visibility);
        }
    }

    private boolean isFabLocationDataAvailable() {
        return SchoolDetailsHelper.isLocationPrimaryAvailable(mCompleteSchoolData) || SchoolDetailsHelper.isLocationSecondaryAvailable(mCompleteSchoolData);
    }

    @Override
    public void setCompleteSchoolData(ISchoolData completeSchoolData) {
        mCompleteSchoolData = completeSchoolData;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentDetailsBinding.inflate(inflater, container, false);
        init();
        return mBinding.getRoot();
    }
}
