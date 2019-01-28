package drivechain.logger

import android.util.Log
import drivechain.logger.LogLevel.*
import java.util.regex.Pattern

private const val MAX_TAG_LENGTH = 23
private const val CALL_STACK_INDEX = 2
private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")

/**
 * Log messages to the Android Console.
 *
 * @param name A name to log as a tag when logging. If none is provided,
 *        this will attempt to use the class name of the source of the
 *        log. (optional)
 * @param logLevel The minimum severity of the log message to write to the
 *        console. This is useful for disabling verbose logging in releases.
 * @param loggerOffset The number of classes to traverse upwards when getting
 *        the name of the class that logged the message. This is used when
 *        nesting loggers together, so that the source of the log can be
 *        correctly identified. By default it is set to 1, and should be
 *        changed to 2 if using this in a `CompositeLogger` (optional)
 */
class ConsoleLogger(
    private val name: String? = null,
    private val logLevel: LogLevel = LogLevel.TRACE,
    private val loggerOffset: Int = 1
): Logger {
    override fun log(level: LogLevel, message: String, vararg args: Any?, tag: String?) {
        if (level.severity < logLevel.severity) return
        when (level) {
            TRACE -> Log.v(tag ?: classTag, message.format(*args))
            DEBUG -> Log.d(tag ?: classTag, message.format(*args))
            INFO -> Log.i(tag ?: classTag, message.format(*args))
            WARN -> Log.w(tag ?: classTag, message.format(*args))
            ERROR -> Log.e(tag ?: classTag, message.format(*args))
        }
    }

    override fun log(level: LogLevel, cause: Throwable, message: String, vararg args: Any?, tag: String?) {
        if (level.severity < logLevel.severity) return

        when (level) {
            TRACE -> Log.v(tag ?: classTag, message.format(*args), cause)
            DEBUG -> Log.d(tag ?: classTag, message.format(*args), cause)
            INFO -> Log.i(tag ?: classTag, message.format(*args), cause)
            WARN -> Log.w(tag ?: classTag, message.format(*args), cause)
            ERROR -> Log.e(tag ?: classTag, message.format(*args), cause)
        }
    }

    /*
        The Following code is from Jake Wharton's Timber library,
        sources received from: https://github.com/JakeWharton/timber
        Copyright Jake Wharton and licensed under:
        Apache License
        Version 2.0, January 2004
        http://www.apache.org/licenses/
        Modifications include:
            - Change getTag first return condition to return tag name of local class context
            - Converted to Kotlin
            - Change element index to skip default interface implementations
    */

    /**
     * Extract the tag which should be used for the message from the `element`. By default
     * this will use the class name without any anonymous class suffixes (e.g., `Foo$1`
     * becomes `Foo`).
     *
     * Note: This will not be called if a [manual tag][.tag] was specified.
     */
    private fun createStackElementTag(element: StackTraceElement): String {
        var tag = element.className
        val m = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1)
        return if (tag.length > MAX_TAG_LENGTH) tag.substring(0, MAX_TAG_LENGTH) else tag
    }

    // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
    // because Robolectric runs them on the JVM but on Android the elements are different.
    private val classTag: String get() {
        if (null != this.name) {
            return this.name
        }
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size <= CALL_STACK_INDEX) {
            throw IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?")
        }

        val element = if (stackTrace[CALL_STACK_INDEX + loggerOffset].className.contains(Regex("\\\$DefaultImpls\$"))) stackTrace[CALL_STACK_INDEX + loggerOffset + 3]
            else  stackTrace[CALL_STACK_INDEX + loggerOffset]

        return createStackElementTag(element)
    }

    /* End of Timber Code */
}
