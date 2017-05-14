package codes.foobar.passwd.domain

object PasswordRegex {

    val A_Z_LOWER_REGEX = "a-z"
    val A_Z_UPPER_REGEX = "A-Z"
    val NUMBER_REGEX = "0-9"
    val SPECIAL_REGEX = "!\"#$%&\\U+0027()*+,-./:;<=>?@[\\]^_`{|}~"
    val FULL_REGEX = A_Z_LOWER_REGEX + A_Z_UPPER_REGEX + NUMBER_REGEX + SPECIAL_REGEX

    fun pattern(lowerCase: Boolean, upperCase: Boolean, numbers: Boolean, special: Boolean) =
            if (lowerCase || upperCase || numbers || special) {
                regexOrEmpty(lowerCase, A_Z_LOWER_REGEX) +
                        regexOrEmpty(upperCase, A_Z_UPPER_REGEX) +
                        regexOrEmpty(numbers, NUMBER_REGEX) +
                        regexOrEmpty(special, SPECIAL_REGEX)
            } else {
                FULL_REGEX
            }

    private fun regexOrEmpty(b: Boolean, regex: String) = if (b) regex else ""
}