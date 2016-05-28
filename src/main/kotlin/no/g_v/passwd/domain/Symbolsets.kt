package no.g_v.passwd.domain

import org.apache.commons.lang3.BooleanUtils.toBoolean

data class Symbolsets(val specialSymbol: SpecialSymbol = SpecialSymbol.SHOULD_USE,
                      val numeralSymbol: NumeralSymbol = NumeralSymbol.SHOULD_USE,
                      val capitalSymbol: CapitalSymbol = CapitalSymbol.SHOULD_USE,
                      val smallLetter: SmallLetter = SmallLetter.SHOULD_USE) {

    fun mode() = specialSymbol.mode + numeralSymbol.mode + capitalSymbol.mode + smallLetter.mode

    companion object {
        fun mustOrShould(s: String?) = if (toBoolean(s)) "MUST_USE" else "SHOULD_USE"
    }
}