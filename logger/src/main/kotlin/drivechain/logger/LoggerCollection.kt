package drivechain.logger

/**
 * Composite class to invoke logger methods on a collection of loggers all at once.
 */
class LoggerCollection(private val loggers: Collection<Logger>): Logger {
    override fun debug(message: String, vararg args: Any?) = loggers.forEach { it.debug(message, *args) }
    override fun debug(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.debug(cause, message, *args) }

    override fun error(message: String, vararg args: Any?) = loggers.forEach { it.error(message, *args) }
    override fun error(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.error(cause, message, *args) }

    override fun info(message: String, vararg args: Any?) = loggers.forEach { it.info(message, *args) }
    override fun info(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.info(cause, message, *args) }

    override fun trace(message: String, vararg args: Any?) = loggers.forEach { it.trace(message, *args) }
    override fun trace(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.trace(cause, message, *args) }

    override fun warn(message: String, vararg args: Any?) = loggers.forEach { it.warn(message, *args) }
    override fun warn(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.warn(cause, message, *args) }
}
