package com.mendix.nativetemplate;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import com.mendix.mendixnative.activity.MendixReactActivity;
import com.mendix.mendixnative.config.AppUrl;
import com.mendix.mendixnative.react.MendixApp;
import com.mendix.mendixnative.react.MxConfiguration;

public class MainActivity extends MendixReactActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.getLifecycle().addObserver(new MendixActivityObserver(this));
        Boolean hasDeveloperSupport = ((MainApplication) getApplication()).getUseDeveloperSupport();
        mendixApp = new MendixApp(AppUrl.getUrlFromResource(this), MxConfiguration.WarningsFilter.none, hasDeveloperSupport, false);
        super.onCreate(savedInstanceState);
        AppCenter.start(getApplication(), "50127c96-8baa-4789-915d-3b570aed921f",
                  Analytics.class, Crashes.class);
    }
}
