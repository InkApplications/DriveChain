package drivechain.logger

enum class LogLevel(val severity: Int) {
    TRACE(100),
    DEBUG(200),
    INFO(300),
    WARN(400),
    ERROR(500)
}
