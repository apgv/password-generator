package no.g_v.passwd.domain

import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class ApgOptions(val algorithm: Algorithm = Algorithm.PRONOUNCEABLE,
                      @get:[Min(1) Max(10)] val numberOfPasswords: Int = ApgOptionDefaults.numberOfPasswords,
                      @get:Min(8) val minPasswordLength: Int = ApgOptionDefaults.minPasswordLength,
                      @get:Max(24) val maxPasswordLength: Int = ApgOptionDefaults.maxPasswordLength,
                      val symbolsets: Symbolsets = Symbolsets()) {
}