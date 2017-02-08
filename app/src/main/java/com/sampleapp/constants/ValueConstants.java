package com.sampleapp.constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * contains constant values to be used in application
 */
public interface ValueConstants {

    int REQUEST_CAMERA = 1001;
    int REQUEST_Gallery = 1002;
    int REQUEST_LOCATION = 1003;
    String NEW_THREAD = "newThread";
    String MAIN_THREAD = "mainThread";

    // type check for error during login
    @IntDef({ValidationType.VALID, ValidationType.USER_NAME_INVALID, ValidationType.PASSWORD_INVALID})
    @Retention(RetentionPolicy.SOURCE)
    @interface ValidationType {
        int VALID = 0, USER_NAME_INVALID = 1, PASSWORD_INVALID = 2;
    }

    // type of dialog opened
    @IntDef({DialogType.DIALOG_DENY, DialogType.DIALOG_NEVER_ASK})
    @Retention(RetentionPolicy.SOURCE)
    @interface DialogType {
        int DIALOG_DENY = 0, DIALOG_NEVER_ASK = 1;
    }
}
