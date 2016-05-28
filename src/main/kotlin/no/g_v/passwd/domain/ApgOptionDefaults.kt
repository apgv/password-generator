package no.g_v.passwd.domain

enum class ApgOptionDefaults(val value: Int) {
    NUMBER_OF_PASSWORDS(1),
    MIN_PASSWORD_LENGTH(8),
    MAX_PASSWORD_LENGTH(14)
}