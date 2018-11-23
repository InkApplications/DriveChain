package drivechain.logger

interface Logger {
    fun log(level: LogLevel, message: String, vararg args: Any? = emptyArray(), tag: String? = null)
    fun log(level: LogLevel, cause: Throwable, message: String, vararg args: Any? = emptyArray(), tag: String? = null)

    fun trace(message: String, vararg args: Any? = emptyArray()) = log(LogLevel.TRACE, message, *args)
    fun trace(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray()) = log(LogLevel.TRACE, cause, message, *args)

    fun debug(message: String, vararg args: Any? = emptyArray()) = log(LogLevel.DEBUG, message, *args)
    fun debug(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray()) =  log(LogLevel.DEBUG, cause, message, *args)

    fun info(message: String, vararg args: Any? = emptyArray()) = log(LogLevel.INFO, message, *args)
    fun info(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray()) = log(LogLevel.INFO, message, *args)

    fun warn(message: String, vararg args: Any? = emptyArray()) = log(LogLevel.WARN, message, *args)
    fun warn(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray()) = log(LogLevel.WARN, cause, message, *args)

    fun error(message: String, vararg args: Any? = emptyArray()) = log(LogLevel.ERROR, message, *args)
    fun error(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any? = emptyArray()) = log(LogLevel.ERROR, message, *args)
}

