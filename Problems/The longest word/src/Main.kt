fun main() {
    // write your code here
    val words = readLine()
    val wordsList = words!!.split(" ")
    
    var longest = ""
    var longestLength = 0
    
    for (word in wordsList) {
        if (word.length > longestLength) {
            longest = word
            longestLength = word.length
        }
    }
    
    print(longest)
}