package no.g_v.passwd.domain

enum class Algorithm(val mode: Int) {
    PRONOUNCEABLE(0),
    RANDOM_CHAR(1)
}