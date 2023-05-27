package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val target = readLine().toInt()

    var number = n * n
    var result = ""
    val arr = Array(n + 1) { IntArray(n + 1) { 0 } }

    var currentRow = 1
    var currentCol = 1

    var minRow = 1
    var minCol = 2

    var maxRow = n
    var maxCol = n

    while (true) {

        while (currentRow <= maxRow) {
            if (number == target) {
                result = "$currentRow $currentCol"
            }
            arr[currentRow][currentCol] = number
            number--
            if (currentRow == maxRow) {
                maxRow--
                currentCol++
                break
            } else {
                currentRow++
            }
        }

        if (number == 0) break

        while (currentCol <= maxCol) {
            if (number == target) {
                result = "$currentRow $currentCol"
            }
            arr[currentRow][currentCol] = number
            number--
            if (currentCol == maxCol) {
                maxCol--
                currentRow--
                break
            } else {
                currentCol++
            }
        }

        if (number == 0) break

        while (currentRow >= minRow) {
            if (number == target) {
                result = "$currentRow $currentCol"
            }
            arr[currentRow][currentCol] = number
            number--
            if (currentRow == minRow) {
                minRow++
                currentCol--
                break
            } else {
                currentRow--
            }
        }

        if (number == 0) break

        while (currentCol >= minCol) {
            if (number == target) {
                result = "$currentRow $currentCol"
            }
            arr[currentRow][currentCol] = number
            number--
            if (currentCol == minCol) {
                minCol++
                currentRow++
                break
            } else {
                currentCol--
            }
        }

        if (number == 0) break

    }

    for (i in 1..n) {
        for (j in 1..n) {
            print("${arr[i][j]} ")
        }
        println()
    }

    println(result)
}