fun main() {
    val input = readLine()!!
    
    var firstSum = 0
    var secondSum = 0
    
    for (i in 0 until input.length / 2) {
        firstSum += input[i].toInt()
    }
    
    for (i in input.length / 2..input.lastIndex) {
        secondSum += input[i].toInt()
    }
    
    print(if (firstSum == secondSum) "YES" else "NO")
}