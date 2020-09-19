package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.DetailsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.ResultsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.SearchOptionsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.components.DaggerSearchPresenterComponent;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.ISearchView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements ISearchView, ISearchListener {

    @Inject
    ISearchPresenter mSearchPresenter;
    private FragmentManager mFragmentManager;
    private ResultsFragment mResultsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerSearchPresenterComponent.builder().build().inject(this);

        mFragmentManager = getSupportFragmentManager();

        showSearchOptionsFragment();
    }

    @Override
    public void onSearch(ISearchParams searchParams) {
        showOrUpdateResultsFragment(searchParams);
    }

    @Override
    public void onCompleteDetailsRetrieved(ISchoolData completeSchoolData) {
        showDetailsFragment(completeSchoolData);
    }

    void showSearchOptionsFragment() {
        SearchOptionsFragment searchOptionsFragment = SearchOptionsFragment.newInstance(this);
        mFragmentManager.beginTransaction()
                .replace(R.id.main_activity_left_panel, searchOptionsFragment)
                .addToBackStack(SearchOptionsFragment.class.getSimpleName())
                .commit();
    }

    void showOrUpdateResultsFragment(ISearchParams searchParams) {
        if (mFragmentManager == null) {
            mFragmentManager = getSupportFragmentManager();
        }

        if (mResultsFragment == null || isPortraitOrientation()) {
            mResultsFragment = ResultsFragment.newInstance(searchParams, this);
            mFragmentManager.beginTransaction()
                    .add(getLayoutIdForContent(), mResultsFragment, ResultsFragment.class.getSimpleName())
                    .addToBackStack(ResultsFragment.class.getSimpleName())
                    .commit();
        } else {
            mResultsFragment.updateResults(searchParams);
        }
    }

    void showDetailsFragment(ISchoolData completeSchoolData) {
        DetailsFragment fragment = DetailsFragment.newInstance(completeSchoolData);
        mFragmentManager.beginTransaction()
                .add(getLayoutIdForContent(), fragment, DetailsFragment.class.getSimpleName())
                .addToBackStack(DetailsFragment.class.getSimpleName())
                .commit();
    }

    int getLayoutIdForContent() {
        return isPortraitOrientation() ? R.id.main_activity_left_panel : R.id.main_activity_right_panel;
    }

    private boolean isPortraitOrientation() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    @Override
    public void onBackPressed() {
        // Remove expendable fragments
        int savePosition = isPortraitOrientation() ? 1 : 2;
        int lastBackStackCount = mFragmentManager.getBackStackEntryCount();
        if (lastBackStackCount > savePosition) {
            mFragmentManager.popBackStack();
        } else {
            // Consider presenting a dialog to the User, prompting them to exit the app or stay.
            mDialog = createInformationalDialog(
                    getString(R.string.exit_app),
                    true,
                    (dialog, which) -> finishAffinity(),
                    (dialog, which) -> dialog.dismiss())
                    .create();
            mDialog.show();
        }
    }
}