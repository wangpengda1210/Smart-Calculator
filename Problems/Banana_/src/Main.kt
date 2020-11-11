fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    
    strings.replaceAll { it ->
        when (it) {
            str -> "Banana"
            else -> it
        }
    }
    
    return strings
    
}