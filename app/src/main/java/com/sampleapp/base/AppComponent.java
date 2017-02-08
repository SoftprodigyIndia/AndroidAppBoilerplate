package com.sampleapp.base;

import com.sampleapp.utils.LocationTracker;
import com.sampleapp.utils.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component for Application class {@link SampleApplication}
 */

@Singleton
@Component(modules = {UtilsModule.class})
public interface AppComponent {
    void inject(LocationTracker locationTracker);
}
