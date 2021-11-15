package laboratorywork3

import java.lang.Exception

data class Deque(
    var first: Node? = null,
    var last: Node? = null,
    var size: Int = 0
) {

    fun insert(word: String) { // вставка в конец дека
        val node = Node(word)
        if (size == 0) {
            first = node
            last = node
            size += 1
        } else {
            last!!.next = node
            last = node
            size += 1
        }
    }

    fun insertFirst(word: String) { // метод добавления элемента в начало дека
        val node = Node(word)
        if (size == 0) {
            first = node
            last = node
            size += 1
        } else {
            node.next = first
            first = node
            size += 1
        }
    }

    fun removeFirst(): String { // возврат и удаление первого элемента из дека
        var value = ""
        when {
            size == 0 -> {
                throw Exception("Очередь пуста")
            }
            size > 1 -> {
                value = first!!.value
                first = first!!.next
                size -= 1
            }
            else -> {
                value = first!!.value
                size -=1
            }
        }

        return value
    }

    fun remove(): String { // возврат и удаление последнего элемента из дека
        var value = ""
        when (size) {
            0 -> {
                throw Exception("Очередь пуста")
            }
            else -> {
                value = last!!.value
                var currentNode = first
                for (i in 0 until size - 2) {
                    currentNode = currentNode!!.next
                }
                currentNode!!.next = null
                last = currentNode
                size -=1
            }
        }

        return value
    }

    fun isEmpty() = size == 0 // метод проверки на пустоту дека

    fun headValue(): String { // метод вывода первого элемента без его удаления
        if (size == 0) {
            throw Exception("Очередь пуста")
        } else {
            return first!!.value
        }
    }

    fun rearValue(): String { // метод вывода последнего элемента без его удаления
        if (size == 0) {
            throw Exception("Очередь пуста")
        } else {
            return last!!.value
        }
    }

    fun size() = size // размер дека

    fun clear() { // очистка дека
        first = null
        last = null
        size = 0
    }

    fun print(): String { // вывод дека в консоль
        var string = ""
        var currentNode = first
        for (i in 0 until size) {
            string += currentNode!!.value + " "
            currentNode = currentNode.next
        }
        return string
    }
}