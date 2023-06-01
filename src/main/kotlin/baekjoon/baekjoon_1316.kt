package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var count = 0
    repeat(readLine().toInt()) {
        if (isOk(readLine())) count++
    }

    println(count)

}

fun isOk(str: String): Boolean {
    val set = mutableSetOf<Char>()
    var lastChar: Char? = null

    str.forEachIndexed { index, c ->
        if (index == 0) {
            lastChar = c
            set.add(c)
        } else {
            if (lastChar!! != c) {
                if (set.contains(c)) return false
                else {
                    lastChar = c
                    set.add(c)
                }
            }
        }
    }
    return true
}