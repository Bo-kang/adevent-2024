object Day3{
    val MUL_REG_EXP= Regex("(mul\\(\\d+,\\d+\\))")
    val GET_NUMBER_REG_EXP = Regex("\\d+,\\d+")
    fun partOne(input:String): Int {
        var answer = 0
        MUL_REG_EXP.findAll(input)
            .also {
                println(it.count())
            }
            .forEach { str ->
                GET_NUMBER_REG_EXP.find(str.value)!!.value.split(",").also {
                    answer += it[0].toInt() * it[1].toInt()
                }
            }

        return answer
    }

}

