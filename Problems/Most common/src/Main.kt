fun main() {
    val words = mutableMapOf<String, Int>()
    
    var word = readLine()!!
    while (word != "stop") {
        if (words.containsKey(word)) words[word] = words[word]!! + 1
        else words[word] = 1
        word = readLine()!!
    }
    
    var max = 0
    var maxWord: String? = null
    for ((key, value) in words) {
        if (value > max) {
            max = value
            maxWord = key
        }
    }

    print(maxWord)
}