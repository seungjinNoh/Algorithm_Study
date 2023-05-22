package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

var visited: Array<BooleanArray> = arrayOf()
val dx = intArrayOf(-2, -2, 0, 0, 2, 2)
val dy = intArrayOf(-1, 1, -2, 2, -1, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    visited = Array(n) { BooleanArray(n) { false } }

    val(r1, c1, r2, c2) = readLine().split(" ").map { it.toInt() }

    println(bfs(r1, c1, r2, c2, n))

}

fun bfs(r1: Int, c1: Int, r2: Int, c2: Int, n: Int): Int {
    val list = LinkedList<Triple<Int, Int, Int>>()
    list.offer(Triple(r1, c1, 0))
    visited[r1][c1] = true

    while (list.isNotEmpty()) {
        val node = list.remove()
        if (node.first == r2 && node.second == c2) {
            return node.third
        }
        for (i in 0 until 6) {
            val moveX = dx[i] + node.first
            val moveY = dy[i] + node.second

            if (moveX !in 0 until n || moveY !in 0 until n) continue
            if (!visited[moveX][moveY]) {
                visited[moveX][moveY] = true
                list.offer(Triple(moveX, moveY, node.third + 1))
            }
        }
    }

    return -1
}