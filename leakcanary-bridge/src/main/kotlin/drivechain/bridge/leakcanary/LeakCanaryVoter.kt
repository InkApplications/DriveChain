package drivechain.bridge.leakcanary

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import drivechain.lifecycle.application.LifecycleVoter

/**
 * Prevent DriveChain lifecycle callbacks from running in LeakCanary Process.
 */
class LeakCanaryVoter: LifecycleVoter {
    override fun onCreate(application: Application) = !LeakCanary.isInAnalyzerProcess(application)
    override fun onLowMemory(application: Application) = !LeakCanary.isInAnalyzerProcess(application)
    override fun onTrimMemory(application: Application, level: Int) = !LeakCanary.isInAnalyzerProcess(application)
    override fun onTerminate(application: Application) = !LeakCanary.isInAnalyzerProcess(application)
}
