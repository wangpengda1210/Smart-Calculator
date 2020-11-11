fun main() {
    val word = readLine()!!
    var result = "yes"
    
    for (i in 0..word.length / 2) {
        if (word[i] != word[word.length - i - 1]) result = "no"
    }
    
    print(result)
}