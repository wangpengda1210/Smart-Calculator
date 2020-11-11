fun main(args: Array<String>) {
    // put your code here
    val numbers = readLine()!!.split(" ")
    if (numbers[1].toInt() == 0) print("Division by zero, please fix the second argument!")
    else print(numbers[0].toInt() / numbers[1].toInt())
}