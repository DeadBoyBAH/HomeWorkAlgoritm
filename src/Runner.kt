fun main() {
    val stack = MyStack()

    val word = readLine()!!
    val word2 = readLine()!!

    for (element in word) {
        stack.push(element)
    }

    for (element in word2) {
        stack.push(element)
    }

    val sortStack = stack.sort()

    for (i in 0..sortStack.pop) {
        print("${sortStack.pop()} ")
    }
}

