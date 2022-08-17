package com.pengxr.modular.eventbus.compiler.utils

import javax.annotation.processing.Messager
import javax.tools.Diagnostic

/**
 * Simplify the message print.
 * <p>
 * Created by pengxr on 10/8/2022
 */
class Logger(private var msg: Messager) {

    /**
     * Print info log.
     */
    fun info(info: CharSequence?) {
        if (!info.isNullOrEmpty()) {
            msg.printMessage(Diagnostic.Kind.NOTE, PREFIX_OF_LOGGER + info)
        }
    }

    fun error(error: CharSequence?) {
        if (!error.isNullOrEmpty()) {
            msg.printMessage(Diagnostic.Kind.ERROR, PREFIX_OF_LOGGER.toString() + "An exception is encountered, [" + error + "]")
        }
    }

    fun error(error: Throwable?) {
        if (null != error) {
            msg.printMessage(
                Diagnostic.Kind.ERROR,
                PREFIX_OF_LOGGER.toString() + "An exception is encountered, [" + error.message + "]" + "\n" + formatStackTrace(error.stackTrace)
            )
        }
    }

    fun warning(warning: CharSequence?) {
        if (!warning.isNullOrEmpty()) {
            msg.printMessage(Diagnostic.Kind.WARNING, PREFIX_OF_LOGGER + warning)
        }
    }

    private fun formatStackTrace(stackTrace: Array<StackTraceElement>): String {
        val sb = StringBuilder()
        for (element in stackTrace) {
            sb.append("    at ").append(element.toString())
            sb.append("\n")
        }
        return sb.toString()
    }
}