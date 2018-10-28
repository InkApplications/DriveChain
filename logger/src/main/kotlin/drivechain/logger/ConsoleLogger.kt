package drivechain.logger

import android.util.Log
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
 * @param loggerOffset The number of classes to traverse upwards when getting
 *        the name of the class that logged the message. This is used when
 *        nesting loggers together, so that the source of the log can be
 *        correctly identified. By default it is set to 1, and should be
 *        changed to 2 if using this in a `CompositeLogger` (optional)
 * @param errorEnabled Whether Error Messages should be logged (default: true)
 * @param warnEnabled Whether Warning Messages should be logged (default: true)
 * @param infoEnabled Whether Info Messages should be logged (default: true)
 * @param debugEnabled Whether Debug Messages should be logged (default: true)
 * @param traceEnabled Whether Trace Messages should be logged (default: true)
 */
class ConsoleLogger(
    private val name: String? = null,
    private val loggerOffset: Int = 2,
    private val errorEnabled: Boolean = true,
    private val warnEnabled: Boolean = true,
    private val infoEnabled: Boolean = true,
    private val debugEnabled: Boolean = true,
    private val traceEnabled: Boolean = true
): TaggedLogger() {
    override fun debugTag(tag: String?, message: String, vararg args: Any?) {
        if (!debugEnabled) return
        Log.d(tag ?: classTag, String.format(message, *args))
    }
    override fun debugTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) {
        if (!debugEnabled) return
        Log.d(tag ?: classTag, String.format(message, *args), cause)
    }

    override fun errorTag(tag: String?, message: String, vararg args: Any?) {
        if (!errorEnabled) return
        Log.e(tag ?: classTag, String.format(message, *args))
    }
    override fun errorTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) {
        if (!errorEnabled) return
        Log.e(tag ?: classTag, String.format(message, *args), cause)
    }

    override fun infoTag(tag: String?, message: String, vararg args: Any?) {
        if (!infoEnabled) return
        Log.i(tag ?: classTag, String.format(message, *args))
    }
    override fun infoTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) {
        if (!infoEnabled) return
        Log.i(tag ?: classTag, String.format(message, *args), cause)
    }

    override fun traceTag(tag: String?, message: String, vararg args: Any?) {
        if (!traceEnabled) return
        Log.v(tag ?: classTag, String.format(message, *args))
    }
    override fun traceTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) {
        if (!traceEnabled) return
        Log.v(tag ?: classTag, String.format(message, *args), cause)
    }

    override fun warnTag(tag: String?, message: String, vararg args: Any?) {
        if (!warnEnabled) return
        Log.w(tag ?: classTag, String.format(message, *args))
    }
    override fun warnTag(tag: String?, cause: Throwable, message: String, vararg args: Any?) {
        if (!warnEnabled) return
        Log.w(tag ?: classTag, String.format(message, *args), cause)
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

        return createStackElementTag(stackTrace[CALL_STACK_INDEX + loggerOffset])
    }

    /* End of Timber Code */
}
