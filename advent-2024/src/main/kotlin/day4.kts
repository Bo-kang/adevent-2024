object Day4{
    const val TARGET_WORD = "XMAS"
    const val BEGIN_LETTER = 'X'

    const val TARGET_WORD2 = "MAS"
    const val BEGIN_LETTER2 = 'M'

    enum class Direction(val i: Int, val j: Int) {
        U(-1, 0),
        UR(-1, +1),
        R(0, +1),
        DR(+1, +1),
        D(+1, 0),
        DL(+1, -1),
        L(0, -1),
        UL(-1, -1);
    }

    fun List<String>.isAvailDirection(dir: Direction,  curI: Int, curJ: Int, amount: Int = 1 ): Boolean {
        return (curI + dir.i * amount) >= 0
                && (curI + dir.i * amount) < this.size
                && (curJ + dir.j * amount) >= 0
                && (curJ + dir.j * amount) < this.first().length
    }

    fun isAbleToMakeWord(dir: Direction, input: List<String>, curI: Int, curJ: Int, targetWord: String = TARGET_WORD): Boolean {
        if(!input.isAvailDirection(dir, curI, curJ, targetWord.length - 1)){
            return false
        }

        for(i in targetWord.indices){
            if(input[curI + (dir.i * i)][curJ + (dir.j * i)] != targetWord[i]){
                return false
            }
        }

        return true
    }


    fun partOneSolution(input: List<String>): Int{
        var answer = 0

        input.forEachIndexed { i, it ->
            it.forEachIndexed { j, letter ->
                if(letter == BEGIN_LETTER){
                    Direction.entries.forEach { direction ->
                        if(isAbleToMakeWord(direction, input, i, j))
                            answer++
                    }
                }
            }
        }
        return answer
    }

    fun partTwoSolution(input: List<String>): Int{
        val tmp = mutableMapOf<Pair<Int, Int>, Int>()

        var answer = 0
        input.forEachIndexed { i, it ->
            it.forEachIndexed { j, letter ->
                if(letter == BEGIN_LETTER2){
                    Direction.entries.forEach { direction ->
                        if(direction.name.length > 1) {
                            if (isAbleToMakeWord(direction, input, i, j, TARGET_WORD2)){
                                if(tmp.contains(i+direction.i to j+direction.j))
                                    tmp[i+direction.i to j+direction.j] = 2
                                else
                                    tmp[i+direction.i to j+direction.j] = 1
                            }

                        }
                    }
                }
            }
        }

        tmp.forEach { (_, count) ->
            if(count == 2) answer++
        }

        return answer

    }
}


val testInput = listOf(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
)

println(Day4.partOneSolution(testInput))
println(Day4.partTwoSolution(testInput))

