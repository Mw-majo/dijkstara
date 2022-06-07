package graph.dijkstra

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DijkstraTest() {
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

    @Test
    internal fun dijkstra_solveNormalCondition() {
        val ans = Dijkstra(6, edges).ansList[0]
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