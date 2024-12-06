object Day3 {
    val MUL_REG_EXP = Regex("(mul\\(\\d+,\\d+\\))")
    val GET_NUMBER_REG_EXP = Regex("\\d+,\\d+")
    val DO_REG_EXP = Regex("(do\\(\\))")
    val DO_NOT_REG_EXP = Regex("(don't\\(\\))")

    fun doMul(str: String): Int {
        return GET_NUMBER_REG_EXP.find(str)!!.value.split(",").run {
            this[0].toInt() * this[1].toInt()
        }
    }

    fun partOne(input: String): Int {
        var answer = 0
        MUL_REG_EXP.findAll(input)
            .forEach { str ->
                answer += doMul(str.value)
            }
        return answer
    }

    fun getMatchLastIdxs(regex: Regex, input: String): List<Int> {
        return regex.findAll(input).map { it.range.last }.toList()
    }

    data class AbleRange(
        val range: IntRange,
        val ableToMul: Boolean
    )

    fun buildAbleRanges(doIdxList: List<Int>, doNotIdxList: List<Int>, len: Int): List<AbleRange> {
        val result = mutableListOf<AbleRange>()
        var doIdx = 0
        var doNotIdx = 0
        var wasBeforeAble = true
        while (true) {
            if (doIdx !in doIdxList.indices || doNotIdx !in doNotIdxList.indices) {
                break
            }

            if (doIdxList[doIdx] < doNotIdxList[doNotIdx]) {
                result += AbleRange(doIdxList[doIdx]..doNotIdxList[doNotIdx], true)
                doIdx++
                wasBeforeAble = true
            } else if (doIdxList[doIdx] > doNotIdxList[doNotIdx]) {
                result += AbleRange(doNotIdxList[doNotIdx]..doIdxList[doIdx], false)
                doNotIdx++
                wasBeforeAble = false
            }

        }

        result += result.last().run {
            AbleRange(
                range = this.range.last..len,
                !wasBeforeAble
            )
        }
        return result
    }

    fun List<AbleRange>.isAbleToMul(pos: Int): Boolean {
        return this.find {
            it.range.contains(pos)
        }!!.ableToMul
    }

    fun partTwo(input: String): Int {
        var answer = 0
        val doAfter = listOf(0) + getMatchLastIdxs(DO_REG_EXP, input)
        val doNotAfter = getMatchLastIdxs(DO_NOT_REG_EXP, input)

        val aRList = buildAbleRanges(doAfter, doNotAfter, input.length)



        MUL_REG_EXP.findAll(input)
            .forEach { str ->
                aRList.isAbleToMul(str.range.first).also {
                    if (it) answer += doMul(str.value)
                }

            }
        return answer
    }

}

