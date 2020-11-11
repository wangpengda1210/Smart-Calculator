fun main() {
    val string = readLine()!!
    val substring = readLine()!!
    
    print(string.split(substring).size - 1)
}