package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val lengths = mutableListOf<Int>()

    var maxHorizontalLength = 0
    var maxVerticalLength = 0
    var maxHorizontalIndex = 0
    var maxVerticalIndex = 0

    repeat(6) {
        val (direction, length) = readLine().split(" ").map { it.toInt() }
        lengths.add(length)

        when (direction) {
            1, 2 -> {
                if (maxHorizontalLength < length) {
                    maxHorizontalIndex = it
                    maxHorizontalLength = length
                }
            }
            else -> {
                if (maxVerticalLength < length) {
                    maxVerticalIndex = it
                    maxVerticalLength = length
                }
            }
        }
    }

    val smallArea = if ((maxHorizontalIndex + 1) % 6 == maxVerticalIndex) {
        lengths[(maxVerticalIndex + 2) % 6] * lengths[(maxVerticalIndex + 3) % 6]
    } else {
        lengths[(maxHorizontalIndex + 2) % 6] * lengths[(maxHorizontalIndex + 3) % 6]
    }

    val largeArea = maxHorizontalLength * maxVerticalLength
    println("${(largeArea - smallArea) * n}")

}