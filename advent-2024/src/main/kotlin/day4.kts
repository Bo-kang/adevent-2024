object Day4{
    const val TARGET_WORD = "XMAS"
    const val BEGIN_LETTER = 'X'
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

    fun List<String>.isAvailDirection(dir: Direction, amount: Int = 1, curI: Int, curJ: Int): Boolean {
        return (curI + dir.i * amount) >= 0
                && (curI + dir.i * amount) < this.size
                && (curJ + dir.j * amount) >= 0
                && (curJ + dir.j * amount) < this.first().length
    }

    fun isAbleToMakeWord(dir: Direction, input: List<String>, curI: Int, curJ: Int): Boolean {
        if(!input.isAvailDirection(dir, TARGET_WORD.length - 1, curI, curJ)){
            return false
        }

        for(i in 0 until TARGET_WORD.length){
            if(input[curI + (dir.i * i)][curJ + (dir.j * i)] != TARGET_WORD[i]){
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

