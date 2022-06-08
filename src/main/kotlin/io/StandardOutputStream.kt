package io

import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.io.StringReader

class StandardOutputStream : PrintStream(ByteArrayOutputStream()) {

    private var br = BufferedReader(StringReader(""))

    fun readLine(): String {
        br = BufferedReader(StringReader(out.toString()))
        (out as ByteArrayOutputStream).reset()
        return br.readLine()
    }

    fun readLines(): List<String> {
        val lines = mutableListOf<String>()
        br = BufferedReader(StringReader(out.toString()))
        (out as ByteArrayOutputStream).reset()
        do {
            val result = br.readLine()
            if (result != null) {
                lines.add(result)
            }
        } while (result != null)
        return lines
    }
}