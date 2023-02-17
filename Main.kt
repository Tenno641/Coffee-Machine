import kotlin.system.exitProcess

var water = 400
var milk = 540
var coffee = 120
var disposableCups = 9
var cash = 550

var possibleEspresso =  minOf(water / 250, coffee / 16)
var possibleLatte = minOf(water / 350, milk / 75, coffee / 20)
var possibleCappuccino = minOf(water / 200, milk / 100, coffee / 12)

fun checking(drink: Char): String {
    when (drink) {
        '1' -> {
            if(water / 250 == 0) { return "water" }
            if(coffee / 16 == 0) { return "coffee" }
        }

        '2' -> {
            if(water / 350 == 0) { return "water" }
            if(milk / 75 == 0) { return "milk" }
            if(coffee / 20 == 0) { return "coffee" }
        }

        '3' -> {
            if(water / 200 == 0) { return "water" }
            if(milk / 100 == 0) { return "milk" }
            if(coffee / 12 == 0) { return "coffee" }
        }
    }
    return "we're good!"
}

fun menu() {
    possibleEspresso =  minOf(water / 250, coffee / 16)
    possibleLatte = minOf(water / 350, milk / 75, coffee / 20)
    possibleCappuccino = minOf(water / 200, milk / 100, coffee / 12)

    println("Write action (buy, fill, take, remaining, exit):")
    when (readln()) {
        "buy" -> { buy() }
        "fill" -> { fill() }
        "take" -> { take() }
        "remaining" -> { remaining() }
        "exit" -> { exitProcess(0) }
    }
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    when (readln()) {
        "1" -> {
            if(possibleEspresso >= 1) { water -= 250; coffee -= 16; cash += 4; disposableCups--; possibleEspresso--; println("I have enough resources, making you a coffee!"); menu() }
            else { println("Sorry, not enough ${checking('1')}!") }
        }

        "2" -> {
            if(possibleLatte >= 1) { water -= 350; milk -= 75; coffee -= 20; cash += 7; disposableCups--; possibleLatte--; println("I have enough resources, making you a coffee!"); menu() }
            else { println("Sorry, not enough ${checking('2')}!") }
        }

        "3" -> {
            if(possibleCappuccino >= 1) { water -= 200; milk -= 100; coffee -= 12; cash += 6; disposableCups--; possibleCappuccino--; println("I have enough resources, making you a coffee!"); menu() }
            else { println("Sorry, not enough ${checking('3')}!") }
        }
        else -> { menu() }
    }
    menu()
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

    menu()
}

fun take() {
    println("I gave you $$cash")
    cash = 0
    menu()
}

fun remaining() {
    showingMachineStats()
    menu()
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
    menu()
}