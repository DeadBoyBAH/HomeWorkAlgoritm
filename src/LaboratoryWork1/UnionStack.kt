package LaboratoryWork1

class UnionStack {

    companion object {
        fun unionStacks(stack1: MyStack, stack2: MyStack): MyStack {
            val stack = MyStack()
            for (i in 0..stack1.pop) {
                stack.push(stack1.pop())
            }

            for (i in 0..stack2.pop) {
                stack.push(stack2.pop())
            }

            return stack.sort()
        }
    }
}