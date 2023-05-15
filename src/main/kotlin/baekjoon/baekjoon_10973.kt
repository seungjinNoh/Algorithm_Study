package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.toIntArray()

    list.apply {
        for (i in this.size - 2 downTo 0) {
            var min = Int.MAX_VALUE
            var minIdx = 0

            for (j in i + 1 until this.size) {
                if (this[i] < this[j]) {
                    if (min > this[j]) {
                        min = this[j]
                        minIdx = j
                    }
                }
            }
            if (min != Int.MAX_VALUE) {
                this[i] = this[minIdx].also { this[minIdx] = this[i] }
                this.sort(i + 1, this.size)
                println(this.joinToString(" "))
                return@with
            }
        }
    }
    println("-1")
}
