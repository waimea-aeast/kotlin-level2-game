/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Pinned game DTD
 * Project Author: Astin East
 * GitHub Repo:    https://github.com/waimea-aeast/kotlin-level2-game
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */

val spaces = mutableListOf<String?>()
fun main() {

    println("=== GAME INSTRUCTIONS ===")
    println("Move counters to the left.")
    println("You cannot jump over other counters.")
    println("You can remove a counter from square 1.")
    println("Whoever removes the BLACK (x) counter wins.")
    println("=========================\n")

    print("Enter Player 1 name: ")
    val player1 = readln()

    print("Enter Player 2 name: ")
    val player2 = readln()

    createSpaces()
    showSpaces()

    var currentPlayer = player1

    while (true) {
        println("\n$currentPlayer's turn")

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
    //place 4 white counters
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
    val from = readln().toInt() - 1

    //Where you're moving it to
    print("Move it to: ")
    val to = readln().toInt() - 1

    //Basic checks
    if (from !in 0..15 || to !in 0..15) continue


    //Cant move to empty space
    if (spaces[from] == " ") {
        println("No piece there")
        continue
    }

    //destination must be empty
    if (spaces[to] != " ") {
        println("Space is not empty")
        continue
    }

    // only allow moving left
    if (to >= from) {
        println("You can only move left")
        continue
    }

    // check spaces in between
        var blocked = false
    for (i in (to + 1)..(from - 1)) {
        if (spaces[i] != " ") {
            blocked = true
        }
    }
        if (blocked) {
            println("Blocked!")
            continue
        }

        // move piece
        spaces[to] = spaces[from]
        spaces[from] = " "
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



