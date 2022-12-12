package com.mobiento.aoc

import org.junit.Assert.assertEquals
import org.junit.Test

class Day03Test {

    @Test
    fun testPart1() {
        val sut = Day03()
        val input = readInput("Day03_test")
        val result = sut.part1(input)
        assertEquals(157, result)
    }

    @Test
    fun testPriorities() {
        testSinglePriority('p', 16)
        testSinglePriority('L', 38)
        testSinglePriority('P', 42)
        testSinglePriority('v', 22)
        testSinglePriority('t', 20)
    }

    private fun testSinglePriority(letter: Char, expected: Int) {
        val sut = Day03()
        val result = sut.getPriority(letter)
        assertEquals(expected, result)
    }

    @Test
    fun testGetFirstCompartmentItems() {
        val sut = Day03()
        val result = sut.getFirstCompartmentItems("vJrwpWtwJgWrhcsFMMfFFhFp")
        assertEquals("vJrwpWtwJgWr", result)
    }

    @Test
    fun testGetSecondCompartmentItems() {
        val sut = Day03()
        val result = sut.getSecondCompartmentItems("vJrwpWtwJgWrhcsFMMfFFhFp")
        assertEquals("hcsFMMfFFhFp", result)
    }

    @Test
    fun testGetCommonItems() {
        testGetSingleCommonItem("vJrwpWtwJgWr", "hcsFMMfFFhFp", 'p')
        testGetSingleCommonItem("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL", 'L')
    }

    private fun testGetSingleCommonItem(firstItems: String, secondItems: String, expected: Char) {
        val sut = Day03()
        val result = sut.findCommonItem(firstItems, secondItems)
        assertEquals(expected, result)
    }

    @Test
    fun testPartOneForReal() {
        val sut = Day03()
        val input = readInput("Day03_input")
        val result = sut.part1(input)
        assertEquals(7691, result)
    }

    @Test
    fun testPart2() {
        val sut = Day03()
        val input = readInput("Day03_test")
        val result = sut.part2(input)
        assertEquals(12, result)
    }



    @Test
    fun testPart2ForReal() {
        val sut = Day03()
        val input = readInput("Day03_input")
        val result = sut.part2(input)
        assertEquals(10398, result)
    }

}