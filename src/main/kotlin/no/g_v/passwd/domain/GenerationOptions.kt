package no.g_v.passwd.domain

data class GenerationOptions(val algorithm: Algorithm = Algorithm.PRONOUNCEABLE,
                             val numberOfPasswords: Int = 1,
                             val minPasswordLength: Int = 8,
                             val maxPasswordLength: Int = 14,
                             val symbolsets: Symbolsets = Symbolsets()) {
}