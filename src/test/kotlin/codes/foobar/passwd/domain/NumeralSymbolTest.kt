package codes.foobar.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NumeralSymbolTest {

    @Test
    fun values() {
        assertThat(NumeralSymbol.mustUse).isEqualTo("N")
        assertThat(NumeralSymbol.shouldUse).isEqualTo("n")
    }
}