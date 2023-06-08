package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

val visited = BooleanArray(1001) { false }
val arr = intArrayOf(1, 5, 10, 50)
var n = 0
var result = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()

    dfs(0, 0, 0)

    println(result)
}

fun dfs(depth: Int, index: Int, sum: Int) {
    if (depth == n) {
        if (!visited[sum]) {
            visited[sum] = true
            result++
        }
        return
    }

    /**
     * 인덱스를 설정하는 이유는 중복되는 숫자를 막기 위해서
     * 예를 들어 depth: 3 index: 2 인 경우
     * 해당 for문에서는 1, 10, x (1 10 1), (1 10 5), (1 10 10), (1 10 50) 네가지를 탐색한다
     * 하지만 그 전단계 depth 3인 1, 5 단계에서 (1 10 1), (1 10 5) 은 무조건 나오게 된다.
     * 따라서 이전 인덱스를 제외하고 for 문을 돌린다.
     */

    for (i in index..3) {
        dfs(depth + 1, i, sum + arr[i])
    }
}