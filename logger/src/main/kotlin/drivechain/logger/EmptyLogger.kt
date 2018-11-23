package drivechain.logger

/**
 * An no-op logger that can be used for testing, delegation or production
 * log filtering.
 */
object EmptyLogger: Logger {
    override fun log(level: LogLevel, message: String, vararg args: Any?, tag: String?) = Unit
    override fun log(level: LogLevel, cause: Throwable, message: String, vararg args: Any?, tag: String?) = Unit
}
