//package graph

import graph.dijkstra.Dijkstra

// private const val MAX_COST = Int.MAX_VALUE

fun main() {
    val ans = Dijkstra()
    for (i in 0..5) println(ans.ansList[i])
}

// private fun readInts(n: Int) = readLine()!!.split(" ").map(String::toInt).slice(0 until n)