package graph.dijkstra

import io.StandardInputStream
import io.StandardOutputStream
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DijkstraTest() {

    private val input = StandardInputStream()
    private val output = StandardOutputStream()


    @BeforeEach
    fun setUp() {
        System.setIn(input)
        System.setOut(output)
    }

    @AfterEach
    fun tearDown(){
        System.setIn(null)
        System.setOut(null)
    }

//    val edges = listOf(
//        listOf(0, 1, 6),
//        listOf(0, 5, 3),
//        listOf(1, 2, 3),
//        listOf(2, 3, 1),
//        listOf(2, 4, 3),
//        listOf(2, 5, 5),
//        listOf(3, 4, 1),
//        listOf(4, 5, 2)
//    )

    @Test
    internal fun dijkstra_solveNormalCondition() {
        input.inputln("6 8")
        input.inputln("0 1 6")
        input.inputln("0 5 3")
        input.inputln("1 2 3")
        input.inputln("2 3 1")
        input.inputln("2 4 3")
        input.inputln("2 5 5")
        input.inputln("3 4 1")
        input.inputln("4 5 2")

        val ans = Dijkstra().ansList[0]
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