package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SymbolTest {

    private class SymbolUnderTest : Symbol(mustUse = "a", shouldUse = "b")

    @Test
    fun must_or_should() {
        assertThat(SymbolUnderTest().mustOrShould("true")).isEqualTo("a")
        assertThat(SymbolUnderTest().mustOrShould("false")).isEqualTo("b")
        assertThat(SymbolUnderTest().mustOrShould(null)).isEqualTo("b")
    }
}