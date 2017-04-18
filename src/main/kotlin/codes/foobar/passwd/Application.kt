package codes.foobar.passwd

import codes.foobar.passwd.domain.*
import codes.foobar.passwd.service.AutomaticPasswordGenerator
import codes.foobar.passwd.service.PasswordGenerator
import com.google.gson.Gson
import spark.Spark.*
import javax.validation.Validation

object Application {
    fun passwordGenerator(): PasswordGenerator =
            AutomaticPasswordGenerator(Validation.buildDefaultValidatorFactory().validator)
}

fun main(args: Array<String>) {

    port(8080)
    staticFiles.location("/frontend")

    get("/password", { request, response ->
        val passwordGenerator = Application.passwordGenerator()
        val symbolsets = Symbolsets(
                specialSymbol = SpecialSymbol.mustOrShould(request.queryParams("specialSymbol")),
                numeralSymbol = NumeralSymbol.mustOrShould(request.queryParams("numeralSymbol")),
                capitalSymbol = CapitalSymbol.mustOrShould(request.queryParams("capitalSymbol")),
                smallLetter = SmallLetter.mustOrShould(request.queryParams("smallLetter"))
        )
        val apgOptions = ApgOptions(
                algorithm = Algorithm.fromText(request.queryParams("algorithm")),
                numberOfPasswords = ApgOptions.valueOrDefault(request.queryParams("numberOfPasswords"), ApgOptionDefaults.NUMBER_OF_PASSWORDS),
                minPasswordLength = ApgOptions.valueOrDefault(request.queryParams("minLength"), ApgOptionDefaults.MIN_PASSWORD_LENGTH),
                maxPasswordLength = ApgOptions.valueOrDefault(request.queryParams("maxLength"), ApgOptionDefaults.MAX_PASSWORD_LENGTH),
                symbolsets = symbolsets
        )

        response.type("application/json")
        Gson().toJson(passwordGenerator.generate(apgOptions))
    })
}