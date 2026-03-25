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
}

fun createSpaces() {
    for (i in 1..16) {
        spaces.add(" ")
    }
   while (true){
        val whiteSpace = (0..15).random()
        if (spaces[whiteSpace] == " ") {
            spaces[whiteSpace] = "  o"
            break
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


//fix this next time
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



