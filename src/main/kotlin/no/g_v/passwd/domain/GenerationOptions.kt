package no.g_v.passwd.domain

data class GenerationOptions(val algorithm: Algorithm = Algorithm.PRONOUNCEABLE,
                             val numberOfPasswords: Int = GenerationOptionDefaults.numberOfPasswords,
                             val minPasswordLength: Int = GenerationOptionDefaults.minPasswordLength,
                             val maxPasswordLength: Int = GenerationOptionDefaults.maxPasswordLength,
                             val symbolsets: Symbolsets = Symbolsets()) {
}