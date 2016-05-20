package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GenerationOptionsTest {

    @Test
    fun default_values() {
        val generationOptions = GenerationOptions()

        assertThat(generationOptions.algorithm).isEqualTo(Algorithm.PRONOUNCEABLE)
        assertThat(generationOptions.numberOfPasswords).isEqualTo(1)
        assertThat(generationOptions.minPasswordLength).isEqualTo(8)
        assertThat(generationOptions.maxPasswordLength).isEqualTo(14)
        assertThat(generationOptions.symbolsets).isEqualTo(Symbolsets())
    }
}