package codes.foobar.passwd.service

import codes.foobar.passwd.domain.ApgOptions

interface PasswordGenerator {
    fun generate(apgOptions: ApgOptions): List<CharArray>
}