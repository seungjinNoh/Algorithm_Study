package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

val answer = IntArray(10) { 0 }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    readLine().split(" ").mapIndexed { index, s ->
        answer[index] = s.toInt()
    }

    val arr = IntArray(10) { 0 }
    var count = 0

    fun dfs(depth: Int) {
        if (depth == 10) {
            var rightCount = 0
            arr.forEachIndexed { index, i ->
                if (i == answer[index]) rightCount++
            }
            if (rightCount >= 5) count++
            return
        }
        for (i in 1..5) {

            if (depth > 1) {
                if (arr[depth - 2] == arr[depth - 1] && arr[depth - 1] == i) continue
            }

            arr[depth] = i
            dfs(depth + 1)

        }
    }
    dfs(0)

    println(count)
}