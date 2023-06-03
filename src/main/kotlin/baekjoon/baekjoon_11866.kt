package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

   val (n, k) = readLine().split(" ").map { it.toInt() }

    val queue = LinkedList<Int>()
    val result = mutableListOf<Int>()

    repeat(n) {
        queue.offer(it + 1)
    }

    while (queue.isNotEmpty()) {
        repeat(k - 1) {
            val number = queue.poll()
            queue.offer(number)
        }
        result.add(queue.poll())
    }

    println("<${result.joinToString(", ")  }>")

}