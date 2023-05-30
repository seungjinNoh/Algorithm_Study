package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

var graph: Array<IntArray> = arrayOf()
var visited: Array<BooleanArray> = arrayOf()
var isJump = false

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    graph = Array(n + 1) { IntArray(n + 1) { 0 } }
    visited = Array(n + 1) { BooleanArray(n + 1) { false } }

    for (i in 1..n) {
        val numberList = readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            graph[i][j] = numberList[j - 1]
        }
    }

    dfs(1, 1, n)
    println(if (isJump) "HaruHaru" else "Hing")
}

fun dfs(x: Int, y: Int, n: Int) {
    visited[x][y] = true

    if (x == n && y == n) {
        isJump = true
        return
    }

    val moveX = x + graph[x][y]
    val moveY = y + graph[x][y]

    if (moveX in 1..n && !visited[moveX][y]) {
        dfs(moveX, y, n)
    }

    if (moveY in 1..n && !visited[x][moveY]) {
        dfs(x, moveY, n)
    }
}