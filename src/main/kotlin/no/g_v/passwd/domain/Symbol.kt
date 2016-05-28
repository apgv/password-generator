package no.g_v.passwd.domain

import org.apache.commons.lang3.BooleanUtils.toBoolean

abstract class Symbol(val mustUse: String, val shouldUse: String) {

    fun mustOrShould(s: String?) = if (toBoolean(s)) mustUse else shouldUse
}