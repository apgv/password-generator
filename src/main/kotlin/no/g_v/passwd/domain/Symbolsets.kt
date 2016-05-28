package no.g_v.passwd.domain

data class Symbolsets(val specialSymbol: String = SpecialSymbol.shouldUse,
                      val numeralSymbol: String = NumeralSymbol.shouldUse,
                      val capitalSymbol: String = CapitalSymbol.shouldUse,
                      val smallLetter: String = SmallLetter.shouldUse) {

    fun mode() = specialSymbol + numeralSymbol + capitalSymbol + smallLetter
}