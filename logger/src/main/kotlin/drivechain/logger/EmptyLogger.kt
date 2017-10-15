package drivechain.logger

/**
 * An no-op logger that can be used for testing, delegation or production
 * log filtering.
 */
class EmptyLogger: Logger {
    override fun debug(message: String, vararg args: Any) = Unit
    override fun debug(cause: Throwable, message: String, vararg args: Any) = Unit
    override fun error(message: String, vararg args: Any) = Unit
    override fun error(cause: Throwable, message: String, vararg args: Any) = Unit
    override fun info(message: String, vararg args: Any) = Unit
    override fun info(cause: Throwable, message: String, vararg args: Any) = Unit
    override fun trace(message: String, vararg args: Any) = Unit
    override fun trace(cause: Throwable, message: String, vararg args: Any) = Unit
    override fun warn(message: String, vararg args: Any) = Unit
    override fun warn(cause: Throwable, message: String, vararg args: Any) = Unit
}