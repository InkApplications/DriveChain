package drivechain.bridge.threeten

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import drivechain.lifecycle.application.Initializer

object ThreeTenInitializer: Initializer() {
    override fun onCreate(application: Application) {
        AndroidThreeTen.init(application)
    }
}
