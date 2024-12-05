import kotlin.math.absoluteValue

object Day2{
    fun isIncreasing(a: Int, b: Int): Boolean {
        return a < b
    }

    fun isValidGap(a: Int, b: Int): Boolean{
        val gap = (a - b).absoluteValue
        return gap >= 1 && gap <= 3
    }

    fun partOne(inputList: List<List<Int>>): Int {
        var answer = inputList.size
        inputList.forEach {
            val isIncreasingNow = isIncreasing(it[0] , it[1])

            for(i in 0 until it.size - 1){
                if (isIncreasingNow != isIncreasing(it[i], it[i+1])) {
                    answer--
                    break
                }
                if(!isValidGap(it[i], it[i+1])){
                    answer--
                    break
                }
            }
        }


        return answer
    }
}

fun processInput(input: String): List<List<Int>> {
    return input.split("\n")
        .map {
            it.split(" ")
                .map {
                    it.toInt()
                }
        }
}

val input = """
16 16 18 21 23 24 26
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
""".trimIndent()

println(Day2.partOne(processInput(input)))

