import lesson1_2.discount
import lesson1_3.convertTime

fun main() {
//    convertTime(50)
//    convertTime(3_500)
//    convertTime(40_800)
//    convertTime(100_000)
    discount(100, 100, true)
    discount(10000, 1_000, true)
    discount(100, 100_000, true)
    discount(100, 100, false)
    discount(100, 1_000, false)
    discount(100, 100_000, false)
}