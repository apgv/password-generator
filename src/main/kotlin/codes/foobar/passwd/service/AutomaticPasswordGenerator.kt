package codes.foobar.passwd.service

import codes.foobar.passwd.domain.ApgOptions
import java.io.InputStreamReader
import javax.validation.Validator

class AutomaticPasswordGenerator constructor(val validator: Validator) : PasswordGenerator {

    override fun generate(apgOptions: ApgOptions): List<CharArray> {
        if (hasConstraintViolation(apgOptions)) {
            throw IllegalArgumentException(apgOptions.toString())
        }

        val process = Runtime.getRuntime().exec(
                """apg
                    -a ${apgOptions.algorithm.mode}
                    -M ${apgOptions.symbolsets.mode()}
                    -m ${apgOptions.minPasswordLength}
                    -x ${apgOptions.maxPasswordLength}
                    -n ${apgOptions.numberOfPasswords}
                    -c cl_ceed"""
        )
        process.waitFor()

        return InputStreamReader(process.inputStream)
                .readLines()
                .map { it.toCharArray() }
    }

    private fun hasConstraintViolation(apgOptions: ApgOptions) = validator.validate(apgOptions).isNotEmpty()
}