package laboratorywork3

class MyQueue2(
    var pop: Int = -1,
    private var array: Array<String?> = arrayOfNulls(10)
) {

    fun insert(word: String?) {
        if (array.size - 1 == pop) {
            val arrayHelper = array
            array = arrayOfNulls((pop * 1.5).toInt())
            for (i in arrayHelper.indices) {
                array[i] = arrayHelper[i]
            }
        }
        array[++pop] = word
    }

    fun push(word: String?) {
        if (array.size - 1 == pop) {
            val arrayHelper = array
            array = arrayOfNulls((pop * 1.5).toInt())
            array[0] = word
            for (i in arrayHelper.indices) {
                array[i + 1] = arrayHelper[i]
            }
        }
    }

    fun removeFirst() {
        val firstEl = array[0]
        val arrayHelper = array
        array = arrayOfNulls(pop - 1)
        for (i in 1 until arrayHelper.size) {
            array[i - 1] = arrayHelper[i]
        }
    }

    fun remove() = array[pop].also {
        array[pop--] = ""
    }

    fun isEmpty() = pop == -1

    fun headValue() = array[pop]

    fun rearValue() = array[0]

    fun clear() {
        array = arrayOfNulls(10)
    }

    fun size() = pop + 1

    fun print(): String {
        var string = ""
        for (i in array.indices) {
            if (array[i] != null) {
                string += array[i] + " "
            }
        }
        return string
    }
}