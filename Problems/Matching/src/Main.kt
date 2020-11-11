fun main() {
    val first = readLine()!!.toBigInteger()
    val second = readLine()!!.toBigInteger()
    val third = readLine()!!.toBigInteger()
    
    var count = 0
    if (first == second) count++
    if (first == third) count++
    if (second == third) count++
    
    print(when (count) {
        1 -> 2
        else -> count
    })
}