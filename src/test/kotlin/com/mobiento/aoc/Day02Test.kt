package com.mobiento.aoc

import org.junit.Assert.assertEquals
import org.junit.Test

class Day02Test {

    @Test
    fun testPart1() {
        val sut = Day02()
        val input = readInput("Day02_test")
        val result = sut.part1(input)
        assertEquals(15, result)
    }

    @Test
    fun testIndividualScoresPart1() {
        testSingleScorePart1("A", "Y", 8)
        testSingleScorePart1("B", "X", 1)
        testSingleScorePart1("C", "Z", 6)
    }

    private fun testSingleScorePart1(a: String, b: String, expected: Int) {
        val sut = Day02()
        val result = sut.scoreForRoundPart1(a, b)
        assertEquals(expected, result)
    }

    @Test
    fun testPartOneForReal() {
        val sut = Day02()
        val input = readInput("Day02_input")
        val result = sut.part1(input)
        assertEquals(13009, result)
    }

    @Test
    fun testPart2() {
        val sut = Day02()
        val input = readInput("Day02_test")
        val result = sut.part2(input)
        assertEquals(12, result)
    }

    @Test
    fun testIndividualScoresPart2() {
        testSingleScorePart2("A", "Y", 4)
        testSingleScorePart2("B", "X", 1)
        testSingleScorePart2("C", "Z", 7)
    }

    private fun testSingleScorePart2(a: String, b: String, expected: Int) {
        val sut = Day02()
        val result = sut.scoreForRoundPart2(a, b)
        assertEquals(expected, result)
    }

    @Test
    fun testPart2ForReal() {
        val sut = Day02()
        val input = readInput("Day02_input")
        val result = sut.part2(input)
        assertEquals(10398, result)
    }

}