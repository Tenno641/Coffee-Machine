var water = 400
var milk = 540
var coffee = 120
var disposableCups = 9
var cash = 550

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    when (readln()) {
        "1" -> { water -= 250; coffee -= 16; cash += 4 }
        "2" -> { water -= 350; milk -= 75; coffee -= 20; cash += 7 }
        "3" -> { water -= 200; milk -= 100; coffee -= 12; cash += 6 }
    }
    disposableCups--
}

fun fill() {
    println("Write how many ml of water you want to add:")
    water += readln().toInt()

    println("Write how many ml of milk you want to add:")
    milk += readln().toInt()

    println("Write how many grams of coffee beans you want to add: ")
    coffee += readln().toInt()

    println("Write how many disposable cups you want to add: ")
    disposableCups += readln().toInt()
}

fun take() {
    println("I gave you $$cash")
    cash = 0
}

fun showingMachineStats() {
    println("""
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $coffee g of coffee beans
        $disposableCups disposable cups
        $$cash of money
    """.trimIndent())
}

fun main() {
    showingMachineStats()

    println("Write action (buy, fill, take): ")
    when (readln()) {
        "buy" -> { buy() }
        "fill" -> { fill() }
        "take" -> { take() }
    }

    showingMachineStats()
}