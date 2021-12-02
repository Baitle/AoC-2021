package day2

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val commandList = input.map {
            val pair = it.split(" ")
            Pair(pair.first(), pair.last().toInt())
        }


        var horizontal = 0
        var depth = 0
        commandList.forEach {
            when (it.first) {
                "forward" -> horizontal += it.second
                "up" -> depth -= it.second
                "down" -> depth += it.second
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        val commandList = input.map {
            val pair = it.split(" ")
            Pair(pair.first(), pair.last().toInt())
        }


        var horizontal = 0
        var depth = 0
        var aim = 0
        commandList.forEach {
            when (it.first) {
                "forward" -> {
                    horizontal += it.second
                    depth += aim * it.second
                }
                "up" -> aim -= it.second

                "down" -> aim += it.second
            }
        }
        return horizontal * depth
    }


// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
