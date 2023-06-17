package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val list = mutableListOf<Triple<Int, Int, Int>>()
    val result = mutableListOf<Pair<Int, Int>>()

    repeat(readLine().toInt()) {
        val (nation ,number, grade) = readLine().split(" ").map { it.toInt() }
        list.add(Triple(nation, number, grade))
    }

    list.sortByDescending { it.third }
    for (triple in list){
        if (result.count { it.first == triple.first } < 2 ) {
            result.add(triple.first to triple.second)
        }
        if (result.size == 3) break
    }



    result.forEach {
        println("${it.first} ${it.second}")
    }

}