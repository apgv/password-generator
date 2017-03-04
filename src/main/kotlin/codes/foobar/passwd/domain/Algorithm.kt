package codes.foobar.passwd.domain

enum class Algorithm(val mode: Int) {
    PRONOUNCEABLE(0),
    RANDOM(1);

    companion object {
        fun fromText(s: String?): Algorithm = if (RANDOM.name == s?.toUpperCase()) RANDOM else PRONOUNCEABLE
    }
}