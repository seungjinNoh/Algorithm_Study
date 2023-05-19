package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val numbers = MutableList(10) { 0 }
    var count = 0

    readLine().forEach {
        val number = it.code - 48
        if (number == 6 || number == 9) {
            if (numbers[6] == 0 && numbers[9] == 0) {
                count++
                for (i in 0 until 10) {
                    numbers[i] = numbers[i] + 1
                }
            }
            if (numbers[6] > 0) numbers[6] = numbers[6] - 1
            else if (numbers[9] > 0) numbers[9] = numbers[9] - 1
        } else {
            if (numbers[number] == 0) {
                count++
                for (i in 0 until 10) {
                    numbers[i] = numbers[i] + 1
                }
            }
            numbers[number] = numbers[number] - 1
        }

    }

    println(count)

}
