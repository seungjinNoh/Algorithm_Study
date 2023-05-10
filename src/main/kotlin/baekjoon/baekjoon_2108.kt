package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

var numbers = mutableListOf<Int>()
var map = hashMapOf<Int, Int>()
var sum = 0.0
var size = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    repeat(readLine().toInt()) {
        val number = readLine().toInt()
        if (map[number] == null) map[number] = 1
        else {
            val temp = map[number]
            if (temp != null) {
                map[number] = temp + 1
            }
        }
        numbers.add(number)
        sum += number
    }

    size = numbers.size
    numbers.sort()

    //산술평균
    val ans1 = Math.round(sum / size)
    println(ans1)

    //중앙값
    val ans2 = numbers[size / 2]
    println(ans2)

    //최빈값
    val maxVal = map.values.maxOrNull()
    val tempList = map.filterValues { it == maxVal }.keys.toMutableList()
    tempList.sort()
    if (tempList.size > 1) println(tempList[1]) else println(tempList[0])

    //범위
    println(numbers.last() - numbers.first())

}