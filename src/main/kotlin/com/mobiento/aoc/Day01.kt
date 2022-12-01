package com.mobiento.aoc

class Day01 {

    fun part1(input: List<String>): Int {
        return calculateCaloriesPerElf(input).max()
    }

    fun part2(input: List<String>): Int {
        val sortedDescending = calculateCaloriesPerElf(input).sortedDescending()
        val topThree = sortedDescending.take(3)
        return topThree.sum()
    }

    fun calculateCaloriesPerElf(input: List<String>): List<Int> {
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
        if (tempVal != 0) {
            result.add(tempVal)
        }

        return result
    }

}
