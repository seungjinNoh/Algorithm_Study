package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val graph = Array(n) { mutableListOf<Int>() }
    var maxCount = 0

    repeat(n) {
        readLine().forEachIndexed { index, c ->
            if (c == 'Y' && n != index) {
                graph[it].add(index)
            }
        }
    }

    for (i in 0 until n) {
        var count = 0
        val visited = BooleanArray(n) { false }
        graph[i].forEachIndexed { index, j ->
            visited[j] = true
            graph[j].forEachIndexed { index2, k ->
                visited[k] = true
            }
        }
        visited[i] = false
        count = visited.count { it }
        maxCount = max(maxCount, count)
    }

    println(maxCount)
}