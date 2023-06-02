package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader


var graph: Array<CharArray> = arrayOf()
var visited: Array<BooleanArray> = arrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (row, col) = readLine().split(" ").map { it.toInt() }

    graph = Array(row + 1) { CharArray(col + 1) {' '} }
    visited = Array(row + 1){ BooleanArray(col + 1) { false } }

    for (i in 1..row) {
        readLine().forEachIndexed { index, c ->
            graph[i][index + 1] = c
        }
    }

    var count = 0
    var num = 0

    //가로 찾기
    for (i in 1..row) {
        for (j in 1..col) {
            if (graph[i][j] == '-') {
                if (count == 0) {
                    count = 1
                    num++
                }
            } else {
                count = 0
            }
        }
        count = 0
    }

    //세로 찾기
    for (i in 1..col) {
        for (j in 1..row) {
            if (graph[j][i] == '|') {
                if (count == 0) {
                    count = 1
                    num++
                }
            } else {
                count = 0
            }
        }
        count = 0
    }

    println(num)
}