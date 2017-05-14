package codes.foobar.passwd.domain

class PasswordRegex(val lowerCase: Boolean, val upperCase: Boolean, val numbers: Boolean, val special: Boolean) {

    companion object {
        val A_Z_LOWER_REGEX = "a-z"
        val A_Z_UPPER_REGEX = "A-Z"
        val NUMBER_REGEX = "0-9"
        val SPECIAL_REGEX = "!\"#$%&\\U+0027()*+,-./:;<=>?@[\\]^_`{|}~"
        val FULL_REGEX = A_Z_LOWER_REGEX + A_Z_UPPER_REGEX + NUMBER_REGEX + SPECIAL_REGEX
    }

    fun pattern() = if (allFalse()) FULL_REGEX else createPattern()

    private fun allFalse() = !lowerCase && !upperCase && !numbers && !special

    private fun createPattern() = lowerCase() + upperCase() + numbers() + special()

    private fun lowerCase() = if (lowerCase) A_Z_LOWER_REGEX else ""

    private fun upperCase() = if (upperCase) A_Z_UPPER_REGEX else ""

    private fun numbers() = if (numbers) NUMBER_REGEX else ""

    private fun special() = if (special) SPECIAL_REGEX else ""
}