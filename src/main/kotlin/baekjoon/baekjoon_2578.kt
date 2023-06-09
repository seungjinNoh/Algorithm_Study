package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var graph = arrayOf(intArrayOf())
val queue = LinkedList<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    graph = Array(5) { IntArray(5) { 0 } }

    repeat(5) { row ->
        readLine().split(" ").mapIndexed { index, s ->
            graph[row][index] = s.toInt()
        }
    }

    repeat(5) {
        readLine().split(" ").map {
            queue.add(it.toInt())
        }
    }

    repeat(25) {
        val number = queue.poll()
        findNumber(number)

        val rowCount = checkRow()
        val colCount = checkCol()
        val crossCount = checkCross()

        if (rowCount + colCount + crossCount >= 3) {
            println(it + 1)
            return@with
        }

    }

}

fun findNumber(number: Int) {
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (graph[i][j] == number) {
                graph[i][j] = 0
                return
            }
        }
    }
}

fun checkRow(): Int {
    var count = 0
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (graph[i][j] != 0) break
            if (j == 4) count++
        }
    }
    return count
}

fun checkCol(): Int {
    var count = 0
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (graph[j][i] != 0) break
            if (j == 4) count++
        }
    }
    return count
}

fun checkCross(): Int {
    var count = 0
    for (i in 0 until 5) {
        if (graph[i][i] != 0) break
        if (i == 4) count++
    }

    for (i in 0 until 5) {
        if (graph[i][4 - i] != 0) break
        if (i == 4) count++
    }
    return count
}