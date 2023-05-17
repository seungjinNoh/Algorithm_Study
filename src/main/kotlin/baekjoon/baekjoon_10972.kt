package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.toIntArray()

    list.apply {
        for (i in this.size - 2 downTo 0) {
            var max = 0
            var maxIdx = 0

            for (j in i + 1 until this.size) {
                if (this[i] > this[j]) {
                    if (max < this[j]) {
                        max = this[j]
                        maxIdx = j
                    }
                }
            }
            if (max != 0) {
                this[i] = this[maxIdx].also { this[maxIdx] = this[i] }
                this.sortDescending(i + 1, this.size)
                println(this.joinToString(" "))
                return@with
            }
        }
    }
    println("-1")
}
