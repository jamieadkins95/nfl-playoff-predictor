package com.jamieadkins.nfl.predictor

import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class CrashlyticsTree : Timber.DebugTree() {

    override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        if (BuildConfig.DEBUG)
            super.log(priority, tag, message, throwable)
        throwable?.let {
            FirebaseCrashlytics.getInstance().log(message)
            FirebaseCrashlytics.getInstance().recordException(it)
        }
    }
}
