fun main() {
    // write your code here
    val word = readLine()!!
    val vowels = "aeiouy"
    val neighboursList = mutableListOf<Int>()
    
    var vowelNeighbourCount = 0
    var consonantNeighbourCount = 0
    
    for (letter in word) {
        if (letter in vowels) {
            if (consonantNeighbourCount >= 3) neighboursList.add(consonantNeighbourCount)
            consonantNeighbourCount = 0
            vowelNeighbourCount++
        } else {
            if (vowelNeighbourCount >= 3) neighboursList.add(vowelNeighbourCount)
            vowelNeighbourCount = 0
            consonantNeighbourCount++
        }
    }
    
    if (vowelNeighbourCount >= 3) neighboursList.add(vowelNeighbourCount)
    if (consonantNeighbourCount >= 3) neighboursList.add(consonantNeighbourCount)
    
    var result = 0
    for (neighbour in neighboursList) {
        result += (neighbour - 1) / 2
    }
    
    print(result)
    
}