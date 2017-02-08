package com.sampleapp.module.login;

import com.sampleapp.api.NetModule;
import com.sampleapp.utils.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component class for {@link LoginPresenter}
 * indicates the modules that will be used by the component and the class that will use this component
 */
@Singleton
@Component(modules = {NetModule.class, UtilsModule.class})
public interface LoginPresenterComponent {
    void inject(LoginPresenter loginPresenter);
}
