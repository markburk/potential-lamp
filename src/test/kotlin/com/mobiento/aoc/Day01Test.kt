package com.mobiento.aoc

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import com.mobiento.aoc.readInput

class Day01Test {


    @Test
    fun testPartOne() {
        val sut = Day01()
        val input = readInput("Day01_input")
        println("input: $input")
        val result = sut.part1(input)
        println("result: $result")
        assertEquals(result, 24000)
    }
}