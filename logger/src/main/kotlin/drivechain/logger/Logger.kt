package drivechain.logger

interface Logger {
    fun debugTag(tag: String?, message: String, vararg args: Any? = emptyArray())
    fun debug(message: String, vararg args: Any? = emptyArray())

    fun debugTag(tag: String?, cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())
    fun debug(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())

    fun errorTag(tag: String?, message: String, vararg args: Any? = emptyArray())
    fun error(message: String, vararg args: Any? = emptyArray())

    fun errorTag(tag: String?, cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())
    fun error(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())

    fun infoTag(tag: String?, message: String, vararg args: Any? = emptyArray())
    fun info(message: String, vararg args: Any? = emptyArray())

    fun infoTag(tag: String?, cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())
    fun info(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())

    fun traceTag(tag: String?, message: String, vararg args: Any? = emptyArray())
    fun trace(message: String, vararg args: Any? = emptyArray())

    fun traceTag(tag: String?, cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())
    fun trace(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())

    fun warnTag(tag: String?, message: String, vararg args: Any? = emptyArray())
    fun warn(message: String, vararg args: Any? = emptyArray())

    fun warnTag(tag: String?, cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())
    fun warn(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray())
}
