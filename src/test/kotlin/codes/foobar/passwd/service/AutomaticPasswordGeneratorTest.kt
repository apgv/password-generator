package codes.foobar.passwd.service

import codes.foobar.passwd.domain.ApgOptionDefaults
import codes.foobar.passwd.domain.ApgOptions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.validation.Validation
import javax.validation.Validator

class AutomaticPasswordGeneratorTest {

    private val validator: Validator = mock(Validator::class.java)

    @Test
    fun parameter_options_should_be_validated() {
        val passwordGenerator = AutomaticPasswordGenerator(validator)
        val apgOptions = ApgOptions()

        passwordGenerator.generate(apgOptions)

        verify(validator).validate(apgOptions)
    }

    @Test
    fun generate_should_return_two_passwords_if_validation_passes() {
        val passwordGenerator = AutomaticPasswordGenerator(validator)

        val passwords = passwordGenerator.generate(ApgOptions(numberOfPasswords = 2))

        assertThat(passwords).hasSize(2)
    }

    @Test
    fun generate_should_return_passwords_which_conforms_to_the_password_constraints() {
        val passwordGenerator = AutomaticPasswordGenerator(validator)

        val passwords = passwordGenerator.generate(ApgOptions())

        assertThat(passwords[0].size)
                .isGreaterThanOrEqualTo(ApgOptionDefaults.MIN_PASSWORD_LENGTH.value)
                .isLessThanOrEqualTo(ApgOptionDefaults.MAX_PASSWORD_LENGTH.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun should_not_accept_invalid_options_to_apg() {
        val passwordGenerator = AutomaticPasswordGenerator(Validation.buildDefaultValidatorFactory().validator)
        val invalidApgOptions = ApgOptions(minPasswordLength = 0)

        passwordGenerator.generate(invalidApgOptions)
    }
}