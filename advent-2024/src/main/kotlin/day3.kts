object Day3{
    val MUL_REG_EXP= Regex("(mul\\(\\d+,\\d+\\))")
    val GET_NUMBER_REG_EXP = Regex("\\d+,\\d")
    fun partOne(input:String): Int {
        var answer = 0
        MUL_REG_EXP.findAll(input)
            .also {
                println(it.count())
            }
            .forEach { str ->
                GET_NUMBER_REG_EXP.find(str.value)!!.value.split(",").also {
                    println("${str.value} :  ${it[0].toInt()} * ${it[1].toInt()} = ${it[0].toInt() * it[1].toInt()}")
                    answer += it[0].toInt() * it[1].toInt()
                }
            }

        return answer
    }

}

val input = """
xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
""".trimIndent()

Day3.partOne(input)