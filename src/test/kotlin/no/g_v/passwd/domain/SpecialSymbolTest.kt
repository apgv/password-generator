package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SpecialSymbolTest {

    @Test
    fun enum_values() {
        assertThat(SpecialSymbol.values()).hasSize(2)
        assertThat(SpecialSymbol.MUST_USE.mode).isEqualTo("S")
        assertThat(SpecialSymbol.SHOULD_USE.mode).isEqualTo("s")
    }
}