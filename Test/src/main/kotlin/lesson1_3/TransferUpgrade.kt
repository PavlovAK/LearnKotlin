package lesson1_3

fun tranferUpgrade(typeOfPayment: String, sumOfTransfer: Int, sumOfTransferInMonth: Int): String {
    val sumOfTransferInPenny: Int = sumOfTransfer * 100
    if (sumOfTransferInMonth > 600_000) {
        return "Нельзя совершать переводы на сумму более 600.000 руб. в месяц"
    }
    else {
        when (typeOfPayment) {
            "Mastercard", "Maestro" -> {
                if (sumOfTransferInMonth < 75_000) {
                    return "Комиссия не взимается"
                } else {
                    val comission = sumOfTransferInPenny * 0.006 + 2_000
                    return "Комиссия за перевод составит ${comission.toInt()} копеек."
                }
            }
            "Visa", "Мир" -> {
                var comission = sumOfTransferInPenny * 0.0075
                if (comission > 3_500) {
                    return "Комиссия за перевод составит ${comission.toInt()} копеек."
                } else {
                    comission = 3500.0
                    return "Комиссия за перевод составит ${comission.toInt()} копеек."
                }
            }
            "VK Pay" -> {
                if (sumOfTransferInMonth > 40_000) {
                    return "Нельзя совершать переводы на сумму более 40.000 руб. в месяц"
                } else {
                    if (sumOfTransfer > 15_000) {
                        return "Нельзя совершить перевод на сумму более 15.000 руб."
                    } else {
                        return "Комиссия не взимается"
                    }
                }
            }
        }
    }
    return "Ошибка. Что-то пошло не так(("
}