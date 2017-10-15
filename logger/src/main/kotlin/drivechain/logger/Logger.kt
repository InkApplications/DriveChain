package drivechain.logger

interface Logger {
    fun debug(message: String, vararg args: Any = emptyArray())
    fun debug(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any = emptyArray())

    fun error(message: String, vararg args: Any = emptyArray())
    fun error(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any = emptyArray())

    fun info(message: String, vararg args: Any = emptyArray())
    fun info(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any = emptyArray())

    fun trace(message: String, vararg args: Any = emptyArray())
    fun trace(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any = emptyArray())

    fun warn(message: String, vararg args: Any = emptyArray())
    fun warn(cause: Throwable, message: String = cause.message.orEmpty(), vararg args: Any = emptyArray())
}