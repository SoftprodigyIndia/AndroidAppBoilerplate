# SampleApp
# Android Project Structure

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


This a Sample Project Structure for Android which you can follow for a clean architecture.

It shows usage of following libraries:

* [Retrofit2] (https://square.github.io/retrofit/) for REST API.

* [RX java] (https://github.com/ReactiveX/RxJava) for background process and Retrofit integration.

* [Dagger2] (https://google.github.io/dagger/) for dependency injection.

* [Firebase] (https://firebase.google.com/) for push notifications.

* [Calligraphy] (https://github.com/chrisjenx/Calligraphy) for font.

* [Picasso] (http://square.github.io/picasso/) for image loading.

* [Komensky] (https://github.com/inmite/android-validation-komensky) validations for annotation based validations.

* [Fabric] (https://get.fabric.io/#) for crashlytics.

* [Butterknife] (http://jakewharton.github.io/butterknife/) for view binding.

* [Timber] (https://github.com/JakeWharton/timber) for logging.

It uses MVP (Model View Presenter) pattern. MVP is a derivative from the well known MVC (Model View Controller), which for a while now is gaining importance in the development of Android applications.This project also contains basic utility classes required for day to day programming.


# Here is what the app gradle look likes.

    buildscript {
    repositories {
        maven { url 'https://maven.fabric.io/public' }
    }

    dependencies {
        classpath 'io.fabric.tools:gradle:1.+'
    }
    }
    apply plugin: 'com.android.application'
    apply plugin: 'io.fabric'
    apply plugin: 'com.neenbedankt.android-apt'
    apply plugin: 'me.tatarka.retrolambda'

    android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    //app versioning
    def versionMajor = 1
    def versionMinor = 0
    def versionPatch = 0
    def versionBuild = 0

    defaultConfig {
        applicationId "com.sampleapp"
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode versionMajor * 10000 + versionMinor * 1000 + versionPatch * 100 + versionBuild
        versionName "${versionMajor}.${versionMinor}.${versionPatch}"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    }

    repositories {
    maven {
        url "https://jitpack.io"
    }
    maven { url 'https://maven.fabric.io/public' }
    }

    dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support:design:$rootProject.supportLibraryVersion"
    apt "com.google.dagger:dagger-compiler:$rootProject.daggerVersion"
    provided "org.glassfish:javax.annotation:$rootProject.ext.annotationVersion"
    compile "com.google.dagger:dagger:$rootProject.daggerVersion"
    compile "com.squareup.retrofit2:retrofit:$rootProject.ext.retrofitVersion"
    compile "com.squareup.retrofit2:converter-gson:$rootProject.ext.retrofitVersion"
    compile "com.squareup.retrofit2:adapter-rxjava:$rootProject.ext.retrofitVersion"
    compile "com.squareup.okhttp3:logging-interceptor:$rootProject.ext.loggerVersion"
    compile "io.reactivex:rxjava:$rootProject.ext.rxJavaVersion"
    compile "io.reactivex:rxandroid:$rootProject.ext.rxAndroidVersion"
    compile "com.jakewharton:butterknife:$rootProject.ext.butterknifeVersion"
    apt "com.jakewharton:butterknife-compiler:$rootProject.ext.butterknifeVersion"
    compile "com.jakewharton.timber:timber:$rootProject.ext.timberVersion"
    compile "com.google.android.gms:play-services-location:$rootProject.ext.playServiceVersion"
    compile "com.google.firebase:firebase-messaging:$rootProject.ext.playServiceVersion"
    compile "com.google.android.gms:play-services-maps:$rootProject.ext.playServiceVersion"
    compile "uk.co.chrisjenx:calligraphy:$rootProject.ext.calligraphyVersion"
    compile "com.squareup.picasso:picasso:$rootProject.ext.picassoVersion"
    compile "eu.inmite.android.lib:android-validation-komensky:$rootProject.ext.komenskyValidation@aar"
    compile("com.crashlytics.sdk.android:crashlytics:$rootProject.ext.crashVersion@aar") {
        transitive = true;
    }

    }
    apply plugin: 'com.google.gms.google-services'

#Start from

minSdkVersion 16

#LICENSE

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

#Author

Soft Prodigy System Solutions Pvt. Ltd.
Trust | Integrity | Customer Delight | Timely Delivery | Quality
Visit us at: www.softprodigy.com
