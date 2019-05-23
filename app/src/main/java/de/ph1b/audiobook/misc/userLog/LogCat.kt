package de.ph1b.audiobook.misc.userLog


object LogCat {

    fun read(): List<String> {
        val cmd = listOf("logcat", "-t", "4000", "-v", "time", "-b", "main", "VoiceApp:D", "*:S")
        val process = ProcessBuilder().command(cmd).redirectErrorStream(true).start()
        try {
            return process.inputStream.use {
                it.reader().buffered().lineSequence().toList()
            }
        } finally {
            process.destroy()
        }
    }

}
