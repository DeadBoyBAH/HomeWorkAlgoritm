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

    val queue1 = Deque() // создание первого дека
    val queue2 = Deque() // создание второго дека
    families1.map { queue1.insert(it) } // добавление элементов в первый дек
    families2.map { queue2.insert(it) } // добавление элементов во второй дек

    println("Фамилии из первого файла: ${queue1.print()}") // вывод элементов из первого дека
    println("Фамилии из второго файла: ${queue2.print()}") // вывод элементов из второго дека

    val unionQueue = unionDeques(queue1, queue2) // создание объединенного дека
    println("Объединенные фамилии: ${unionQueue.print()}") // вывод объединенного дека

    File("laboratory3_result.txt").printWriter().use { out -> // запись фамилий в файл
        for (i in 0 until unionQueue.size()) {
            out.println(unionQueue.remove())
        }
    }
}

fun unionDeques(deque1: Deque, deque2: Deque): Deque { // метод для объединения деков
    val unionQueue = Deque() // создаём объединённый дек
    val length: Int = if (deque1.size() < deque2.size()) { // ищём минимальный дек для итераций
        deque1.size()
    } else {
        deque2.size()
    }


    for (i in 0 until length) { // итерируемся по декам и добавляем поочередно элементы в объединенный дек
        unionQueue.insert(deque1.remove())
        unionQueue.insert(deque2.remove())
    }

    if (deque1.size() < deque2.size()) { // добавляем оставшиеся элементы из дека, который длиннее
        for (i in 0 until  deque2.size()) {
            unionQueue.insert(deque2.remove())
        }
    } else {
        for (i in 0 until deque1.size()) {
            unionQueue.insert(deque1.remove())
        }
    }

    return unionQueue
}