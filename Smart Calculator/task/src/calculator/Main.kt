package calculator

import java.lang.NumberFormatException
import java.math.BigInteger
import java.util.*
import kotlin.math.pow
import kotlin.reflect.typeOf

val variables = mutableMapOf<String, BigInteger>()

fun main() {
    var input = ""
    var exit = false
    
    while (!exit) {
    
        input = readLine()!!
        
        if (input == "") continue
        
        if (input.contains('=')) {
            try {
                assignValue(input)
            } catch (e: Exception) {
                println(e.message)
            }
            continue
        }
        
        if (input.first() == '/') {
            when (input) {
                "/exit" -> {
                    exit = true
                    println("Bye!")
                }
                "/help" -> println("The program calculates the sum of numbers")
                else -> println("Unknown command")
            }
            continue
        }
    
        val values = parseInput(input)
    
        try {
            println(calculateResult(values))
        } catch (e: EmptyStackException) {
            println("Invalid expression")
        } catch (e: Exception) {
            println(e.message)
        }
        
    }
    
}

fun parseInput(input: String): MutableList<String> {
    val values = mutableListOf<String>()
    var current = ""
    var couldBeMinus = false
    for (letter in input) {
        if (letter == ' ') continue
        if (current == "") {
            current = letter.toString()
            if (letter == '-') couldBeMinus = true
        } else if (letter.isDigit()) {
            if (current.all { it.isDigit() } || (current[0] == '-' && couldBeMinus)) {
                current += letter
            } else {
                values.add(current)
                current = letter.toString()
                couldBeMinus = false
            }
        } else if (letter.isLetter()) {
            if (current.all { it.isLetter() } || (current[0] == '-' && couldBeMinus)) {
                current += letter
            } else {
                values.add(current)
                current = letter.toString()
                couldBeMinus = false
            }
        } else if (Operator.findOperator(letter.toString()) != Operator.NULL) {
            if (current.first() == letter) {
                current += letter
                couldBeMinus = false
            } else {
                values.add(current)
                if (letter == '-' &&
                        Operator.findOperator(current[current.lastIndex].toString()) != Operator.NULL) couldBeMinus = true
                current = letter.toString()
            }
        } else if (letter == '(' || letter == ')')
        {
            values.add(current)
            current = letter.toString()
            couldBeMinus = false
        }
    }
    values.add(current)
    return values
}

fun infixToPostfix(values: List<String>): List<String> {

    val stack = Stack<String>()
    val postfixValues = mutableListOf<String>()

    for (value in values) {
        
        if (value.all { Operator.findOperator(it.toString()) != Operator.NULL }) {
            
            val operator = if (value.first() == '+') "+"
            else if (value.first() == '-') {
                if (value.length % 2 == 0) "+" else "-"
            } else {
                if (value.length > 1) throw Exception("Invalid expression")
                else value
            }
            
            if (stack.isEmpty() || stack.peek() == "(") {
                stack.push(operator)
                continue
            }
            
            while (stack.isNotEmpty() && Operator.findOperator(operator).precedence <=
                    Operator.findOperator(stack.peek()).precedence &&
                    stack.peek() != "(") {
                postfixValues.add(stack.pop())
            }
            
            stack.push(operator)
            
        }
        else if (value == "(") {
            stack.push(value)
        }
        else if (value == ")") {
            while (stack.peek() != "(") {
                postfixValues.add(stack.pop())
            }
            stack.pop()
        } else {
            postfixValues.add(value)
        }
        
    }
    
    while (!stack.isEmpty()) {
        val expression = stack.pop()
        if (expression == "(" || expression == ")") throw Exception("Invalid expression")
        postfixValues.add(expression)
    }
    
    return postfixValues

}

fun assignValue(input: String) {
    
    val parts = input.split("=")
    if (parts.size != 2) throw Exception("Invalid assignment")
    val name = parts[0].trim()
    val value = parts[1].trim()
    
    if (!isNameValid(name)) throw Exception("Invalid identifier")
    
    try {
        variables[name] = value.toBigInteger()
    } catch (e: NumberFormatException) {
        if (!isNameValid(value)) throw Exception("Invalid identifier")
        variables[name] = calculateResult(parseInput(value))
    }
    
}

fun calculateResult(values: List<String>): BigInteger {
    
    val postfixValues: List<String>
    try {
        postfixValues = infixToPostfix(values)
    } catch (e: Exception) {
        throw Exception("Invalid expression")
    }
    
    val stack = Stack<BigInteger>()
    
    for (value in postfixValues) {
        try {
            stack.push(value.toBigInteger())
        } catch (e: NumberFormatException) {
            when (Operator.findOperator(value)) {
                
                Operator.PLUS -> stack.push(stack.pop() + stack.pop())
                Operator.MINUS -> stack.push(-(stack.pop() - stack.pop()))
                Operator.MUL -> stack.push(stack.pop() * stack.pop())
                Operator.DIV -> {
                    val second = stack.pop()
                    stack.push(stack.pop() / second)
                }
                Operator.POWER -> {
                    val second = stack.pop()
                    stack.push(stack.pop().pow(second.toInt()))
                }
                Operator.NULL -> {
                    var minus = false
                    if (!isNameValid(value)) {
                        if (value.length > 1 && value.first() == '-' && isNameValid(value.substring(1, value.length))) {
                            minus = true
                        } else throw Exception("Invalid expression")
                    }
                    val valueToPush = if (minus) value.substring(1, value.length) else value
                    if (!variables.contains(valueToPush)) throw Exception("Unknown variable")
                    stack.push(if (minus) -variables[valueToPush]!! else variables[valueToPush])
                }
                
            }
        }
    }
    
    return stack.pop()
}

fun isNameValid(name: String) = name.all { it in 'a'..'z' || it in 'A'..'Z' }

enum class Operator(val symbol: String, val precedence: Int) {
    PLUS("+", 2),
    MINUS("-", 2),
    MUL("*", 3),
    DIV("/", 3),
    POWER("^", 4),
    NULL("", 1);
    
    companion object {
        fun findOperator(symbol: String): Operator {
            for (op in values()) {
                if (op.symbol == symbol) return op
            }
            return NULL
        }
    }
}
