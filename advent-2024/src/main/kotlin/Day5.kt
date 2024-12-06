object Day5{
    fun toOrderMap(inputOrders : List<String>, keyOrder : Int= 0, valueOrder : Int= 1): Map<Int, List<Int>>{
        return inputOrders
            .groupBy( keySelector = {
                it.split("|")[keyOrder].toInt()
            } )
            {
                it.split("|")[valueOrder].toInt()
            }
    }

    fun toUpdateList(inputUpdates: List<String>): List<List<Int>> {
        return inputUpdates
            .map {
                it.split(",")
                    .map {
                        it.toInt()
                    }
            }
    }

    fun List<Int>.getMiddleValue(): Int {
        return this[size/2]
    }

    class PartOne(
        inputOrders : List<String>,
        inputUpdates: List<String>
    ){
        val parentChildren = toOrderMap(inputOrders)
        val childParents = toOrderMap(inputOrders, 1, 0)
        val updates = toUpdateList(inputUpdates)

        fun solution(): Int {
            var answer = 0
            updates.forEach { updateOrder ->
                var before = updateOrder[0]
                var availableNext = parentChildren[before]
                var result = true
                for (i in 1 until updateOrder.size) {
                    val current = updateOrder[i]
                    if (availableNext != null && current in availableNext){
                        before = current
                        availableNext = parentChildren[before]
                    }
                    else {
                        result = false
                        break
                    }
                }
                if(result) {
                    answer += updateOrder.getMiddleValue()
                }
            }
            return answer
        }
    }

    class PartTwo(
        inputOrders : List<String>,
        inputUpdates: List<String>
    ){
        val parentChildren = toOrderMap(inputOrders)
        val childParents = toOrderMap(inputOrders, 1, 0)
        val updates = toUpdateList(inputUpdates)

        fun solution(): Int {
            var answer = 0
            updates.forEach { updateOrder ->
                var before = updateOrder[0]
                var availableNext = parentChildren[before]
                var result = true
                for (i in 1 until updateOrder.size) {
                    val current = updateOrder[i]
                    if (availableNext != null && current in availableNext!!){
                        before = current
                        availableNext = parentChildren[before]
                    }
                    else {
                        result = false
                        break
                    }
                }

                if(!result) {
                    updateOrder.sortedWith(comp)
                        .also {
                            answer += it.getMiddleValue()
                        }
                }
            }
            return answer
        }

        val comp = Comparator { a: Int, b: Int ->
            if(parentChildren[b]?.contains(a) == true) 1
            else -1
        }
    }



}

val inputOrders = listOf(
    "47|53",
    "97|13",
    "97|61",
    "97|47",
    "75|29",
    "61|13",
    "75|53",
    "29|13",
    "97|29",
    "53|29",
    "61|53",
    "97|53",
    "61|29",
    "47|13",
    "75|47",
    "97|75",
    "47|61",
    "75|61",
    "47|29",
    "75|13",
    "53|13"
)

val inputUpdates = listOf(
    "75,47,61,53,29",
    "97,61,53,29,13",
    "75,29,13",
    "75,97,47,61,53",
    "61,13,29",
    "97,13,75,29,47"
)

