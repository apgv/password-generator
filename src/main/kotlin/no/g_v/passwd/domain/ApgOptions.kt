package no.g_v.passwd.domain

data class ApgOptions(val algorithm: Algorithm = Algorithm.PRONOUNCEABLE,
                      val numberOfPasswords: Int = ApgOptionDefaults.numberOfPasswords,
                      val minPasswordLength: Int = ApgOptionDefaults.minPasswordLength,
                      val maxPasswordLength: Int = ApgOptionDefaults.maxPasswordLength,
                      val symbolsets: Symbolsets = Symbolsets()) {
}