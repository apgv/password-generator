package no.g_v.passwd.domain


data class Symbolsets(val specialSymbol: SpecialSymbol = SpecialSymbol.SHOULD_USE,
                      val numeralSymbol: NumeralSymbol = NumeralSymbol.SHOULD_USE,
                      val capitalSymbol: CapitalSymbol = CapitalSymbol.SHOULD_USE,
                      val smallLetter: SmallLetter = SmallLetter.SHOULD_USE) {

    fun mode() = specialSymbol.mode + numeralSymbol.mode + capitalSymbol.mode + smallLetter.mode
}