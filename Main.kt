package search

class SearchEngine() {
    private fun getIndex(word: String, line: String): Int {
        val listLine = line.split(" ")
        val index = listLine.indexOf(word)

        return if (index >= 0) index + 1 else -1
    }

    fun find(word: String, line: String): String {
        val index = getIndex(word, line)

        return if (index == -1) "Not found" else index.toString()
    }
}

fun main() {
    val se = SearchEngine()

    val line = readln()
    val word = readln()

    println(se.find(word, line))
}