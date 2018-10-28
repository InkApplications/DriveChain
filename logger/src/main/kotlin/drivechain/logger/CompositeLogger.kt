package drivechain.logger

/**
 * Composite class to invoke logger methods on a collection of loggers all at once.
 */
class CompositeLogger(private val loggers: Collection<Logger>): Logger {
    override fun debugTag(tag: String?, message: String, vararg args: Any?) = loggers.forEach { it.debugTag(tag, message, *args) }
    override fun debug(message: String, vararg args: Any?) = loggers.forEach { it.debug(message, *args) }
    override fun debugTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.debugTag(tag, cause, message, *args) }
    override fun debug(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.debug(cause, message, *args) }

    override fun errorTag(tag: String?, message: String, vararg args: Any?) = loggers.forEach { it.errorTag(tag, message, *args) }
    override fun error(message: String, vararg args: Any?) = loggers.forEach { it.error(message, *args) }
    override fun errorTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.errorTag(tag, cause, message, *args) }
    override fun error(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.error(cause, message, *args) }

    override fun infoTag(tag: String?, message: String, vararg args: Any?) = loggers.forEach { it.infoTag(tag, message, *args) }
    override fun info(message: String, vararg args: Any?) = loggers.forEach { it.info(message, *args) }
    override fun infoTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.infoTag(tag, cause, message, *args) }
    override fun info(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.info(cause, message, *args) }

    override fun traceTag(tag: String?, message: String, vararg args: Any?) = loggers.forEach { it.traceTag(tag,message, *args) }
    override fun trace(message: String, vararg args: Any?) = loggers.forEach { it.trace(message, *args) }
    override fun traceTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.traceTag(tag, cause, message, *args) }
    override fun trace(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.trace(cause, message, *args) }

    override fun warnTag(tag: String?, message: String, vararg args: Any?) = loggers.forEach { it.warnTag(tag, message, *args) }
    override fun warn(message: String, vararg args: Any?) = loggers.forEach { it.warn(message, *args) }
    override fun warnTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.warnTag(tag, cause, message, *args) }
    override fun warn(cause: Throwable, message: String, vararg args: Any?) = loggers.forEach { it.warn(cause, message, *args) }
}
