package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

var evenCount = 0
var oddCount = 0
var nameLength = 0
val arr = IntArray(26) { 0 }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val name = readLine()
    nameLength = name.length

    name.forEach {
        arr[it - 'A']++
    }

    arr.forEach {
        if (it != 0) {
            if (it % 2 == 0) evenCount++
            else oddCount++
        }
    }

    if (nameLength % 2 == 0) {
        if (oddCount != 0) {
            println("I'm Sorry Hansoo")
            return@with
        } else {
            println(getName())
        }
    } else {
        if (oddCount != 1) {
            println("I'm Sorry Hansoo")
            return@with
        } else {
            println(getName())
        }
    }

}

fun getName(): String {
    var result = ""

    when (nameLength % 2) {
        0 -> {
            for (i in arr.indices) {
                if (arr[i] != 0) {
                    repeat(arr[i] / 2) {
                        result += ('A' + i)
                    }
                }
            }
            result += result.reversed()
        }
        else -> {
            var oddIndex = 0

            for (i in arr.indices) {
                if (arr[i] != 0) {
                    if (arr[i] % 2 == 0) {
                        repeat(arr[i] / 2) {
                            result += ('A' + i)
                        }
                    } else {
                        if (arr[i] > 2) {
                            repeat(arr[i] / 2) {
                                result += ('A' + i)
                            }
                        }
                        oddIndex = i
                    }
                }
            }
            result += (('A' + oddIndex)  + result.reversed())
        }
    }
    return result
}