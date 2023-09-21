fun main() {
    var temp: String
    val card_numbers: MutableList<Long> = mutableListOf()
    println("Welcome to credit card validator!\n")
    do {
        print("Enter your credit card: ")
        temp = readln()
    }while (temp.toLong() < 0)

    for (i in temp.indices) {
        card_numbers.add(temp[i].toString().toLong())
    }
    println("The credit card is ${cardState(card_numbers)} and is type ${cardType(card_numbers)}.")
}

fun cardType(numbers: MutableList<Long>): String {
    if(numbers[0].toInt() == 4 && (numbers.size == 13 || numbers.size == 16)) return "VISA"
    if (numbers[0].toInt() == 3 && numbers[1].toInt() == 4 && (numbers.size == 15)) return "AMERICAN EXPRESS"
    if (numbers[0].toInt() == 3 && numbers[1].toInt() == 7 && (numbers.size == 15)) return "AMERICAN EXPRESS"
    if (numbers[0].toInt() == 5 && numbers[1].toInt() == 1 && (numbers.size == 16)) return "MASTERCARD"
    if (numbers[0].toInt() == 5 && numbers[1].toInt() == 2 && (numbers.size == 16)) return "MASTERCARD"
    if (numbers[0].toInt() == 5 && numbers[1].toInt() == 3 && (numbers.size == 16)) return "MASTERCARD"
    if (numbers[0].toInt() == 5 && numbers[1].toInt() == 4 && (numbers.size == 16)) return "MASTERCARD"
    if (numbers[0].toInt() == 5 && numbers[1].toInt() == 5 && (numbers.size == 16)) return "MASTERCARD"
    return "NONE"
}

fun cardState(numbers: MutableList<Long>): String {
    // Step 2
    var numTwo = ""
    var sumTwo: Long = 0
    for (i in numbers.size-2 downTo 0 step 2) {
        numTwo += (numbers[i] * 2)
    }
    for (i in numTwo.indices){
        sumTwo += numTwo[i].toString().toLong()
    }

    // Step 1
    var numOne = ""
    var sumOne: Long = 0
    for (i in numbers.size-1 downTo 0 step 2) {
        numOne += numbers[i]
    }
    for (i in numOne.indices){
        sumOne += numOne[i].toString().toLong()
    }

    if((sumOne+sumTwo).mod(10) == 0) return "valid"
    return "invalid"
}