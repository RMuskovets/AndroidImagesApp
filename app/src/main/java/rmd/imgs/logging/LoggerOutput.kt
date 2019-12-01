package rmd.imgs.logging

abstract class LoggerOutput {
    abstract fun println(msg: Any)
}

class StdoutOutput: LoggerOutput() {
    override fun println(msg: Any) {
        kotlin.io.println(msg)
    }
}