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

class PeopleUseCase() {
    private val people = mutableListOf<String>()
    val se = SearchEngine(people)
    fun read() {
        println("Enter the number of people:")
        val peopleCount = readln().toInt()

        println("Enter all people")
        for (i in 1..peopleCount) {
            people.add(readln())
        }
    }

    fun find() {
        println("Enter a name or email to search all suitable people.")

        val query = readln()
        val resultQuery = se.search(query)

        if (resultQuery.isNotEmpty()) {
            println("People found:")
            resultQuery.map { println(it) }
        } else {
            println("No matching people found.")
        }
    }

    fun print() {
        println("\n=== List of people ===")

        people.map { println(it) }
    }
}

class CLI() {

    private val peopleUseCase = PeopleUseCase()

    fun menu() {
        peopleUseCase.read()

        do {
            println("\n=== Menu ===")
            println("1. Find a person")
            println("2. Print all people")
            println("0. Exit")

            val command = readln().toInt()

            when (command) {
                1 -> {
                    peopleUseCase.find()
                }
                2 -> {
                    peopleUseCase.print()
                }
                0 -> {
                    println("\nBye!\n")
                    break
                }
                else -> {
                    println("Incorrect option! Try again.")
                }
            }
        } while (command != 0)
    }
}

fun main(args: Array<String>) {
    val cli = CLI()

    cli.menu()
}