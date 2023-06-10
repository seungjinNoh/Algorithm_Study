package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

var visited = booleanArrayOf()
val resultList = mutableListOf<String>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }

    var totalNumString = ""
    for (i in n downTo 1) {
        totalNumString += i.toString()
    }

    visited = BooleanArray(totalNumString.toInt() + 1) { false }

    dfs(0, "", n, m)

    resultList.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}

fun dfs(depth: Int, str: String, n: Int, m: Int) {
    if (depth == m) {
        if (!visited[str.toInt()]) {
            visited[str.toInt()] = true
            resultList.add(str)
        }
        return
    }

    for (i in 1..n) {
        if (str.contains(i.toString())) continue
        dfs(depth + 1, str + i.toString(), n, m)
    }
}