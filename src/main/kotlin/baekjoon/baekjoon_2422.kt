package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }

    val visited = Array(n + 1) { BooleanArray(n + 1) { false } }
    var count = 0


    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        visited[x][y] = true
        visited[y][x] = true
    }

    for (i in 1..n) {
        for (j in i + 1.. n) {
            for (k in j + 1..n) {
                if (visited[i][j] || visited[j][k] || visited[i][k]) continue
                count++
            }
        }
    }
    println(count)

}