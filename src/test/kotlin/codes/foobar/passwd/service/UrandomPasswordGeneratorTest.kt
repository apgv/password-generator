package codes.foobar.passwd.service

import codes.foobar.passwd.domain.Options
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class UrandomPasswordGeneratorTest {

    @Test
    fun generate_should_return_passwords_which_conforms_to_the_password_constraints() {
        val password = UrandomPasswordGenerator.generate(Options(passwordLength = 18))

        assertThat(password.size).isEqualTo(18)
    }

    @Test
    fun generate_should_return_password_with_minimum_length_of_4() {
        val password = UrandomPasswordGenerator.generate(Options(passwordLength = 1))

        assertThat(password.size).isEqualTo(4)
    }
}