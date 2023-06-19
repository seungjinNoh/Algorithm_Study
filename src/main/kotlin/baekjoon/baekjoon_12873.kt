package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val list = (1..n).toMutableList()
    var level = 1

    /**
     * list.size: 사람의 수
     * last: 마지막 번호
     */
    while (list.size != 1) {
        var last = level * level * level
        var result = 0
        var index = 0
        if (list.size >= last) {
            index = last - 1
            result = list[index]
        } else {
            index = if (last % list.size == 0) list.size - 1
            else (last % list.size) - 1
            result = list[index]
        }
        list.remove(result)
        for (i in 0 until index) {
            val first = list.first()
            list.remove(first)
            list.add(first)
        }
        level++
    }
    println(list.first())
}