package drivechain.logger

/**
 * Logger that does not use the tagging feature.
 *
 * This will drop the tag if specified to the logger and proxy
 * the untagged method instead.
 */
abstract class TaglessLogger: Logger {
    final override fun debugTag(tag: String?, message: String, vararg args: Any?) = debug(message, *args)
    final override fun debugTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = debug(cause, message, *args)
    final override fun errorTag(tag: String?, message: String, vararg args: Any?) = error(message, *args)
    final override fun errorTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = error(cause, message, *args)
    final override fun infoTag(tag: String?, message: String, vararg args: Any?) = info(message, *args)
    final override fun infoTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = info(cause, message, *args)
    final override fun traceTag(tag: String?, message: String, vararg args: Any?) = trace(message, *args)
    final override fun traceTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = trace(cause, message, *args)
    final override fun warnTag(tag: String?, message: String, vararg args: Any?) = warn(message, *args)
    final override fun warnTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) = warn(cause, message, *args)
}
