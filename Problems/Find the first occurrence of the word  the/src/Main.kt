fun main() {
    // write your code here
    val sentence = readLine()!!
    val parts = sentence.toLowerCase().split("the")
    
    if (parts.size == 1) print(-1)
    else print(parts[0].length)
}