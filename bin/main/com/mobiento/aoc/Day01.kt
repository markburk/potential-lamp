package com.mobiento.aoc

import com.mobiento.aoc.readInput

class Day01 {

    fun part1(input: List<String>): Int {

        val result: ArrayList<Int> = arrayListOf()
        var tempVal = 0
        input.forEach { line ->
            if (line.isNotBlank()) {
                tempVal += line.toInt()
            } else {
                result.add(tempVal)
                tempVal = 0
            }
        }

        return result.max()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

}
