package codes.foobar.passwd.domain

import codes.foobar.passwd.domain.PasswordRegex.Companion.A_Z_LOWER_REGEX
import codes.foobar.passwd.domain.PasswordRegex.Companion.A_Z_UPPER_REGEX
import codes.foobar.passwd.domain.PasswordRegex.Companion.NUMBER_REGEX
import codes.foobar.passwd.domain.PasswordRegex.Companion.SPECIAL_REGEX
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PasswordRegexTest {

    @Test
    fun lower_case() {
        assertThat(PasswordRegex(lowerCase = true, upperCase = false, numbers = false, special = false).pattern())
                .isEqualTo(A_Z_LOWER_REGEX)
    }

    @Test
    fun upper_case() {
        assertThat(PasswordRegex(lowerCase = false, upperCase = true, numbers = false, special = false).pattern())
                .isEqualTo(A_Z_UPPER_REGEX)
    }

    @Test
    fun number() {
        assertThat(PasswordRegex(lowerCase = false, upperCase = false, numbers = true, special = false).pattern())
                .isEqualTo(NUMBER_REGEX)
    }

    @Test
    fun special() {
        assertThat(PasswordRegex(lowerCase = false, upperCase = false, numbers = false, special = true).pattern())
                .isEqualTo(SPECIAL_REGEX)
    }

    @Test
    fun all_false_gives_full_regex() {
        assertThat(PasswordRegex(lowerCase = false, upperCase = false, numbers = false, special = false).pattern())
                .isEqualTo(A_Z_LOWER_REGEX + A_Z_UPPER_REGEX + NUMBER_REGEX + SPECIAL_REGEX)
    }
}