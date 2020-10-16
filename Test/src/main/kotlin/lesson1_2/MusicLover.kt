package lesson1_2
fun discount(purchaseAmount: Int, balanceOfPurchase: Int, regularCustomer: Boolean) {
    var result = 0
    var resultTwo = 0
    if (regularCustomer) {
        when (balanceOfPurchase) {
            in 0..999 -> {
                result = purchaseAmount - (purchaseAmount / 100)
                print(
                        """
                Сумма покупок составила $purchaseAmount, с учетом скидки $result. Скидка 1%, как постоянному покупателю.
            """.trimIndent()
                )
            }
            in 1000..9_999 -> {
                result = purchaseAmount - 100 - (purchaseAmount / 100)
                print(
                        """
                Сумма покупок составила $purchaseAmount, с учетом скидок $result.
                Скидки: 1%, как постоянному покупателю, и 100 руб. за общую сумму покупок более 1000 руб.
                Спасибо, что вы с нами!
            """.trimIndent()
                )
            }
            else -> {
                result = purchaseAmount - (purchaseAmount / 100 * 5)
                resultTwo = result - (result / 100)
                print(
                        """
                Сумма покупок составила $purchaseAmount, с учетом скидок $resultTwo.
                Скидки: 1%, как постоянному покупателю, и 5% за общую сумму покупок более 10.000 руб.
                Спасибо, что вы с нами!
            """.trimIndent()
                )
            }
        }
    } else {
        when (balanceOfPurchase) {
            in 0..999 -> print(
                    """
                Сумма покупок составила $purchaseAmount, Скидки нет.
            """.trimIndent()
            )
            in 1000..9_999 -> {
                result = purchaseAmount - 100
                print(
                        """
                Сумма покупок составила $purchaseAmount, с учетом скидок $result.
                Скидка 100 руб. за общую сумму покупок более 1000 руб.
                Спасибо, что вы с нами!
            """.trimIndent()
                )
            }
            else -> {
                result = purchaseAmount - (purchaseAmount / 100 * 5)
                print(
                        """
                Сумма покупок составила $purchaseAmount, с учетом скидок $result.
                Скидка 5% за общую сумму покупок более 10.000 руб.
                Спасибо, что вы с нами!
            """.trimIndent()
                )
            }
        }
    }
}