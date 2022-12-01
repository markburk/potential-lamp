package com.mobiento.aoc

import org.junit.Assert.assertEquals
import org.junit.Test

class Day01Test {

    @Test
    fun testPartOne() {
        val sut = Day01()
        val input = readInput("Day01_test")
        val result = sut.part1(input)
        assertEquals(24000, result)
    }

    @Test
    fun testPartOneForReal() {
        val sut = Day01()
        val input = readInput("Day01_input")
        val result = sut.part1(input)
        assertEquals(74394, result)
    }

    @Test
    fun testPartTwo() {
        val sut = Day01()
        val input = readInput("Day01_test")
        val result = sut.part2(input)
        assertEquals(45000, result)
    }

    @Test
    fun testPartTwoForReal() {
        val sut = Day01()
        val input = readInput("Day01_input")
        val result = sut.part2(input)
        assertEquals(212836, result)
    }

}