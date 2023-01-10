package signature

import java.io.File
import java.util.*

fun main() {
    print("Enter name and surname: ")
    val name = readln()
    print("Enter person's status: ")
    val status =  readln()
    getSignature(name, status)
}

fun getSignature(name: String, status: String) {
    val roman = Fonts(File("src/roman.txt"))
    val medium = Fonts(File("src/medium.txt"))

    val nameLn = getLine(roman, name)
    val nameLen = nameLn?.get(0)?.length
    val statusLn = getLine(medium, status)
    val statusLen = statusLn?.get(0)?.length

    val asteriskLine = { println("8".repeat((nameLen?.let { statusLen?.let { it1 -> maxOf(it, it1) } }
        ?.plus(Fonts.indent * 2)!!) + 4)) }

    fun statusIndent(right: Boolean = false): String {
        val ind = maxOf(nameLen!! - statusLen!! + Fonts.indent * 2, Fonts.indent * 2)
        return " ".repeat(ind / 2 + if (right) ind % 2 else 0)
    }

    fun fontIndent(right: Boolean = false): String {
        val ind = statusLen!! - nameLen!!
        return " ".repeat(maxOf(Fonts.indent, ind / 2 + Fonts.indent + if (right) ind % 2 else 0))
    }

    asteriskLine()
    nameLn!!.forEach { println("88${fontIndent()}$it${fontIndent(true)}88") }
    statusLn!!.forEach { println("88${statusIndent()}$it${statusIndent(true)}88") }
    asteriskLine()
}

fun getLine(font: Fonts, str: String): Array<String?>? {
    val size = font.letters['a']?.size
    val line = size?.let { List(it) { mutableListOf<CharSequence>() } }
    for (ch in str) {
        if (ch == ' ') line!!.forEach { font.space.let { it1 -> it.add(it1) } } else
            font.letters[ch].run { line!!.forEachIndexed { i, ln -> font.letters[ch]?.get(i)?.let { ln.add(it) } } }
    }
    return size?.let { Array(it) { i -> line?.get(i)?.joinToString("") } }
}

class Fonts(file: File) {
    val letters = with(Scanner(file)) {
        val linesPer = nextInt()
        val charsIn = nextInt()
        List<Pair<Char, List<CharSequence>>>(charsIn) {
            Pair(next().single().also { nextLine() }, List(linesPer) { nextLine() }) }.toMap()
    }
    val space: String = letters['a']?.get(0)?.length.let { " ".repeat(it!!) }

    companion object {
        const val indent = 2
    }
}