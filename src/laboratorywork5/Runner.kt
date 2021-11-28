package laboratorywork5

fun main() {
    val graph = Graph()

    graph.addVertex('A') // 0
    graph.addVertex('B') // 1
    graph.addVertex('C') // 2
    graph.addVertex('D') // 3
    graph.addVertex('E') // 4
    graph.addVertex('F') // 5
    graph.addVertex('G') // 6

    graph.addEdge(0, 1) // AB
    graph.addEdge(1, 2) // BC
    graph.addEdge(2, 3) // CD
    graph.addEdge(0, 4) // AE
    graph.addEdge(4, 5) // EF
    graph.addEdge(0, 6) // AG
    graph.addEdge(6, 5) // GF

    print(graph.getVertexToThis(5))
}