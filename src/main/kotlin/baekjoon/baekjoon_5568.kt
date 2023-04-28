package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

var graph = mutableListOf<String>()
var visited = booleanArrayOf()
val resultList = arrayListOf<Int>()
var n = 0
var k = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    k = readLine().toInt()
    visited = BooleanArray(100) { false }


    repeat(n) {
        graph.add(readLine())
    }

    dfs(0, "")

    println(resultList.distinct().size)

}

fun dfs(depth: Int, result: String) {
    if (depth == k) {
        resultList.add(result.toInt())
        return
    }
    for (i in 0 until n) {
        if (visited[i]) continue
        visited[i] = true
        dfs(depth + 1, result + graph[i])
        visited[i] = false
    }
}


