package lesson1_2

fun tranfer (sumOfTransfer: Int): String {
    val sumOfTransferInPenny: Int = sumOfTransfer * 100
    if (sumOfTransferInPenny / 100 * 0.75 > 3500) {
        val comission: Double = sumOfTransferInPenny * 0.75
        return "Комиссия составит ${comission.toInt()} копеек."
    }
    else return "Комиссия составит 3500 копеек."
}