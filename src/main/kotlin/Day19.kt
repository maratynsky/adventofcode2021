import kotlin.math.sqrt

data class Pos(val x: Int, val y: Int, val z: Int) {
    fun distance(from: Pos) =
        sqrt(((x - from.x) * (x - from.x) + (y - from.y) * (y - from.y) + (z - from.z) * (z - from.z)).toDouble())

    infix fun minus(p:Pos) = Pos(x-p.x, y-p.y, z-p.z)
}

data class Scanner(val name: String, val beacons: List<Pos>) {

    fun distances(): List<Pair<Pos, List<Double>>> {
        return beacons.map { beacon ->
            beacon to beacons.map { it.distance(beacon) }
        }
    }
}

fun readScanners(input: Sequence<String>) = with(input.iterator()) {
    generateSequence {
        if (hasNext())
            Scanner(
                next().trim(' ', '-'),
                generateSequence {
                    if (hasNext())
                        with(next()) {
                            if (isBlank()) null
                            else split(',').map(Integer::parseInt).let { Pos(it[0], it[1], it[2]) }
                        }
                    else null
                }.toList()
            )
        else null
    }.toList()
}

fun d19p1(): Int = read("/day19.in").useLines { readScanners(it) }.let { scanners ->
    println(scanners)
    val distances0 = scanners[0].distances()
    val distances1 = scanners[1].distances()

    val beaconsInCommon = distances0.map {
        it.first to distances1.find { d1 -> d1.second.intersect(it.second.toSet()).size >= 12 }?.first
    }.filter { it.second != null }.map { it.first to it.second!! }

    println(beaconsInCommon[0].first minus beaconsInCommon[0].second)



//    for (d0 in distances0) {
//        val beacon0 = d0.first
//        println("=======================")
//        val beacon1 = distances1.find { d0.second.intersect(it.second.toSet()).size >= 12 }?.first
//        println("$beacon0 -> $beacon1")
//    }
    2
}

fun d19p2(): Int = read("/day19.in").useLines {
    return 0
}

fun main() {
    println("Day 19")
    println(" ├─ ${d19p1()}")
    println(" └─ ${d19p2()}")
}