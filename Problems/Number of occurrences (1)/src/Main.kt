fun solution(strings: List<String>, str: String): Int {
    var count = 0
    
    for (name in strings) {
        if (name == str) count++
    }
    
    return count
}