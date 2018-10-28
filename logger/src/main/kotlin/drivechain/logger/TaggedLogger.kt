package drivechain.logger

/**
 * Logger that uses tags while logging.
 *
 * This forwards all calls to untagged logs to the tagged implementation
 * for easier implementation when using a tagged logger. Tag will be null
 * if not specified by the user.
 */
abstract class TaggedLogger: Logger {
    final override fun debug(message: String, vararg args: Any?) = debugTag(null, message, *args)
    final override fun debug(cause: Throwable, message: String, vararg args: Any?) = debugTag(null, cause, message, *args)
    final override fun error(message: String, vararg args: Any?) = errorTag(null, message, *args)
    final override fun error(cause: Throwable, message: String, vararg args: Any?) = errorTag(null, cause, message, *args)
    final override fun info(message: String, vararg args: Any?) = infoTag(null, message, *args)
    final override fun info(cause: Throwable, message: String, vararg args: Any?) = infoTag(null, cause, message, *args)
    final override fun trace(message: String, vararg args: Any?) = traceTag(null, message, *args)
    final override fun trace(cause: Throwable, message: String, vararg args: Any?) = traceTag(null, cause, message, *args)
    final override fun warn(message: String, vararg args: Any?) = warnTag(null, message, *args)
    final override fun warn(cause: Throwable, message: String, vararg args: Any?) = warnTag(null, cause, message, *args)
}
