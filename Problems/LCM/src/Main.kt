fun main() {
    // write your code here
    val first = readLine()!!.toBigInteger()
    val second = readLine()!!.toBigInteger()
    val gcd = first.gcd(second)
    
    print(first * second / gcd)
}