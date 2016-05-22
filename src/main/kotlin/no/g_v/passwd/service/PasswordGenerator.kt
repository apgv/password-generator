package no.g_v.passwd.service

import no.g_v.passwd.domain.ApgOptions

interface PasswordGenerator {
    fun generate(apgOptions: ApgOptions): List<CharArray>
}