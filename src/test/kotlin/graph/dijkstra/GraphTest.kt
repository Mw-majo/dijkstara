package graph.dijkstra

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class GraphTest{
    @Test
    internal fun graph_zeroOnly_correctLy() {
        val graph = Graph(6, listOf(listOf(0,0,0)))
        val expect = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0)
        )

        assertEquals(
            expect.contentDeepToString(),
            graph.costList.contentDeepToString()
        )
    }

    @Test
    internal fun graph_add2Edges_correctLy() {
        val graph = Graph(6, listOf(listOf(0,1,1),listOf(0,2,2)))
        val expect = arrayOf(
            arrayOf(0, 1, 2, 0, 0, 0),
            arrayOf(1, 0, 0, 0, 0, 0),
            arrayOf(2, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0)
        )

        assertEquals(
            expect.contentDeepToString(),
            graph.costList.contentDeepToString()
        )
    }
}