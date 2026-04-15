/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: PROJECT AUTHOR HERE
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */

val spaces = mutableListOf<String?>()
fun main() {
    createSpaces()
    showSpaces()

    var currentPlayer = 1

    while (true) {
        println("\n$currentPlayer's turn")

        println("Choose action:")
        println("1. Move a counter")
        println("2. Remove counter from square one")

        when (readln()) {
            "1" -> moveCounter()
            "2" -> {
                if (removeCounter()) {
                    println("$currentPlayer wins! 🎉")
                    break
                }
            }
        }

        showSpaces()
        currentPlayer = if (currentPlayer == 1) 2 else 1
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
    //What counter you're moving
    print("Pick a position: ")
    val from = readln().toInt() - 1

    //Where you're moving it to
    print("Move it to: ")
    val to = readln().toInt() - 1

    //Basic checks
    if (from !in 0..15 || to !in 0..15) return
    if (spaces[from] == " " || spaces[to] != " ") return

    // only allow moving left
    if (to >= from) {
        println("You can only move left")
        return
    }

    // check spaces in between
    for (i in (to + 1)..(from - 1)) {
        if (spaces[i] != " ") {
            println("Blocked!")
            return
        }

    // move piece
    spaces[to] = spaces[from]
    spaces[from] = " "
}
}

fun removeCounter(): Boolean {
    if (spaces[0] == " ") {
        println("Nothing there")
        return false
    }

    val piece = spaces[0]
    spaces[0] = " "

    return piece == "x"
}



