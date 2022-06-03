package graph.dijkstra

class Graph {

    val costList: Array<Array<Int>>;

    constructor(n: Int, list: List<List<Int>>) {
        costList = Array(n) { Array(n) { 0 } }
        for (l in list) {
            val nodeA = l[0]
            val nodeB = l[1]
            val cost = l[2]
            costList[nodeA][nodeB] = cost
        }

        //costList = list
    }
}
