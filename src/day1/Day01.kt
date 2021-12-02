package day1

import readInput
import sum3ElementsFromIdx

fun main() {
    fun part1(input: List<String>): Int {
        var previous: Int = -1
        return input.map {
            it.toInt()
        }.map {
            if (previous == -1) {
                previous = it
                return@map 0
            } else {
                val toReturn = if (previous < it) 1 else 0
                previous = it
                return@map toReturn
            }
        }.filter {
            it == 1
        }.count()
    }

    fun part2(input: List<String>): Int {
        var currentSum = 0
        var previousSum = 0

        var count = 0;
        val intList = input.map {
            it.toInt()
        }

        for (i in 0..intList.size-3) {
            if(i == 0) {
                currentSum = sum3ElementsFromIdx(intList, i)
            } else {
                previousSum = currentSum
                currentSum = sum3ElementsFromIdx(intList, i)
                if(currentSum > previousSum) {
                    count++
                }
            }
        }

        return count
    }



// test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
