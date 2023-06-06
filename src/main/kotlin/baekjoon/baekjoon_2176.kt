package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (row, col) = readLine().split(" ").map { it.toInt() }
    val graph = Array(row) { IntArray(col) { 0 } }

    for (i in 0 until row) {
        readLine().split(" ").mapIndexed { index, s ->
            graph[i][index] = s.toInt()
        }
    }

    repeat(readLine().toInt()) {
        val (i, j, x, y) = readLine().split(" ").map { it.toInt() }
        var result = 0
        for (a in i -1 until x) {
            for (b in j - 1 until y) {
                result += graph[a][b]
            }
        }
        println(result)
    }
}