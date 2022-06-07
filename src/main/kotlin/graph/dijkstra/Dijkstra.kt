package graph.dijkstra

class Dijkstra() {

    val ansList: List<List<Int>>

    private val input = listOf(
        listOf(0, 1, 6),
        listOf(0, 5, 3),
        listOf(1, 2, 3),
        listOf(2, 3, 1),
        listOf(2, 4, 3),
        listOf(2, 5, 5),
        listOf(3, 4, 1),
        listOf(4, 5, 2)
    )

    private val nodeNumber = 6
    private val graphDataGenerated = Graph(nodeNumber, input)
    private val graphData = graphDataGenerated.costList
    //private val NODE_VALUE = graphData.size

    private val startNodeId = 0
    // private const val goalNodeId = 1

    // private val NAMES = listOf("home", "A", "school", "C", "B", "shop")
    private val id = 0 until nodeNumber

    // private val nodeName = id.associateWith { NAMES[it] }
    private val nodeEdges = id.associateWith { graphData[it] }
    private val nodeCost = id.associateWith { if (it == startNodeId) 0 else Int.MAX_VALUE }.toMutableMap()
    private val nodeIsVisited = id.associateWith { false }.toMutableMap()
    private val nodeParent: MutableMap<Int, Int?> = id.associateWith { null }.toMutableMap()


    init {
        ansList = solve()
    }

    private fun solve(): List<List<Int>> {
        while (isSolve()) {
            val closestNode = getMinCostNode()
            val closestNodeCost =
                nodeCost[closestNode] ?: throw java.lang.NullPointerException("closest nodeCost Nullpo desuwa")
            val checkingEdges =
                nodeEdges[closestNode] ?: throw java.lang.NullPointerException("nodeEdge Nullpo desuwa")

            checkingEdges.forEachIndexed { idx, cost ->
                //println("$cost $idx")
                if (cost > 0) {
                    val targetCost = nodeCost[idx] ?: throw java.lang.NullPointerException("nodeCost Nullpo desuwa")
                    if (targetCost > cost + closestNodeCost) {
                        nodeCost[idx] = cost + closestNodeCost
                        nodeParent[idx] = closestNode
                    }
                }
            }
            nodeIsVisited[closestNode] = true
        }

        val parentsList = mutableListOf<List<Int>>()
        for (i in 0 until nodeNumber) {
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

    private fun isSolve() = nodeIsVisited.any { !it.value }
    private fun getMinCostNode(): Int { // 最小コストノードのID
        val unvisitedNode = nodeIsVisited.filter { !it.value }
        val minCostNode = unvisitedNode
            .map { it.key }
            .associateWith { nodeCost[it] }
            .minByOrNull { it.value ?: Int.MAX_VALUE }
            ?.key

        return minCostNode ?: throw java.lang.NullPointerException("min cost is null-pointer desuwa")
    }
}