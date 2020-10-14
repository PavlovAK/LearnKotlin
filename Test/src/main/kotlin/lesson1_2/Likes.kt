package lesson1_2

fun likedPeoples (numberOfPeople: Int) {
    if (numberOfPeople  % 10 == 1) print("""

Понравилось $numberOfPeople человеку""".trimIndent())
    else print("""

Понравилось $numberOfPeople людям""".trimIndent())
}