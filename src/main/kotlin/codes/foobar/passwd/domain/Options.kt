package codes.foobar.passwd.domain

class Options(
        val lowerCase: Boolean = true,
        val upperCase: Boolean = true,
        val numbers: Boolean = true,
        val special: Boolean = true,
        val passwordLength: Int = 18
) {
    fun atLeastOneTrue() = lowerCase || upperCase || numbers || special
}