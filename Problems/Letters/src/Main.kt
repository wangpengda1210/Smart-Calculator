fun main() {
    val letters = mutableMapOf<Int ,String>()

    var letter = readLine()!!
    var i = 1
    while (letter != "z") {
        letters[i] = letter
        i++
        letter = readLine()!!
    }
    print(letters[4])
}