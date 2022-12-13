package com.mobiento.aoc

import org.junit.Assert.assertEquals
import org.junit.Test

class Day04Test {

    @Test
    fun testPart1() {
        val sut = Day04()
        val input = readInput("Day04_test")
        val result = sut.part1(input)
        assertEquals(2, result)
    }

    @Test
    fun testIsEncompassing() {
        testSingleTwoPairs(Pair(2,8), Pair(3,7), true)
        testSingleTwoPairs(Pair(6,6), Pair(4,6), true)
        testSingleTwoPairs(Pair(5,7), Pair(7,9), false)
    }

    private fun testSingleTwoPairs(first: Pair<Int, Int>, second: Pair<Int, Int>, expected: Boolean) {
        val sut = Day04()
        val result = sut.isEncompassing(first, second)
        assertEquals(expected, result)
    }

    @Test
    fun testPartOneForReal() {
        val sut = Day04()
        val input = readInput("Day04_input")
        val result = sut.part1(input)
        assertEquals(532, result)
    }

    @Test
    fun testPart2() {
        val sut = Day04()
        val input = readInput("Day04_test")
        val result = sut.part2(input)
        assertEquals(4, result)
    }

    @Test
    fun testPart2ForReal() {
        val sut = Day04()
        val input = readInput("Day04_input")
        val result = sut.part2(input)
        assertEquals(854, result)
    }

    @Test
    fun testIsOverlapping() {
        testSingleTwoPairsOverlap(Pair(2,8), Pair(3,7), true)
        testSingleTwoPairsOverlap(Pair(6,6), Pair(4,6), true)
        testSingleTwoPairsOverlap(Pair(5,7), Pair(7,9), true)
        testSingleTwoPairsOverlap(Pair(2,4), Pair(6,8), false)
        testSingleTwoPairsOverlap(Pair(2,3), Pair(4,5), false)
        testSingleTwoPairsOverlap(Pair(2,9), Pair(4,5), true)
    }

    private fun testSingleTwoPairsOverlap(first: Pair<Int, Int>, second: Pair<Int, Int>, expected: Boolean) {
        val sut = Day04()
        val result = sut.isOverlapping(first, second)
        assertEquals(expected, result)
    }

    @Test
    fun testToList() {
        var input = Pair(2,6)
        var result = input.toSequence()
        assertEquals(linkedSetOf(2,3,4,5,6), result)

        input = Pair(6,6)
        result = input.toSequence()
        assertEquals(linkedSetOf(6), result)

        input = Pair(6,7)
        result = input.toSequence()
        assertEquals(linkedSetOf(6, 7), result)
    }

}