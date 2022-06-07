package graph.dijkstra

class Graph//costList = list
    (n: Int, list: List<List<Int>>) {

    val costList: Array<Array<Int>>

    init {
        costList = Array(n) { Array(n) { 0 } }
        for (l in list) {
            val nodeA = l[0]
            val nodeB = l[1]
            val cost = l[2]
            costList[nodeA][nodeB] = cost
            costList[nodeB][nodeA] = cost
        }
    }
}
