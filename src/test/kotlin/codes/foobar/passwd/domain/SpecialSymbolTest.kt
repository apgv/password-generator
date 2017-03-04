package codes.foobar.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SpecialSymbolTest {

    @Test
    fun values() {
        assertThat(SpecialSymbol.mustUse).isEqualTo("S")
        assertThat(SpecialSymbol.shouldUse).isEqualTo("s")
    }
}