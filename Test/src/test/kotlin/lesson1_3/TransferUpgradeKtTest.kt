package lesson1_3

import org.junit.Test

import org.junit.Assert.*

internal class TransferUpgradeKtTest {

    @Test
    fun transferUpgrade_overLimitInMonth() {
        val typeOfPayment = "Mastercard"
        val sumOfTransfer = 0
        val sumOfTransferInMonth = 600_001
        val message = "Нельзя совершать переводы на сумму более 600.000 руб. в месяц"

        assertEquals(message, tranferUpgrade(typeOfPayment, sumOfTransfer, sumOfTransferInMonth))
    }

    @Test
    fun transferUpgrade_beforeLimitInMonthMastercardandMaestro() {
        val typeOfPayment = "Mastercard"
        val sumOfTransfer = 100
        val sumOfTransferInMonth = 100
        val message = "Комиссия не взимается"

        assertEquals(message, tranferUpgrade(typeOfPayment, sumOfTransfer, sumOfTransferInMonth))
    }
    @Test
    fun transferUpgrade_overLimitInMonthMastercardAndMaestro() {
        val typeOfPayment = "Mastercard"
        val sumOfTransfer = 100
        val sumOfTransferInMonth = 75_001
        val message = "Комиссия за перевод составит 2060 копеек."

        assertEquals(message, tranferUpgrade(typeOfPayment, sumOfTransfer, sumOfTransferInMonth))
    }

    @Test
    fun transferUpgrade_countComissionVisaAndMirBeforeLimit() {
        val typeOfPayment = "Visa"
        val sumOfTransfer = 100
        val sumOfTransferInMonth = 0
        val message = "Комиссия за перевод составит 3500 копеек."

        assertEquals(message, tranferUpgrade(typeOfPayment, sumOfTransfer, sumOfTransferInMonth))
    }

    @Test
    fun transferUpgrade_countComissionVisaAndMirAfterLimit() {
        val typeOfPayment = "Visa"
        val sumOfTransfer = 10_000
        val sumOfTransferInMonth = 0
        val message = "Комиссия за перевод составит 7500 копеек."

        assertEquals(message, tranferUpgrade(typeOfPayment, sumOfTransfer, sumOfTransferInMonth))
    }

    @Test
    fun transferUpgrade_overLimitInMonthVkPay() {
        val typeOfPayment = "VK Pay"
        val sumOfTransfer = 100
        val sumOfTransferInMonth = 40_001
        val message = "Нельзя совершать переводы на сумму более 40.000 руб. в месяц"

        assertEquals(message, tranferUpgrade(typeOfPayment, sumOfTransfer, sumOfTransferInMonth))
    }

    @Test
    fun transferUpgrade_beforeLimitInMonthVkPay() {
        val typeOfPayment = "VK Pay"
        val sumOfTransfer = 100
        val sumOfTransferInMonth = 100
        val message = "Комиссия не взимается"

        assertEquals(message, tranferUpgrade(typeOfPayment, sumOfTransfer, sumOfTransferInMonth))
    }
}