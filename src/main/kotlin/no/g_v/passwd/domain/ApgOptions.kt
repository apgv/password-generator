package no.g_v.passwd.domain

import no.g_v.passwd.domain.ApgOptionDefaults.*
import org.apache.commons.lang3.math.NumberUtils.toInt
import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class ApgOptions(val algorithm: Algorithm = Algorithm.PRONOUNCEABLE,
                      @get:[Min(1) Max(10)] val numberOfPasswords: Int = NUMBER_OF_PASSWORDS.value,
                      @get:Min(8) val minPasswordLength: Int = MIN_PASSWORD_LENGTH.value,
                      @get:Max(24) val maxPasswordLength: Int = MAX_PASSWORD_LENGTH.value,
                      val symbolsets: Symbolsets = Symbolsets()) {

    companion object {
        fun valueOrDefault(s: String?, apgOptionsDefaults: ApgOptionDefaults) = toInt(s, apgOptionsDefaults.value)
    }
}