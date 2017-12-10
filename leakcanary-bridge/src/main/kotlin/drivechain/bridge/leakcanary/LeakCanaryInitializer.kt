package drivechain.bridge.leakcanary

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import drivechain.lifecycle.application.Initializer

/**
 * Initialize LeakCanary on Application startup.
 */
class LeakCanaryInitializer: Initializer() {
    override fun onCreate(application: Application) {
        LeakCanary.install(application)
    }
}
