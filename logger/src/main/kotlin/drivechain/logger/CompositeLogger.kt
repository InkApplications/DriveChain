package drivechain.logger

/**
 * Composite class to invoke logger methods on a collection of loggers all at once.
 */
class CompositeLogger(private val loggers: Collection<Logger>): Logger {
    override fun log(level: LogLevel, message: String, vararg args: Any?, tag: String?) = loggers.forEach {
        it.log(level, message, *args, tag = tag)
    }

    override fun log(level: LogLevel, cause: Throwable, message: String, vararg args: Any?, tag: String?) = loggers.forEach {
        it.log(level, cause, message, *args, tag = tag)
    }
}
