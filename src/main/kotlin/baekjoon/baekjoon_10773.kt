package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val k = readLine().toInt()
    val stack = Stack<Int>()

    repeat(k) {
        val n = readLine().toInt()
        if (n == 0) stack.pop()
        else stack.push(n)
    }

    if (stack.size == 0) println(0)
    else println(stack.sum())
}