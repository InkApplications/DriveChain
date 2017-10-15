package drivechain.bridge.stetho

import android.app.Application
import com.facebook.stetho.Stetho
import drivechain.lifecycle.application.Initializer

/**
 * Initializes Stetho when the application Starts.
 */
class StethoInitializer: Initializer() {
    override fun onCreate(application: Application) {
        Stetho.initializeWithDefaults(application)
    }
}