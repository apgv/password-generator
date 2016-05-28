package no.g_v.passwd.domain

import org.assertj.core.api.Assertions
import org.junit.Test

class CapitalSymbolTest {

    @Test
    fun values() {
        Assertions.assertThat(CapitalSymbol.mustUse).isEqualTo("C")
        Assertions.assertThat(CapitalSymbol.shouldUse).isEqualTo("c")
    }
}