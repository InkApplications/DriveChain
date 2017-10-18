package drivechain.bridge.fresco

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import drivechain.lifecycle.application.Initializer
import okhttp3.OkHttpClient

class FrescoInitializer(private val okHttpClient: OkHttpClient): Initializer() {
    override fun onCreate(application: Application) {
        OkHttpImagePipelineConfigFactory.newBuilder(application, okHttpClient)
                .build()
                .let {
                    Fresco.initialize(application, it)
                }
    }
}