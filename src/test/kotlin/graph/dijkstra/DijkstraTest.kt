package graph.dijkstra

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DijkstraTest() {
    @Test
    internal fun dijkstra_solveNormalCondition() {
        val ans = Dijkstra().ansList
        val expectedAnswer = listOf<List<Int>>(
            listOf(0),
            listOf(0, 1),
            listOf(0, 5, 4, 3, 2),
            listOf(0, 5, 4, 3),
            listOf(0, 5, 4),
            listOf(0, 5)
        )
        assertEquals(expectedAnswer, ans)
    }
}