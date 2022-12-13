package com.mobiento.aoc

fun Pair<Int, Int>.toSequence(): Set<Int> {
    val result = arrayListOf<Int>()
    for (x in first .. second) {
        result.add(x)
    }
    return result.toSet()
}

class Day04 {

    companion object {
        val regex = "(\\d+)-(\\d+),(\\d+)-(\\d+)".toRegex()
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            regex.matchEntire(line)?.groups?.let { matchGroups ->
                val firstPair = Pair(extractIntVal(matchGroups, 1), extractIntVal(matchGroups, 2))
                val secondPair = Pair(extractIntVal(matchGroups, 3), extractIntVal(matchGroups, 4))
                calculatePairForPartOne(firstPair, secondPair)
            } ?: 0
        }
    }

    private fun extractIntVal(matchGroups: MatchGroupCollection, index: Int): Int {
        val group = matchGroups[index]
        val value = group?.value
        return value?.toInt() ?: 0
    }

    private fun calculatePairForPartOne(first: Pair<Int, Int>, second: Pair<Int, Int>): Int {
        return if (isEncompassing(first, second)) 1 else 0
    }

    fun isEncompassing(firstPair: Pair<Int, Int>, secondPair: Pair<Int, Int>): Boolean {
        return (firstPair.first >= secondPair.first && firstPair.second <= secondPair.second) ||
                (secondPair.first >= firstPair.first && secondPair.second <= firstPair.second)
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            regex.matchEntire(line)?.groups?.let { matchGroups ->
                val firstPair = Pair(extractIntVal(matchGroups, 1), extractIntVal(matchGroups, 2))
                val secondPair = Pair(extractIntVal(matchGroups, 3), extractIntVal(matchGroups, 4))
                calculatePairForPartTwo(firstPair, secondPair)
            } ?: 0
        }
    }

    fun isOverlapping(first: Pair<Int, Int>, second: Pair<Int, Int>): Boolean {
        return first.toSequence().intersect(second.toSequence()).isNotEmpty()
    }

    fun calculatePairForPartTwo(first: Pair<Int, Int>, second: Pair<Int, Int>): Int {
        return if (isOverlapping(first, second)) 1 else 0
    }

}