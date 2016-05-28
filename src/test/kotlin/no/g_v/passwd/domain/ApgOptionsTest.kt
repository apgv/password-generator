package no.g_v.passwd.domain

import no.g_v.passwd.domain.ApgOptionDefaults.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import javax.validation.Validation

class ApgOptionsTest {

    private val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun default_values() {
        val apgOptions = ApgOptions()

        assertThat(apgOptions.algorithm).isEqualTo(Algorithm.PRONOUNCEABLE)
        assertThat(apgOptions.numberOfPasswords).isEqualTo(1)
        assertThat(apgOptions.minPasswordLength).isEqualTo(8)
        assertThat(apgOptions.maxPasswordLength).isEqualTo(14)
        assertThat(apgOptions.symbolsets).isEqualTo(Symbolsets())
    }

    @Test
    fun validate_constraints() {
        assertThat(hasConstraintViolation(ApgOptions())).isFalse()

        assertThat(hasConstraintViolation(ApgOptions(numberOfPasswords = 0))).isTrue()
        assertThat(hasConstraintViolation(ApgOptions(numberOfPasswords = 11))).isTrue()
        assertThat(hasConstraintViolation(ApgOptions(minPasswordLength = 7))).isTrue()
        assertThat(hasConstraintViolation((ApgOptions(maxPasswordLength = 25)))).isTrue()
    }

    @Test
    fun valueOrDefault() {
        val nonNullValue = "0"

        assertThat(ApgOptions.valueOrDefault(nonNullValue, NUMBER_OF_PASSWORDS)).isEqualTo(0)
        assertThat(ApgOptions.valueOrDefault(null, NUMBER_OF_PASSWORDS)).isEqualTo(NUMBER_OF_PASSWORDS.value)
        assertThat(ApgOptions.valueOrDefault(null, MIN_PASSWORD_LENGTH)).isEqualTo(MIN_PASSWORD_LENGTH.value)
        assertThat(ApgOptions.valueOrDefault(null, MAX_PASSWORD_LENGTH)).isEqualTo(MAX_PASSWORD_LENGTH.value)
    }

    private fun hasConstraintViolation(apgOptions: ApgOptions) = validator.validate(apgOptions).isNotEmpty()

}