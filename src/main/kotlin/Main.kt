fun main() {
    print("Enter name and surname: ")
    val fullName = readln().trim()
    print("Enter person's status: ")
    val status = readln().trim()

    var fullNameLength = 0
    val name = fullName.substringBefore(" ")
    fullNameLength += name.length * 4 + (name.length - 1)
    if (name.lowercase().contains("i")) fullNameLength -= 3
    if (name.lowercase().contains("j")) fullNameLength -= 2
    if (name.lowercase().contains("t")) fullNameLength -= 1
    if (name.lowercase().contains("w")) fullNameLength += 1
    if (name.lowercase().contains("y")) fullNameLength += 1

    fullNameLength += 6

    val surname = fullName.substringAfter(" ")
    fullNameLength += surname.length * 4 + (surname.length -1)
    if (surname.lowercase().contains("i")) fullNameLength -= 3
    if (surname.lowercase().contains("j")) fullNameLength -= 2
    if (surname.lowercase().contains("t")) fullNameLength -= 1
    if (surname.lowercase().contains("w")) fullNameLength += 1
    if (surname.lowercase().contains("y")) fullNameLength += 1

    var length = 6
    length += if (fullName.length > status.length) {
        fullNameLength
    } else {
        status.length
    }

    repeat(length) {
        print("*")
    }

    println()

    //name
    val firstSpaceName = (length - fullNameLength) / 2
    val secondSpaceName = (length - fullNameLength) - firstSpaceName - 1

    //row 1
    print("*")

    repeat(firstSpaceName - 1) {
        print(" ")
    }

    repeat(name.length) { index ->
        print(getFont(name[index].toString(), 1))
        print(" ")
    }

    print("     ")

    repeat(surname.length) { index ->
        print(getFont(surname[index].toString(), 1))
        print(" ")
    }

    repeat(secondSpaceName - 1) {
        print(" ")
    }

    print("*")

    println()

    //row 2
    print("*")

    repeat(firstSpaceName - 1) {
        print(" ")
    }

    repeat(name.length) { index ->
        print(getFont(name[index].toString(), 2))
        print(" ")
    }

    print("     ")

    repeat(surname.length) { index ->
        print(getFont(surname[index].toString(), 2))
        print(" ")
    }

    repeat(secondSpaceName - 1) {
        print(" ")
    }

    print("*")

    println()

    //row 3
    print("*")

    repeat(firstSpaceName - 1) {
        print(" ")
    }

    repeat(name.length) { index ->
        print(getFont(name[index].toString(), 3))
        print(" ")
    }

    print("     ")

    repeat(surname.length) { index ->
        print(getFont(surname[index].toString(), 3))
        print(" ")
    }

    repeat(secondSpaceName - 1) {
        print(" ")
    }

    print("*")

    println()

    //status
    print("*")

    val firstSpace = (length - status.length) / 2
    repeat(firstSpace - 1) {
        print(" ")
    }

    print(status)

    val secondSpace = (length - status.length) - firstSpace
    repeat(secondSpace - 1) {
        print(" ")
    }

    print("*")

    println()

    repeat(length) {
        print("*")
    }
}

fun getFont(letter: String, row: Int): String {
    val row1 = mutableListOf("____", "___ ", "____", "___ ", "____", "____", "____", "_  _", "_", " _", "_  _",
        "_   ", "_  _", "_  _", "____", "___ ", "____", "____", "____", "___", "_  _", "_  _", "_ _ _", "_  _",
        "_   _", "___ "
    )
    val row2 = mutableListOf("|__|", "|__]", "|   ", "|  \\", "|___", "|___", "| __", "|__|", "|", " |", "|_/ ",
        "|   ", "|\\/|", "|\\ |", "|  |", "|__]", "|  |", "|__/", "[__ ", " | ", "|  |", "|  |", "| | |", " \\/ ",
        " \\_/ ", "  / "
    )
    val row3 = mutableListOf("|  |", "|__]", "|___", "|__/", "|___", "|   ", "|__]", "|  |", "|", "_|", "| \\_",
        "|___", "|  |", "| \\|", "|__|", "|   ", "|_\\|", "|  \\", "___]", " | ", "|__|", " \\/ ", "|_|_|", "_/\\_",
        "  |  ", " /__"
    )

    val line = "abcdefghijklmnopqrstuvwxyz"
    val index = line.indexOf(letter.lowercase())

    return when(row) {
        1 -> {
            row1[index]
        }
        2 -> {
            row2[index]
        }
        else -> {
            row3[index]
        }
    }
}