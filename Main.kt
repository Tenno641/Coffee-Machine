const val WATER = 200
const val MILK = 50
const val COFFEE = 15

fun main() {
    println("Write how many ml of water the coffee machine has:")
    val water= readln().toInt()

    println("Write how many ml of milk the coffee machine has:")
    val milk = readln().toInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    val coffee = readln().toInt()

    println("Write how many cups of coffee you will need:")
    val requiredCups = readln().toInt()

    val possibleCups = minOf(water / WATER, milk / MILK, coffee / COFFEE)

    if (requiredCups <= possibleCups) {
        if (requiredCups == possibleCups) { print("Yes, I can make that amount of coffee") } else { print("Yes, I can make that amount of coffee (and even ${possibleCups - requiredCups} more than that)") }
    } else { print("No, I can make only $possibleCups cups of coffee") }
}