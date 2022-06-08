package graph.dijkstra

class Dijkstra() {

    val ansList: List<List<List<Int>>>
    private val edges: List<List<Int>>
    private val nodeNumber: Int
    private val id: IntRange
    private val graphData: Array<Array<Int>>
    private val nodeEdges: Map<Int, Array<Int>>

    init {
        val (nodeNumber, edgeNumber) = readLine()!!
            .split(" ")
            .slice(0..1)
            .map { it.toInt() }
        this.nodeNumber = nodeNumber

        val edges = List(edgeNumber) {
            readLine()!!
                .split(" ")
                .slice(0..2)
                .map{ it.toInt() }
        }
        this.edges = edges

        this.id = 0 until this.nodeNumber
        this.graphData = Graph(this.nodeNumber, edges).costList
        this.nodeEdges = id.associateWith { graphData[it] }
        ansList = solveAllCondition()
    }

    private fun solveAllCondition(): List<List<List<Int>>> {

        val result = mutableListOf<List<List<Int>>>()
        for (i in id) {
            val tempNode = solve(i)
            result.add(tempNode)
        }
        return result.toList()
    }

    private fun solve(startNodeId: Int): List<List<Int>> {
        val nodeCostList = id.associateWith { if (it == startNodeId) 0 else Int.MAX_VALUE }.toMutableMap()
        val nodeIsVisited = id.associateWith { false }.toMutableMap()
        val nodeParent: MutableMap<Int, Int?> = id.associateWith { null }.toMutableMap()

        while (nodeIsVisited.any { !it.value }) {
            val closestNode = getMinCostNode(nodeCostList, nodeIsVisited)
            val closestNodeCost =
                nodeCostList[closestNode] ?: throw java.lang.NullPointerException("closest nodeCost Nullpo desuwa")
            val checkingEdges =
                nodeEdges[closestNode] ?: throw java.lang.NullPointerException("nodeEdge Nullpo desuwa")

            checkingEdges.forEachIndexed { idx, cost ->
                //println("$cost $idx")
                if (cost > 0) {
                    val targetCost = nodeCostList[idx] ?: throw java.lang.NullPointerException("nodeCost Nullpo desuwa")
                    if (targetCost > cost + closestNodeCost) {
                        nodeCostList[idx] = cost + closestNodeCost
                        nodeParent[idx] = closestNode
                    }
                }
            }
            nodeIsVisited[closestNode] = true
        }

        val parentsList = mutableListOf<List<Int>>()
        for (i in id) {
            var parent: Int? = i
            val list = mutableListOf<Int>(parent!!)
            while (true) {
                parent = nodeParent[parent]
                if (parent == null) break
                list.add(parent)
            }

            parentsList.add(list.toList().reversed())
        }
        return parentsList.toList()

    }

    private fun getMinCostNode(nodeCostList: MutableMap<Int, Int>, nodeIsVisited: MutableMap<Int, Boolean>): Int { // 最小コストノードのID
        val unvisitedNode = nodeIsVisited.filter { !it.value }
        val minCostNode = unvisitedNode
            .map { it.key }
            .associateWith { nodeCostList[it] }
            .minByOrNull { it.value ?: Int.MAX_VALUE }
            ?.key

        return minCostNode ?: throw java.lang.NullPointerException("min cost is null-pointer desuwa")
    }
}