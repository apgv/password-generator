package no.g_v.passwd.service

import no.g_v.passwd.domain.ApgOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.InputStreamReader
import javax.validation.Validator

@Service
class AutomaticPasswordGenerator @Autowired constructor(val validator: Validator) : PasswordGenerator {

    override fun generate(apgOptions: ApgOptions): List<CharArray> {
        if (hasConstraintViolation(apgOptions)) {
            throw IllegalArgumentException(apgOptions.toString())
        }

        val processBuilder = ProcessBuilder(
                "apg",
                "-a ${apgOptions.algorithm.mode}",
                "-M ${apgOptions.symbolsets.mode()}",
                "-m ${apgOptions.minPasswordLength}",
                "-x ${apgOptions.maxPasswordLength}",
                "-n ${apgOptions.numberOfPasswords}",
                "-c cl_ceed")

        val process = processBuilder.start()
        process.waitFor()

        return InputStreamReader(process.inputStream)
                .readLines()
                .map { it.toCharArray() }
    }

    private fun hasConstraintViolation(apgOptions: ApgOptions) = validator.validate(apgOptions).isNotEmpty()
}