const val WATER = 200
const val MILK = 50
const val COFFEE = 15

fun main() {
    println("Write how many cups of coffee you will need:")
    val cupsOfCoffee = readln().toInt()
    println("""
        for $cupsOfCoffee of coffee you will need:
        ${cupsOfCoffee * WATER} ml of water
        ${cupsOfCoffee * MILK} ml of milk
        ${cupsOfCoffee * COFFEE} g of coffee beans
    """.trimIndent())
}