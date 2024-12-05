import kotlin.math.absoluteValue

object Day1{

    fun partOne(firstList: List<Int>, secondList: List<Int>) : Int{
        var answer = 0
        firstList.sorted()
            .let { f ->
                secondList.sorted()
                    .let { s->
                        for(i in firstList.indices){
                            answer += ( f[i] - s[i] ).absoluteValue
                        }
                    }
            }
        return answer
    }

    fun partTwo(firstList: List<Int>, secondList: List<Int>) : Int{
        var answer = 0
        firstList.sorted()
            .forEach { fValue ->
                secondList.count{ sValue ->
                    fValue == sValue
                }.run {
                    answer += fValue * this
                }
            }
        return answer
    }
}

val input = """
    3   4
    4   3
    2   5
    1   3
    3   9
    3   3
""".trimIndent()

fun processInput(input: String, idx: Int = 0): List<Int> {
    return input.split("\n")
        .map { it.split("   ").map { it.toInt() } }.map { it[idx] }
}

println(Day1.partOne(processInput(input), processInput(input, 1)))
println(Day1.partTwo(processInput(input), processInput(input, 1)))