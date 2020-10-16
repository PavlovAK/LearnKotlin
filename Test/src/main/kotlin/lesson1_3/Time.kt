package lesson1_3

fun convertTime (seconds: Int) {
    var hours = seconds / 3600
    var minutes = seconds / 60
    when (seconds) {
        in 0..59 -> print("""

был(а) в сети только что """.trimIndent())
        in 60..3_599 -> if (minutes % 10 == 1) {
            print("""

был(а) в сети $minutes минуту назад""".trimIndent())
        }
        else if (minutes % 11 == 1 || minutes % 12 == 1 || minutes % 13 == 1) {
            print("""

был(а) в сети $minutes минуты назад""".trimIndent())
        }
        else {
            print("""

был(а) в сети $minutes минут назад""".trimIndent())
        }
        in 3_600..86_399 -> when (seconds) {
            in 3_600..7_199 -> print("""

был(а) в сети 1 час назад""".trimIndent())
            in 7_200..14_399 -> print("""

был(а) в сети $hours часа назад """.trimIndent())
            in 14_400..71_999 -> print("""

был(а) в сети $hours часов назад """.trimIndent())
            in 72_000..75_599 -> print("""

был(а) в сети $hours час назад""".trimIndent())
            in 76_600..86_399 -> print("""

был(а) в сети $hours часа назад """.trimIndent())
        }
        in 86_400..172_799 -> print("""

был(а) в сети сегодня""".trimIndent())
        in 172_800..259_199 -> print("""

был(а) в сети вчера""".trimIndent())
        else -> print("""

давно не был(а) в сети""".trimIndent())
    }
}