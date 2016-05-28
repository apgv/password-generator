package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SymbolsetsTest {

    @Test
    fun default_values() {
        val symbolsets = Symbolsets()

        assertThat(symbolsets.specialSymbol).isEqualTo(SpecialSymbol.SHOULD_USE)
        assertThat(symbolsets.numeralSymbol).isEqualTo(NumeralSymbol.SHOULD_USE)
        assertThat(symbolsets.capitalSymbol).isEqualTo(CapitalSymbol.SHOULD_USE)
        assertThat(symbolsets.smallLetter).isEqualTo(SmallLetter.SHOULD_USE)
    }

    @Test
    fun mode() {
        val defaultSymbolsets = Symbolsets()
        assertThat(defaultSymbolsets.mode()).isEqualTo("sncl")

        val symbolsets = Symbolsets(specialSymbol = SpecialSymbol.MUST_USE, capitalSymbol = CapitalSymbol.MUST_USE)
        assertThat(symbolsets.mode()).isEqualTo("SnCl")
    }

    @Test
    fun mustOrShould() {
        assertThat(Symbolsets.mustOrShould("true")).isEqualTo("MUST_USE")
        assertThat(Symbolsets.mustOrShould("false")).isEqualTo("SHOULD_USE")
        assertThat(Symbolsets.mustOrShould(null)).isEqualTo("SHOULD_USE")
        assertThat(Symbolsets.mustOrShould(" ")).isEqualTo("SHOULD_USE")
    }
}
