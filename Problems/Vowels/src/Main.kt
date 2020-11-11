fun main() {
    val letter = readLine()!!.toLowerCase()
    
    val vowelPositions = mutableMapOf("a" to 1, "e" to 5,
            "i" to 9, "o" to 15, "u" to 21)
    
    print(if (vowelPositions.containsKey(letter)) vowelPositions[letter] else 0)
}