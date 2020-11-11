fun main() {
    val input = readLine()!!
    
    if (input.isEmpty()) return
    
    if (input.length % 2 == 0) {
        print(input.substring(0, input.length / 2 - 1) + input.substring(input.length / 2 + 1, input.length))
    }
    else {
        print(input.substring(0, input.length / 2) + input.substring(input.length / 2 + 1, input.length))
    }
}