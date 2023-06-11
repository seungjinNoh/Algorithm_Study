package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = IntArray(n) { 0 }

    readLine().split(" ").mapIndexed { index, s ->
        arr[index] = s.toInt()
    }

    if (arr.size == 1) {
        println(1)
        return@with
    }

    var max = 0
    var count = 0
    var lastNumber = 0
    arr.forEachIndexed { index, i ->
       if (index == 0) {
           lastNumber = i
           count++
       }
        else {
            if (i >= lastNumber) {
                count++
            } else {
                count = 1
            }
           lastNumber = i
       }
        if (count > max) {
            max = count
        }
    }

    count = 0

    arr.forEachIndexed { index, i ->
        if (index == 0) {
            lastNumber = i
            count++
        }
        else {
            if (i <= lastNumber) {
                count++
            } else {
                count = 1
            }
            lastNumber = i
            if (count > max) {
                max = count
            }
        }
    }

    println(max)

}