package codes.foobar.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SmallLetterTest {

    @Test
    fun values() {
        assertThat(SmallLetter.mustUse).isEqualTo("L")
        assertThat(SmallLetter.shouldUse).isEqualTo("l")
    }
}