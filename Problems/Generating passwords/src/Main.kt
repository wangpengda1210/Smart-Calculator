import kotlin.random.Random

fun main() {
    val requirements = readLine()!!.split(" ")
    val uppercase = requirements[0].toInt()
    val lowercase = requirements[1].toInt() + uppercase
    val digit = requirements[2].toInt() + lowercase
    val length = requirements[3].toInt()
    
    val uppercaseList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowercaseList = uppercaseList.toLowerCase()
    val digitList = "0123456789"
    val totalList = uppercaseList + lowercaseList + digitList
    var password = ""
    var i = 1
    var last = ""
    
    while (i <= length) {
        password += when {
            i <= uppercase -> {
                uppercaseList[Random.nextInt(26)]
            }
            i <= lowercase -> {
                lowercaseList[Random.nextInt(26)]
            }
            i <= digit -> {
                digitList[Random.nextInt(10)]
            }
            else -> {
                totalList[Random.nextInt(62)]
            }
        }
        if (password[password.lastIndex].toString() == last) {
            password = password.substring(0, password.lastIndex)
            continue
        }
        else {
            last = password[password.lastIndex].toString()
            i++
        }
    }
    
    print(password)
    
}