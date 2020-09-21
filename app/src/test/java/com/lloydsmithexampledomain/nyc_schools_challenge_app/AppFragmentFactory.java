package com.lloydsmithexampledomain.nyc_schools_challenge_app;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchParams;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISearchPresenter;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.fragments.ResultsFragment;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.callbacks.ISearchListener;

import org.junit.Ignore;
import org.mockito.Mockito;

@Ignore
public class AppFragmentFactory<FRAGMENT_TYPE extends Fragment> extends FragmentFactory {

    private ConfigurationInterface<FRAGMENT_TYPE> mConfigurationCallback;
    private ISearchParams mSearchParams;
    private ISearchListener mSearchListener;

    /**
     * Default constructor
     * @param configurationInterface
     */
    public AppFragmentFactory(ConfigurationInterface<FRAGMENT_TYPE> configurationInterface) {
        this.mConfigurationCallback = configurationInterface;
    }

    /**
     * Constructor with the necessary items for creating the following Fragments:
     * <ul>
     *     <li>{@linkplain ResultsFragment}</li>
     * </ul>
     * @param searchParams
     * @param searchListener
     * @param configurationCallback
     */
    public AppFragmentFactory(ISearchParams searchParams, ISearchListener searchListener, ConfigurationInterface<FRAGMENT_TYPE> configurationCallback) {
        this.mSearchParams = searchParams;
        this.mSearchListener = searchListener;
        this.mConfigurationCallback = configurationCallback;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        if (className.equals(ResultsFragment.class.getName())) {
            ResultsFragment fragment = ResultsFragment.newInstance(mSearchParams, mSearchListener);
            if (mConfigurationCallback != null) {
                mConfigurationCallback.onFragmentInitialized((FRAGMENT_TYPE) fragment);
            }
            return fragment;
        }
        Fragment fragment = super.instantiate(classLoader, className);
        if (mConfigurationCallback != null) {
            mConfigurationCallback.onFragmentInitialized((FRAGMENT_TYPE) fragment);
        }
        return fragment;
    }

    public interface ConfigurationInterface<FRAGMENT_TYPE extends Fragment> {
        /**
         * This method is called after instantiating the desired Fragment Object, but before it goes through its lifecycle.
         * Use this callback method to further customize the Fragment's fields for testing.
         * @param fragment Initialized {@linkplain FRAGMENT_TYPE}
         */
        void onFragmentInitialized(FRAGMENT_TYPE fragment);
    }
}
