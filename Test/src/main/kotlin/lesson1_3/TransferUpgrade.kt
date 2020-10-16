package lesson1_3

fun tranferUpgrade(typeOfPayment: String, sumOfTransfer: Int, sumOfTransferInMonth: Int) {
    val sumOfTransferInPenny: Int = sumOfTransfer * 100
    if (sumOfTransferInMonth > 600_000) {
        print("Нельзя совершать переводы на сумму более 600.000 руб. в месяц")
    }
    else {
        when (typeOfPayment) {
            "Mastercard", "Maestro" -> {
                if (sumOfTransferInMonth < 75_000) {
                    print("Комиссия не взимается")
                } else {
                    val comission = sumOfTransferInPenny * (sumOfTransferInPenny / 100 * 0.6) + 2_000
                    print("Комиссия за перевод составит ${comission.toInt()} копеек.")
                }
            }
            "Visa", "Мир" -> {
                var comission = sumOfTransferInPenny * (sumOfTransferInPenny / 100 * 0.75)
                if (comission > 3_500) {
                    print("Комиссия за перевод составит ${comission.toInt()} копеек.")
                } else {
                    comission = 3500.0
                    print("Комиссия за перевод составит ${comission.toInt()} копеек.")
                }
            }
            "VK Pay" -> {
                if (sumOfTransferInMonth > 40_000) {
                    print("Нельзя совершать переводы на сумму более 40.000 руб. в месяц")
                } else {
                    if (sumOfTransfer > 15_000) {
                        print("Нельзя совершить перевод на сумму более 15.000 руб.")
                    } else {
                        print("Комиссия не взимается")
                    }
                }
            }
        }
    }
}