package com.mobiento.aoc

class Day02 {

    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            line.split(" ").takeIf { it.size >= 2 }?.let { parts ->
                scoreForRoundPart1(parts[0], parts[1])
            } ?: 0
        }
    }

    fun scoreForRoundPart1(a: String, b: String): Int {
        val opponentChoice = Choice.fromOpponentChoice(a)
        val playerChoice = Choice.fromPlayerChoice(b)
        val outcome = calculateOutcome(opponentChoice, playerChoice)
        return outcome.value + playerChoice.value
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            line.split(" ").takeIf { it.size >= 2 }?.let { parts ->
                scoreForRoundPart2(parts[0], parts[1])
            } ?: 0
        }
    }

    fun scoreForRoundPart2(a: String, b: String): Int {
        val opponentChoice = Choice.fromOpponentChoice(a)
        val expectedOutcome = Outcome.fromSource(b)
        val playerChoice = playerChoiceForOutcome(opponentChoice, expectedOutcome)
        return expectedOutcome.value + playerChoice.value
    }

    enum class Outcome(val source: String, val value: Int) {
        LOSE("X", 0),
        DRAW("Y", 3),
        WIN("Z", 6);

        companion object {
            fun fromSource(source: String): Outcome {
                return values().find { it.source == source } ?: throw Exception("No matching source: $source")
            }
        }
    }

    enum class Choice(val opponentChoice: String, val playerChoice: String, val value: Int) {
        ROCK("A", "X", 1),
        PAPER("B", "Y", 2),
        SCISSORS("C", "Z", 3);

        companion object {
            fun fromPlayerChoice(choice: String): Choice {
                return values().find { it.playerChoice == choice } ?: throw Exception("No matching choice for $choice")
            }
            fun fromOpponentChoice(choice: String): Choice {
                return values().find { it.opponentChoice == choice } ?: throw Exception("No matching choice for $choice")
            }
        }

    }

    private fun playerChoiceForOutcome(opponentChoice: Choice, expectedOutcome: Outcome): Choice {
        return when (opponentChoice) {
            Choice.ROCK -> when (expectedOutcome) {
                Outcome.LOSE -> Choice.SCISSORS
                Outcome.DRAW -> Choice.ROCK
                Outcome.WIN -> Choice.PAPER
            }
            Choice.PAPER -> when (expectedOutcome) {
                Outcome.LOSE -> Choice.ROCK
                Outcome.DRAW -> Choice.PAPER
                Outcome.WIN -> Choice.SCISSORS
            }
            Choice.SCISSORS -> when(expectedOutcome) {
                Outcome.LOSE -> Choice.PAPER
                Outcome.DRAW -> Choice.SCISSORS
                Outcome.WIN -> Choice.ROCK
            }
        }
    }

    private fun calculateOutcome(opponentChoice: Choice, playerChoice: Choice): Outcome {
        return when (opponentChoice) {
            Choice.ROCK -> when (playerChoice) {
                Choice.ROCK -> Outcome.DRAW
                Choice.PAPER -> Outcome.WIN
                Choice.SCISSORS -> Outcome.LOSE
            }
            Choice.PAPER -> when (playerChoice) {
                Choice.ROCK -> Outcome.LOSE
                Choice.PAPER -> Outcome.DRAW
                Choice.SCISSORS -> Outcome.WIN
            }
            Choice.SCISSORS -> when (playerChoice) {
                Choice.ROCK -> Outcome.WIN
                Choice.PAPER -> Outcome.LOSE
                Choice.SCISSORS -> Outcome.DRAW
            }
        }
    }



}