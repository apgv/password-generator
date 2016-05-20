package no.g_v.passwd.domain

enum class SpecialSymbol(val mode: String) {
    MUST_USE("S"),
    SHOULD_USE("s")
}