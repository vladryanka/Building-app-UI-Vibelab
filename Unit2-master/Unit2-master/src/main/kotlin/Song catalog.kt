class Song(val title: String, val artist: String, val yearPublished: Int, val playCount: Int) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printSongDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

fun main() {
    val song1 = Song("Царица", "ANNA ASTI", 2024, 2000)
    val song2 = Song("Любодорого", "MARIA KON", 2022, 600)

    song1.printSongDescription()
    song2.printSongDescription()

    println("${song1.title} is popular: ${song1.isPopular}")
    println("${song2.title} is popular: ${song2.isPopular}")
}