package drivechain.logger

import android.util.Log
import java.util.regex.Pattern

private const val MAX_TAG_LENGTH = 23
private const val CALL_STACK_INDEX = 2
private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")

class ConsoleLogger(
    private val name: String? = null,
    private val loggerOffset: Int = 2
): Logger {
    override fun debug(message: String, vararg args: Any?) { Log.d(this.tag, String.format(message, *args)) }
    override fun debug(cause: Throwable, message: String, vararg args: Any?) { Log.d(this.tag, String.format(message, *args), cause) }

    override fun error(message: String, vararg args: Any?) { Log.e(this.tag, String.format(message, *args)) }
    override fun error(cause: Throwable, message: String, vararg args: Any?) { Log.e(this.tag, String.format(message, *args), cause) }

    override fun info(message: String, vararg args: Any?) { Log.i(this.tag, String.format(message, *args)) }
    override fun info(cause: Throwable, message: String, vararg args: Any?) { Log.i(this.tag, String.format(message, *args), cause) }

    override fun trace(message: String, vararg args: Any?) { Log.v(this.tag, String.format(message, *args)) }
    override fun trace(cause: Throwable, message: String, vararg args: Any?) { Log.v(this.tag, String.format(message, *args), cause) }

    override fun warn(message: String, vararg args: Any?) { Log.w(this.tag, String.format(message, *args)) }
    override fun warn(cause: Throwable, message: String, vararg args: Any?) { Log.w(this.tag, String.format(message, *args), cause) }

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
    private val tag: String get() {
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
