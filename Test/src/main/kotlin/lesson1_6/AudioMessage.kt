package lesson1_6

class AudioMessage(
    val duration: Int,
    val waveform: Array<Int>,
    val linkOgg: String,
    val linkMp3: String
)