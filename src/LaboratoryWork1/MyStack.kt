package LaboratoryWork1

class MyStack(
    var pop: Int = -1,
    private var array: CharArray = CharArray(10)
) {

    fun push(symbol: Char) {
        if (array.size - 1 == pop) {
            val arrayHelper = array
            array = CharArray((pop * 1.5).toInt())
            for (i in arrayHelper.indices) {
                array[i] = arrayHelper[i]
            }
        }
        array[++pop] = symbol
    }

    fun pop() = array[pop].also {
        array[pop--] = ' '
    }

    fun isEmpty() = pop == -1

    fun top() = array[pop]

    fun length() = pop + 1

    fun sort(): MyStack {
        val oldStack = this
        val newStack = MyStack()
        newStack.push(oldStack.pop())
        var iterator = 0
        val length = oldStack.length()
        for (i in 1 until length + 1) {
            val oldEl = oldStack.pop()
            var newEl = newStack.pop()
            if (oldEl <= newEl) {
                newStack.push(newEl)
                newStack.push(oldEl)
            } else {
                iterator++
                oldStack.push(newEl)
                while (true) {
                    if (!newStack.isEmpty()) newEl = newStack.pop()
                    if (oldEl <= newEl) {
                        newStack.push(newEl)
                        newStack.push(oldEl)
                        while (iterator != 0) {
                            newStack.push(oldStack.pop())
                            iterator--
                        }
                        break
                    } else if (newStack.isEmpty()) {
                        newStack.push(oldEl)
                        newStack.push(newEl)
                        while (iterator != 0) {
                            newStack.push(oldStack.pop())
                            iterator--
                        }
                        break
                    } else {
                        iterator++
                        oldStack.push(newEl)
                    }
                }
            }
        }

        return newStack
    }
}