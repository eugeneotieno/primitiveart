fun main() {
    val name = readln()
    val count = name.length + 4
    repeat(count) {
        print("*")
    }
    println()
    print("* ")
    print(name)
    println(" *")
    repeat(count) {
        print("*")
    }
}