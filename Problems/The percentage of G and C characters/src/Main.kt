fun main() {
    val sequence = readLine()!!.toLowerCase()
    var count = 0
    
    for (char in sequence) {
        if (char in "gc") count++
    }
    
    print(count.toDouble() / sequence.length * 100)
}