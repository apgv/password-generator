package codes.foobar.passwd.domain

object PasswordRegex {

    val A_Z_LOWER_REGEX = "a-z"
    val A_Z_UPPER_REGEX = "A-Z"
    val NUMBER_REGEX = "0-9"
    val SPECIAL_REGEX = "!\"#$%&\\U+0027()*+,-./:;<=>?@[\\]^_`{|}~"
    val FULL_REGEX = A_Z_LOWER_REGEX + A_Z_UPPER_REGEX + NUMBER_REGEX + SPECIAL_REGEX

    fun pattern(options: Options) =
            if (options.atLeastOneTrue()) {
                regexOrEmpty(options.lowerCase, A_Z_LOWER_REGEX) +
                        regexOrEmpty(options.upperCase, A_Z_UPPER_REGEX) +
                        regexOrEmpty(options.numbers, NUMBER_REGEX) +
                        regexOrEmpty(options.special, SPECIAL_REGEX)
            } else {
                FULL_REGEX
            }

    private fun regexOrEmpty(b: Boolean, regex: String) = if (b) regex else ""
}