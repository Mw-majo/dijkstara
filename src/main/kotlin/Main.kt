//package graph

import graph.dijkstra.Dijkstra

// private const val MAX_COST = Int.MAX_VALUE

fun main(args: Array<String>) {
    val ans = Dijkstra()
    println(ans.ansList)
}

// private fun readInts(n: Int) = readLine()!!.split(" ").map(String::toInt).slice(0 until n)