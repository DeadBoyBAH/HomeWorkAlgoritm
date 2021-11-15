package LaboratoryWork1

fun main() {
    val stack1 = MyStack()
    val stack2 = MyStack()
    val stack = MyStack()

    val word = readLine()!!
    val word2 = readLine()!!

    for (element in word) {
        stack1.push(element)
    }

    for (element in word2) {
        stack2.push(element)
    }

    val unionStack = UnionStack.unionStacks(stack1, stack2)
    val sortStack = unionStack.sort()

    for (i in 0..sortStack.pop) {
        print("${sortStack.pop()} ")
    }
}

