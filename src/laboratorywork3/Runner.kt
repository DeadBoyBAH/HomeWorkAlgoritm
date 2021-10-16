package laboratorywork3

import java.io.BufferedReader
import java.io.File

fun main() {
    var bufferedReader: BufferedReader = File("laboratory3_1.txt").bufferedReader()
    var inputString = bufferedReader.use { it.readText()} // чтение данных из файла
    val families1 = inputString.split("\r\n") // деление текста на фамилии

    bufferedReader = File("laboratory3_2.txt").bufferedReader()
    inputString = bufferedReader.use { it.readText() } // чтение данных из файла 2
    val families2 = inputString.split("\r\n") // деление текста на фамилии

    val queue1 = MyQueue() // создание первой очереди
    val queue2 = MyQueue() // создание второй очереди
    families1.map { queue1.insert(it) } // добавление элементов в первую очередь
    families2.map { queue2.insert(it) } // добавление элементов во второую очередь

    println("Фамилии из первого файла: ${queue1.print()}") // вывод элементов из первой очереди
    println("Фамилии из второго файла: ${queue2.print()}") // вывод элементов из второй очереди

    val unionQueue = unionQueues(queue1, queue2) // создание объединенной очереди
    println("Объединенные фамилии: ${unionQueue.print()}") // вывод объединенной очереди

    File("laboratory3_result.txt").printWriter().use { out -> // запись фамилий в файл
        for (i in 0 until unionQueue.size()) {
            out.println(unionQueue.remove())
        }
    }


}

fun unionQueues(queue1: MyQueue, queue2: MyQueue): MyQueue { // метод для объединения очередей
    val unionQueue = MyQueue() // создаём объединённую очередь
    val length: Int = if (queue1.size() < queue2.size()) { // ищём минимальную очередь для итераций
        queue1.size()
    } else {
        queue2.size()
    }


    for (i in 0 until length) { // итерируемся по очередям и добавляем поочередно элементы в объединенную очередь
        unionQueue.insert(queue1.remove())
        unionQueue.insert(queue2.remove())
    }

    if (queue1.size() < queue2.size()) { // добавляем оставшиеся элементы из очереди, которая длиннее
        for (i in 0 until  queue2.size()) {
            unionQueue.insert(queue2.remove())
        }
    } else {
        for (i in 0 until queue1.size()) {
            unionQueue.insert(queue1.remove())
        }
    }

    return unionQueue
}