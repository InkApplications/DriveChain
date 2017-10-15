package drivechain.appconfig

data class AppConfig(
    val debug: Boolean,
    val appId: String,
    val versionCode: Int,
    val versionName: String,
    val buildType: String,
    val buildFlavor: String,
    val metaData: Map<String, String> = emptyMap()
)