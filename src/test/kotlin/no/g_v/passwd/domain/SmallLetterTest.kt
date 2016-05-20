package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SmallLetterTest {

    @Test
    fun enum_values() {
        assertThat(SmallLetter.values()).hasSize(2)
        assertThat(SmallLetter.MUST_USE.mode).isEqualTo("L")
        assertThat(SmallLetter.SHOULD_USE.mode).isEqualTo("l")
    }
}