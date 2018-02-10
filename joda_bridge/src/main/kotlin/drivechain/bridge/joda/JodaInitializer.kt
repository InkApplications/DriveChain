package drivechain.bridge.joda

import android.app.Application
import drivechain.lifecycle.application.Initializer
import net.danlew.android.joda.JodaTimeAndroid

class JodaInitializer: Initializer() {
    override fun onCreate(application: Application) {
        JodaTimeAndroid.init(application)
    }
}