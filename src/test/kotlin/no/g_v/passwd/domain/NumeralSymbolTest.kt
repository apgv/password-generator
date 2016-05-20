package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NumeralSymbolTest {

    @Test
    fun enum_values() {
        assertThat(NumeralSymbol.values()).hasSize(2)
        assertThat(NumeralSymbol.MUST_USE.mode).isEqualTo("N")
        assertThat(NumeralSymbol.SHOULD_USE.mode).isEqualTo("n")
    }
}