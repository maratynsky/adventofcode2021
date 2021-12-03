import java.util.*

/**
 * https://adventofcode.com/2021/day/3
 */
fun d3p1(): Long = read("/day3.in").useLines {
    val n = 12
    val stats = Array(n) { 0 }
    it.forEach { report ->
        report.forEachIndexed { i, bit ->
            stats[i] += if(bit == '1') 1 else -1
        }
    }
    var gamma = 0L
    var epsilon = 0L
    stats.map { stat -> stat > 0 }.forEachIndexed { i, bit ->
        gamma += (if(bit) 1 else 0) shl (n - 1 - i)
        epsilon += (if(bit) 0 else 1) shl (n - 1 - i)
    }
    return gamma * epsilon
}

fun d3p2(): Long = read("/day3.in").useLines {
    val n = 12
    val stats = Array(n) { 0 }
    it.forEach { report ->
        report.forEachIndexed { i, bit ->
            stats[i] += if(bit == '1') 1 else -1
        }
    }

    val commonBits = stats.map { stat -> stat > 0 }


    return 0L
}

fun main() {
    println(d3p1())
    println(d3p2())
}