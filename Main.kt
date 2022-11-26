class SearchEngine(private val text: MutableList<String>) {

    private fun getIndex(word: String, line: String): Int {
        val listLine = line.split(" ")
        return listLine.indexOf(word)
    }



    fun findPosition(word: String, line: String): String {
        val index = getIndex(word, line)

        return if (index == -1) "Not found" else index.toString()
    }



    fun search(word: String): MutableList<String> {
        val found = mutableListOf<String>()

        for (line in text) {
            if (line.contains(word, ignoreCase = true)) {
                found.add(line)
            }
        }

        return found
    }
}

class CLI() {
    private val people = mutableListOf<String>()
    val se = SearchEngine(people)

    fun readPeople() {
        println("Enter the number of people:")
        val peopleCount = readln().toInt()

        println("Enter all people")
        for (i in 1..peopleCount) {
            people.add(readln())
        }
    }

    fun searchPeople() {
        println("Enter the number of search queries:")
        val queriesCount = readln().toInt()

        for (i in 1..queriesCount) {
            println("Enter data to search people")

            val query = readln()
            val resultQuery = se.search(query)

            if (resultQuery.isNotEmpty()) {
                println("People found:")
                for (person in resultQuery) {
                    println(person)
                }
            } else {
                println("No matching people found.")
            }
        }
    }
}

fun main(args: Array<String>) {
    val cli = CLI()

    cli.readPeople()
    cli.searchPeople()
}