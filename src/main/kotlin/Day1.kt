@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

import java.nio.file.Path

const val input = "/day1.in"
val file = Path.of({}.javaClass.getResource(input).toURI()).toFile()!!

/**
 * https://adventofcode.com/2021/day/1
 */
fun part1() = file.useLines {
    it.map(String::toLong).zipWithNext(Long::minus).filter { a -> a < 0 }.count()
}

/**
 * https://adventofcode.com/2021/day/1
 */
fun part2() = file.useLines {
    it.map(String::toLong).windowed(3) { it.sum() }
        .zipWithNext(Long::minus).filter { a -> a < 0 }.count()
}

fun main(args: Array<String>) {
    println(part1())
    println(part2())
}

