package no.g_v.passwd.domain

import org.assertj.core.api.Assertions
import org.junit.Test

class CapitalSymbolTest {

    @Test
    fun enum_values() {
        Assertions.assertThat(CapitalSymbol.values()).hasSize(2)
        Assertions.assertThat(CapitalSymbol.MUST_USE.mode).isEqualTo("C")
        Assertions.assertThat(CapitalSymbol.SHOULD_USE.mode).isEqualTo("c")
    }
}