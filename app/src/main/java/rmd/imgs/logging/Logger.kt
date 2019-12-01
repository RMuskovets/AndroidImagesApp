package rmd.imgs.logging

import java.util.*

class Logger(
    private val level: LoggerLevel = LoggerLevel.WARNING,
    private val output: LoggerOutput = StdoutOutput()
) {

    fun debug(msg: Any) {
        if (level.ordinal == 0)
            output.println("[DEBUG] [" + Date() + "]: " + msg)
    }

    fun info(msg: Any) {
        if (level.ordinal <= 1)
            output.println("[INFO] [" + Date() + "]: " + msg)
    }

    fun warn(msg: Any) {
        if (level.ordinal <= 2)
            output.println("[WARNING] [" + Date() + "]: " + msg)
    }

    fun error(msg: Any) {
        if (level.ordinal <= 3)
            output.println("[ERROR] [" + Date() + "]: " + msg)
    }
}