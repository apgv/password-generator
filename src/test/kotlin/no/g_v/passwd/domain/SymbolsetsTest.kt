package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SymbolsetsTest {

    @Test
    fun default_values() {
        val symbolsets = Symbolsets()

        assertThat(symbolsets.specialSymbol).isEqualTo(SpecialSymbol.shouldUse)
        assertThat(symbolsets.numeralSymbol).isEqualTo(NumeralSymbol.shouldUse)
        assertThat(symbolsets.capitalSymbol).isEqualTo(CapitalSymbol.shouldUse)
        assertThat(symbolsets.smallLetter).isEqualTo(SmallLetter.shouldUse)
    }

    @Test
    fun mode() {
        val defaultSymbolsets = Symbolsets()
        assertThat(defaultSymbolsets.mode()).isEqualTo("sncl")

        val symbolsets = Symbolsets(specialSymbol = SpecialSymbol.mustUse, capitalSymbol = CapitalSymbol.mustUse)
        assertThat(symbolsets.mode()).isEqualTo("SnCl")
    }
}
