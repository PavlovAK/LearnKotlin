import lesson1_2.tranfer
import org.junit.Test

import org.junit.Assert.*

internal class TransferKtTest {

    @Test
    fun tranfer_withoutDiscont() {
        val sumOfTransferWithoutDiscont = 35
        val message = "Комиссия составит 3500 копеек."
        val result = tranfer(sumOfTransfer = sumOfTransferWithoutDiscont)

        assertEquals(1, result)
    }

    @Test
    fun tranfer_withDiscont() {
        val sumOfTransferForDiscont = 10000
        val comission = "Комиссия составит 750000 копеек."

        val result = tranfer(sumOfTransfer = sumOfTransferForDiscont)

        assertEquals(comission, result)
    }
}