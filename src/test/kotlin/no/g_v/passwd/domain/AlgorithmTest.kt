package no.g_v.passwd.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AlgorithmTest {

    @Test
    fun enum_values() {
        assertThat(Algorithm.values()).hasSize(2)
        assertThat(Algorithm.PRONOUNCEABLE.mode).isEqualTo(0)
        assertThat(Algorithm.RANDOM.mode).isEqualTo(1)
    }

    @Test
    fun from_text() {
        assertThat(Algorithm.fromText("random")).isEqualTo(Algorithm.RANDOM)
        assertThat(Algorithm.fromText("")).isEqualTo(Algorithm.PRONOUNCEABLE)
        assertThat(Algorithm.fromText(null)).isEqualTo(Algorithm.PRONOUNCEABLE)
    }
}