package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import javax.validation.Validation

class ApgOptionsTest {

    private val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun default_values() {
        val generationOptions = ApgOptions()

        assertThat(generationOptions.algorithm).isEqualTo(Algorithm.PRONOUNCEABLE)
        assertThat(generationOptions.numberOfPasswords).isEqualTo(1)
        assertThat(generationOptions.minPasswordLength).isEqualTo(8)
        assertThat(generationOptions.maxPasswordLength).isEqualTo(14)
        assertThat(generationOptions.symbolsets).isEqualTo(Symbolsets())
    }

    @Test
    fun validate_constraints() {
        assertThat(hasConstraintViolations(ApgOptions())).isFalse()

        assertThat(hasConstraintViolations(ApgOptions(numberOfPasswords = 0))).isTrue()
        assertThat(hasConstraintViolations(ApgOptions(numberOfPasswords = 11))).isTrue()
        assertThat(hasConstraintViolations(ApgOptions(minPasswordLength = 7))).isTrue()
        assertThat(hasConstraintViolations((ApgOptions(maxPasswordLength = 25)))).isTrue()
    }

    private fun hasConstraintViolations(apgOptions: ApgOptions) = validator.validate(apgOptions).isNotEmpty()

}