/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Pinned game DTD
 * Project Author: Astin East
 * GitHub Repo:    https://github.com/waimea-aeast/kotlin-level2-game
 * ---------------------------------------------------------------------
 * Notes:
 * Fix code not taking null answers
 * =====================================================================
 */

val spaces = mutableListOf<String?>()
fun main() {

    println("====== PINNED =======")
    println()

    println("=== GAME INSTRUCTIONS ===")
    println("Move counters to the left.")
    println("You cannot jump over other counters.")
    println("You can remove a counter from square 1.")
    println("Whoever removes the BLACK (x) counter wins.")
    println("=========================")

    print("Enter Player 1 name: ")
    val player1 = readln()

    print("Enter Player 2 name: ")
    val player2 = readln()

    createSpaces()
    showSpaces()

    var currentPlayer = player1

    while (true) {
        println("$currentPlayer's turn")

        println("Choose action:")
        println("1. Move a counter")
        println("2. Remove counter from square one")

        when (readln()) {
            "1" -> moveCounter()
            "2" -> {
                if (spaces[0] == " ") {
                    println("Nothing there")
                    continue
                }

                if (removeCounter()) {
                    println("$currentPlayer wins!")
                    break
                }
            }
        }

        showSpaces()
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }
}

fun createSpaces() {
    for (i in 1..16) {
        spaces.add(" ")
    }
    //places 4 white counters
    repeat(4){
        while (true) {
            val whiteSpace = (0..15).random()
            if (spaces[whiteSpace] == " ") {
                spaces[whiteSpace] = "  o"
                break
            }
        }
    }
    while (true){
        val blackSpace = (0..15).random()
        if (spaces[blackSpace] == " ") {
            spaces[blackSpace] = "  x"
            break
        }
    }
}

fun showSpaces() {
    //Prints square number and keeps spacing equal
    for (i in 1..16) {
        if (i < 10) print("    #$i   ")
        else print("   #$i   ")
    }

    println()
    print("┌────────")
    print("┬────────".repeat(spaces.size-1))
    println("┐")

    for (space in spaces){
        print("│ ${space?.padEnd(6)} ")
    }
    print("│")
    println()
    print("└────────")
    print("┴────────".repeat(spaces.size-1))
    println("┘")

}

fun moveCounter() {
    while (true) {
    //What counter you're moving
    print("Pick a position: ")
    val moveFrom = readln().toInt() - 1

    //Where you're moving it to
    print("Move it to: ")
    val moveTo = readln().toInt() - 1

    //Basic checks
    if (moveFrom !in 0..15 || moveTo !in 0..15) continue


    //Cant move to empty space
    if (spaces[moveFrom] == " ") {
        println("No piece there")
        continue
    }

    //destination must be empty
    if (spaces[moveTo] != " ") {
        println("Space is not empty")
        continue
    }

    // only allows moving left
    if (moveTo >= moveFrom) {
        println("You can only move left")
        continue
    }

    // checks spaces in between
        var blocked = false
    for (i in (moveTo + 1)..(moveFrom - 1)) {
        if (spaces[i] != " ") {
            blocked = true
        }
    }
        if (blocked) {
            println("Blocked!")
            continue
        }

        // move piece
        spaces[moveTo] = spaces[moveFrom]
        spaces[moveFrom] = " "
        break
    }
}


fun removeCounter(): Boolean {
    if (spaces[0] == " ") {
        println("Nothing there")
        return false
    }

    val piece = spaces[0]
    spaces[0] = " "

    return piece == "  x"
}



