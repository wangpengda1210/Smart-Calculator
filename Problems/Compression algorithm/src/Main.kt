fun main() {
    val input = readLine()!!
    
    if (input.isEmpty()) {
        print("")
        return
    }
    
    var currentChar = input.first()
    var currentCount = 0
    var result = input.first().toString()
    
    for (char in input) {
        if (char == currentChar) currentCount++
        else {
            result += currentCount
            result += char
            currentCount = 1
            currentChar = char
        }
    }
    
    print(result + currentCount)
}