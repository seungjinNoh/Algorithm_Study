package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val x = readLine().toInt()
    var count = 1
    var isDown =  0 // 0: 직선이동, 1: 대각선 아래, 2: 대각선 위
    var currentNode = Pair(1, 1)

    while (true) {
        if (count == x) {
            println("${currentNode.first}/${currentNode.second}")
            return@with
        }

        if (currentNode.first == 1 && isDown == 0) {
            currentNode = Pair(currentNode.first, currentNode.second + 1)
            isDown = 1
        } else if (currentNode.second == 1 && isDown == 0) {
            currentNode = Pair(currentNode.first + 1, currentNode.second)
            isDown = 2
        } else {
            currentNode = if (isDown == 1) {
                Pair(currentNode.first + 1, currentNode.second - 1)
            } else {
                Pair(currentNode.first - 1, currentNode.second + 1)
            }
            if (currentNode.first == 1 || currentNode.second == 1) isDown = 0
        }
        count++
    }
}