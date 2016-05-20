package no.g_v.passwd.domain

enum class NumeralSymbol(val mode: String) {
    MUST_USE("N"),
    SHOULD_USE("n")
}