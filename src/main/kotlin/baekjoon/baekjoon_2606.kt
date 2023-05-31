package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

var graph: Array<IntArray> = arrayOf()
var visited: BooleanArray = booleanArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    graph = Array(n + 1) { IntArray(n + 1) { 0 } }
    visited = BooleanArray(n + 1) { false }

    repeat(readLine().toInt()) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        graph[x][y] = 1
        graph[y][x] = 1
    }

    dfs(1, n)

    println( visited.count { it } - 1)
}

fun dfs(start: Int, n: Int) {
    visited[start] = true

    for (i in 1..n) {
        if (!visited[i] && graph[start][i] == 1) {
            dfs(i, n)
        }
    }
}