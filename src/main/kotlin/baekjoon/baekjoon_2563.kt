package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val graph = Array(100) { BooleanArray(100) { false } }
    var count = 0

    repeat(readLine().toInt()) {
        val (i, j) = readLine().split(" ").map { it.toInt() }
        for (i in i until i + 10) {
            for (j in j until j + 10) {
                if (!graph[i][j]) {
                    graph[i][j] = true
                    count++
                }

            }
        }
    }
    println(count)

}