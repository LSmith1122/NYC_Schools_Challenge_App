package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.activities;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentManager;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.DetailsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.ResultsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.SearchOptionsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
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
        DetailsFragment fragment = DetailsFragment.newInstance(completeSchoolData);
        mFragmentManager.beginTransaction()
                .add(getLayoutIdForContent(), fragment, DetailsFragment.class.getSimpleName())
                .addToBackStack(DetailsFragment.class.getSimpleName());
    }

    private void showSearchOptionsFragment() {
        SearchOptionsFragment searchOptionsFragment = SearchOptionsFragment.newInstance(this);
        mFragmentManager.beginTransaction()
                .replace(R.id.main_activity_left_panel, searchOptionsFragment)
                .addToBackStack(SearchOptionsFragment.class.getSimpleName())
                .commit();
    }

    int getLayoutIdForContent() {
        return isPortraitOrientation() ? R.id.main_activity_left_panel : R.id.main_activity_right_panel;
    }

    private void showOrUpdateResultsFragment(ISearchParams searchParams) {
        if (mFragmentManager == null) {
            return;
        }

        if (mResultsFragment == null || isPortraitOrientation()) {
            popExpendableBackStack();
            mResultsFragment = ResultsFragment.newInstance(searchParams, this);
            mFragmentManager.beginTransaction()
                    .add(getLayoutIdForContent(), mResultsFragment, ResultsFragment.class.getSimpleName())
                    .addToBackStack(ResultsFragment.class.getSimpleName())
                    .commit();
        } else {
            mResultsFragment.updateResults(searchParams);
        }
    }

    private void popExpendableBackStack() {
        // Adding this just in case if the User is operating the application in landscape mode
        // and the DetailsFragment is currently being shown. In this scenario, we are removing the DetailsFragment
        // to re-show the underlying ResultsFragment
        if (isPortraitOrientation()) {
            mFragmentManager.popBackStack(ResultsFragment.class.getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            mFragmentManager.popBackStack(DetailsFragment.class.getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    private boolean isPortraitOrientation() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    @Override
    public void onBackPressed() {
        // Remove expendable fragments
        if (mFragmentManager.getBackStackEntryCount() > 1) {
            popExpendableBackStack();
        } else {
            // Consider presenting a dialog to the User, prompting them to exit the app or stay.
            createInformationalDialog(
                    getString(R.string.exit_app),
                    true,
                    (dialog, which) -> finishAffinity(),
                    (dialog, which) -> dialog.dismiss());
        }
    }
}