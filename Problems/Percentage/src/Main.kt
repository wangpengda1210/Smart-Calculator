fun main() {
    val first = readLine()!!.toBigInteger()
    val second = readLine()!!.toBigInteger()
    
    val sum = first + second
    
    print("${first * 100.toBigInteger() / sum}% ${second * 100.toBigInteger() / sum}%")
}