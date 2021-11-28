package laboratorywork5

class Graph(
    var mas: Array<Array<Int?>> = Array(10) { Array(10) { 0 } },
    var vertexList: Array<Vertex?> = arrayOfNulls(10),
    var curN: Int = 0
) {

    fun addVertex(name: Char) {
        vertexList[curN++] = Vertex(name)
    }

    fun addEdge(start: Int, end: Int) {
        mas[start][end] = 1
    }

    fun getVertexToThis(v: Int, list: MutableSet<Char?> = mutableSetOf()): MutableSet<Char?> {
        for (i in 0 until 10) {
            if (mas[i][v] == 1) {
                list.add(vertexList[i]?.name)
                list.addAll(getVertexToThis(i, list))
            }
        }

        return list
    }

}