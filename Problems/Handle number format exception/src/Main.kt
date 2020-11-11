fun parseCardNumber(cardNumber: String): Long {
    // TODO
    val cardSegments = cardNumber.split(" ")
    if (cardSegments.size != 4) throw Exception("The card number should contain three spaces")
    
    var card = ""
    for (segment in cardSegments) card += segment
    if (!card.all { it.isDigit() }) throw Exception("Card number should only contain digits")
    return card.toLong()
}