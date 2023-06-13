package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, grade, p) = readLine().split(" ").map { it.toInt() }

    if (n == 0) {
        println(1)
        return@with
    }

    val arr = readLine().split(" ").map { it.toInt() }

    val rank = arr.count { it > grade} + 1
    val count = arr.count { it >= grade } + 1

    if (count <= p) println(rank)
    else println(-1)

}