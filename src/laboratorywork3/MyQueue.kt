package laboratorywork3

class MyQueue(
    private val list: MutableList<String> = mutableListOf() // список фамилий
) {

    fun insert(value: String) = list.add(value) // добавление элемента в конец очереди

    fun remove() = list.removeLast() // исключение элемента из начала очереди и возвращение его значения

    fun isEmpty() = list.isEmpty() // проверка очереди на пустоту

    fun headValue() = list.first() // считывание первого элемента без его удаления

    fun rearValue() = list.last() // считывание последнего элемента без его удаления

    fun size() = list.size // определение числа элементов в очереди

    fun clear() = list.clear() // очистка очереди

    fun print() = list.toString() // вывод элементов

}