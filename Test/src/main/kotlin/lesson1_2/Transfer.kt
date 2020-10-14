package lesson1_2

fun tranfer (sumOfTransfer: Int) {
    var sumOfTransferInPenny: Int = sumOfTransfer * 100
    if (sumOfTransferInPenny / 100 * 0.75 > 3500) {
        var comission: Double = sumOfTransferInPenny * 0.75
        print("""
            
Комиссия составит ${comission.toInt()} копеек.
        """.trimIndent())
    }
    else print("""
            
Комиссия составит 3500 копеек.
        """.trimIndent())
}