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

    var currentPlayer = "Player 1"

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



