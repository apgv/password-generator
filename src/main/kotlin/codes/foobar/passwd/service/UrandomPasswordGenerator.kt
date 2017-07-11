package codes.foobar.passwd.service

import codes.foobar.passwd.domain.Options
import codes.foobar.passwd.domain.PasswordRegex

object UrandomPasswordGenerator {

    fun generate(options: Options): CharArray {

        val pattern = PasswordRegex.pattern(options)
        val passwordLength = passwordLength(options.passwordLength)
        val command = listOf(
                "/bin/sh", "-c",
                "cat /dev/urandom | tr -dc '$pattern' | fold -w $passwordLength | head -n 1"
        )

        val process = ProcessBuilder(command).start()
        process.waitFor()

        return process.inputStream.reader().use { it.readText().trim().toCharArray() }
    }

    private fun passwordLength(length: Int) = if (length < 4) 4 else length
}