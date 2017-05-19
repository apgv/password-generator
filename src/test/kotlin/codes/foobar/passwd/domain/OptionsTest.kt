package codes.foobar.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class OptionsTest {

    @Test
    fun default_values() {
        val options = Options()

        assertThat(options.lowerCase).isTrue()
        assertThat(options.upperCase).isTrue()
        assertThat(options.numbers).isTrue()
        assertThat(options.special).isTrue()
        assertThat(options.passwordLength).isEqualTo(18)
    }
}