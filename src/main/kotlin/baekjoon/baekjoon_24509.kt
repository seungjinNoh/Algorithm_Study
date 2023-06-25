package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val kor = mutableListOf<Pair<Int, Int>>()
    val eng = mutableListOf<Pair<Int, Int>>()
    val math = mutableListOf<Pair<Int, Int>>()
    val sc = mutableListOf<Pair<Int, Int>>()
    val winner = mutableListOf<Int>()

    repeat(n) {
        val str = readLine().split(" ").map { it.toInt() }
        val number = str.first()

        for (i in 1 until str.size) {
            when(i) {
                1 -> kor.add(number to str[i])
                2 -> eng.add(number to str[i])
                3 -> math.add(number to str[i])
                4 -> sc.add(number to str[i])
            }
        }
    }

    kor.sortBy { it.first }
    eng.sortBy { it.first }
    math.sortBy { it.first }
    sc.sortBy { it.first }

    kor.sortByDescending { it.second }
    eng.sortByDescending { it.second }
    math.sortByDescending { it.second }
    sc.sortByDescending { it.second }

    for (item in kor) {
        if (!winner.contains(item.first)) {
            winner.add(item.first)
            break
        }
    }

    for (item in eng) {
        if (!winner.contains(item.first)) {
            winner.add(item.first)
            break
        }
    }

    for (item in math) {
        if (!winner.contains(item.first)) {
            winner.add(item.first)
            break
        }
    }

    for (item in sc) {
        if (!winner.contains(item.first)) {
            winner.add(item.first)
            break
        }
    }

    println(winner.joinToString(" "))
}