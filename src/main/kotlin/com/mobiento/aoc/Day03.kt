package com.mobiento.aoc

class Day03 {

    private val priority: Map<Char, Int> = hashMapOf<Char, Int>().apply {
        var priority = 0
        for (c in 'a' .. 'z') {
            this[c] = ++priority
        }
        for (c in 'A' .. 'Z') {
            this[c] = ++priority
        }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            getPriority(findCommonItem(getFirstCompartmentItems(line), getSecondCompartmentItems(line)))
        }
    }


    fun getFirstCompartmentItems(contents: String): String {
        return contents.substring(0, contents.length / 2)
    }
    fun getSecondCompartmentItems(contents: String): String {
        return contents.substring(contents.length / 2)
    }
    fun findCommonItem(firstItems: String, secondItems: String): Char {
        return firstItems.toSet().intersect(secondItems.toSet()).firstOrNull() ?: ' '
    }
    fun getPriority(letter: Char): Int {
        return priority[letter] ?: 0
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3, 3).sumOf {
            getPriority(findCommonItem(it[0], it[1], it[2]))
        }
    }

    fun findCommonItem(first: String, second: String, third: String): Char {
        return first.toSet().intersect(second.toSet()).intersect(third.toSet()).firstOrNull() ?: ' '
    }



}