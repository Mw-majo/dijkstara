//package graph

import graph.dijkstra.Dijkstra

// private const val MAX_COST = Int.MAX_VALUE

fun main() {
    val nodeNumber = 6
    val edges = listOf(
        listOf(0, 1, 6),
        listOf(0, 5, 3),
        listOf(1, 2, 3),
        listOf(2, 3, 1),
        listOf(2, 4, 3),
        listOf(2, 5, 5),
        listOf(3, 4, 1),
        listOf(4, 5, 2)
    )

    val ans = Dijkstra(nodeNumber, edges)
    for (i in 0 until nodeNumber) println(ans.ansList[i])
}

// private fun readInts(n: Int) = readLine()!!.split(" ").map(String::toInt).slice(0 until n)