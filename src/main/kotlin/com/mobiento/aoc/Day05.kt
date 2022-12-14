package com.mobiento.aoc

import javax.swing.Box

class Day05 {

    companion object {
        val regex = "move (\\d+) from (\\d+) to (\\d+)".toRegex()
    }

    data class BoxStack(
        val number: Int,
        val boxes: ArrayDeque<String>
    )

    fun part1(input: List<String>): String {
        return parseInputAndReturnMessage(input)
    }

    fun parseInputAndReturnMessage(input: List<String>): String {
        val stacks = parseStacks(input)
        parseMovement(input, stacks, this::move)
        return getMessage(stacks)
    }

    fun parseStacks(input: List<String>): List<BoxStack> {
        val result = arrayListOf<BoxStack>()
        run breaking@ {
            input.forEach { line ->
                if (line.isBlank()) {
                    return@breaking
                }
                line.windowed(3, 4).let { stackRow ->
                    stackRow.forEachIndexed { index, s ->
                        s.takeIf { s.length == 3 }?.get(1)?.toString()?.let { contents ->
                            if (contents.toIntOrNull() != null) {
                                return@forEach
                            }
                            if (result.find { it.number == index } == null) {
                                result.add(BoxStack(index, ArrayDeque()))
                            }
                            if (contents.isNotBlank()) {
                                result[index].boxes.addFirst(contents)
                            }
                        }
                    }
                }
            }
        }

        return result
    }

    fun parseMovement(input: List<String>, stacks: List<BoxStack>, moveAlgorithm: (Int, BoxStack, BoxStack) -> Unit) {
        input.forEach { line ->
            regex.matchEntire(line)?.groups?.let { groups ->
                val quantity = groups[1]?.value?.toIntOrNull() ?: 0
                val fromIndex = (groups[2]?.value?.toIntOrNull() ?: -1) - 1
                val toIndex = (groups[3]?.value?.toIntOrNull() ?: -1) - 1
                if (quantity > 0 && fromIndex >= 0 && toIndex >= 0) {
                    moveAlgorithm(quantity, stacks[fromIndex], stacks[toIndex])
                }
            }
        }
    }

    fun move(quantity: Int, from: BoxStack, to: BoxStack) {
        for (x in 0 until quantity) {
            from.boxes.removeLast().let { removed ->
                to.boxes.addLast(removed)
            }
        }
    }

    fun moveMultiple(quantity: Int, from: BoxStack, to: BoxStack) {
        val tempStack = ArrayDeque<String>()
        for (x in 0 until quantity) {
            from.boxes.removeLast().let { removed ->
                tempStack.addFirst(removed)
            }
        }
        to.boxes.addAll(tempStack)
    }

    fun getMessage(stacks: List<BoxStack>): String {
        return stacks.joinToString(separator = "") { it.boxes.last() }
    }

    fun part2(input: List<String>): String {
        val stacks = parseStacks(input)
        parseMovement(input, stacks, this::moveMultiple)
        return getMessage(stacks)
    }


}