package com.sampleapp.module.login;

import com.sampleapp.utils.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component class for {@link LoginActivity}
 * indicates the modules that will be used by the component and the activities that will use this component
 */
@Singleton
@Component(modules = {LoginModule.class, UtilsModule.class})
interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
