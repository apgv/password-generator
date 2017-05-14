package codes.foobar.passwd.domain

import codes.foobar.passwd.domain.PasswordRegex.A_Z_LOWER_REGEX
import codes.foobar.passwd.domain.PasswordRegex.A_Z_UPPER_REGEX
import codes.foobar.passwd.domain.PasswordRegex.NUMBER_REGEX
import codes.foobar.passwd.domain.PasswordRegex.SPECIAL_REGEX
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PasswordRegexTest {

    @Test
    fun lower_case() {
        assertThat(PasswordRegex.pattern(lowerCase = true, upperCase = false, numbers = false, special = false))
                .isEqualTo(A_Z_LOWER_REGEX)
    }

    @Test
    fun upper_case() {
        assertThat(PasswordRegex.pattern(lowerCase = false, upperCase = true, numbers = false, special = false))
                .isEqualTo(A_Z_UPPER_REGEX)
    }

    @Test
    fun number() {
        assertThat(PasswordRegex.pattern(lowerCase = false, upperCase = false, numbers = true, special = false))
                .isEqualTo(NUMBER_REGEX)
    }

    @Test
    fun special() {
        assertThat(PasswordRegex.pattern(lowerCase = false, upperCase = false, numbers = false, special = true))
                .isEqualTo(SPECIAL_REGEX)
    }

    @Test
    fun all_false_gives_full_regex() {
        assertThat(PasswordRegex.pattern(lowerCase = false, upperCase = false, numbers = false, special = false))
                .isEqualTo(A_Z_LOWER_REGEX + A_Z_UPPER_REGEX + NUMBER_REGEX + SPECIAL_REGEX)
    }
}