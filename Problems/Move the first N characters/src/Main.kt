fun main() {
    val input = readLine()!!.split(" ")
    
    val string = input[0]
    val number = input[1].toInt()
    
    if (number > string.length) {
        print(string)
        return
    }
    
    var result = string.substring(number, string.length)
    
    print(result)
    
    for (i in 0 until number) print(string[i])
}