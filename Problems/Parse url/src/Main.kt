fun main() {
    val url = readLine()!!
    
    val parameters = url.split("?")[1].split("&")
    var pass: Int? = null
    for (parameter in parameters) {
        val key = parameter.split("=")[0]
        var value = parameter.split("=")[1]
        
        if (value == "") value = "not found"
        if (key == "pass") pass = value.toInt()
        println("$key : $value")
    }
    
    if (pass != null) println("password : $pass")
}