package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()
    val sb = StringBuilder()

    var bitmask = 0

    repeat(m) {
        val input = br.readLine().split(" ")
        val command = input[0]
        val value = if (input.size > 1) input[1].toInt() else -1

        when (command) {
            "add" -> bitmask = bitmask or (1 shl value)
            "remove" -> bitmask = bitmask and (1 shl value).inv()
            "check" -> {
                val result = if ((bitmask and (1 shl value)) != 0) 1 else 0
                sb.append(result).append("\n")
            }
            "toggle" -> bitmask = bitmask xor (1 shl value)
            "all" -> bitmask = (1 shl 21) - 1
            "empty" -> bitmask = 0
        }
    }

    println(sb.toString())
}

