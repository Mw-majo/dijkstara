package graph.dijkstra

class Dijkstra {
    companion object {

        //private const val NODE_VALUE = 6
        private val graphData = listOf(
            listOf(0, 6, 0, 0, 0, 3),
            listOf(6, 0, 3, 0, 0, 0),
            listOf(0, 3, 0, 1, 3, 5),
            listOf(0, 0, 1, 0, 1, 0),
            listOf(0, 0, 3, 1, 0, 2),
            listOf(3, 0, 5, 0, 2, 0)
        )
        private val NODE_VALUE = graphData.size

        private const val startNodeId = 0
        // private const val goalNodeId = 1

        private val NAMES = listOf("home", "A", "school", "C", "B", "shop")
        private val id = 0 until NODE_VALUE
        // private val nodeName = id.associateWith { NAMES[it] }
        private val nodeEdges = id.associateWith { graphData[it] }
        private val nodeCost = id.associateWith { if (it == startNodeId) 0 else Int.MAX_VALUE }.toMutableMap()
        private val nodeIsVisited = id.associateWith { false }.toMutableMap()
        private val nodeParent: MutableMap<Int, Int?> = id.associateWith { null }.toMutableMap()

        fun solve(): List<List<Int>> {
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
            for (i in 0 until NODE_VALUE) {
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
}