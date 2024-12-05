import kotlin.math.absoluteValue

object Day2{
    fun isIncreasing(a: Int, b: Int): Boolean {
        return a < b
    }

    fun isValidGap(a: Int, b: Int): Boolean{
        val gap = (a - b).absoluteValue
        return gap >= 1 && gap <= 3
    }

    fun isOK(list: List<Int>): Boolean{
        val isIncreasingNow = isIncreasing(list[0] , list[1])
        for(i in 0 until list.size - 1){
            if (isIncreasingNow != isIncreasing(list[i], list[i+1]) || !isValidGap(list[i], list[i+1])) {
                return false
            }
        }
        return true
    }

    fun partOne(inputList: List<List<Int>>): Int {
        var answer = inputList.size
        inputList.forEach {
            if(!isOK(it))
                answer--
        }
        return answer
    }

    fun partTwo(inputList: List<List<Int>>): Int {
        var answer = inputList.size
        inputList.forEach {
            if(!isOK(it)){
                var ret = false
                for(i in it.indices){
                    val tmp = it.toMutableList()
                    tmp.removeAt(i)
                    if(isOK(tmp)){
                        ret = true
                        break
                    }
                }
                if(!ret){
                    answer--
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
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
""".trimIndent()

println(Day2.partOne(processInput(input)))
println(Day2.partTwo(processInput(input)))

