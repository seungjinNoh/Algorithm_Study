package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (c, r) = readLine().split(" ").map { it.toInt() }
    val k = readLine().toInt()
    var currentPosition = (1 to 1)
    var count = 1

    if (k == 1) {
        println("1 1")
        return@with
    }

    var minusCount = 1
    while (count < c * r) {
        while (currentPosition.second <= r - minusCount) {
            count++
            currentPosition = (currentPosition.first to currentPosition.second + 1)
            if (count == k) {
                println("${currentPosition.first} ${currentPosition.second}")
                return@with
            }
        }
        while (currentPosition.first <= c - minusCount) {
            count++
            currentPosition = (currentPosition.first + 1 to currentPosition.second)
            if (count == k) {
                println("${currentPosition.first} ${currentPosition.second}")
                return@with
            }
        }
        while (currentPosition.second >= 1 + minusCount) {
            count++
            currentPosition = (currentPosition.first to currentPosition.second - 1)
            if (count == k) {
                println("${currentPosition.first} ${currentPosition.second}")
                return@with
            }
        }
        while (currentPosition.first > 1 + minusCount) {
            count++
            currentPosition = (currentPosition.first - 1 to currentPosition.second)
            if (count == k) {
                println("${currentPosition.first} ${currentPosition.second}")
                return@with
            }
        }
        minusCount++
    }

    println("0")
}