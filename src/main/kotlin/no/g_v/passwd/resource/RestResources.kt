package no.g_v.passwd.resource

import com.google.gson.Gson
import no.g_v.passwd.domain.*
import no.g_v.passwd.domain.ApgOptionDefaults.*
import no.g_v.passwd.domain.ApgOptions.Companion.valueOrDefault
import no.g_v.passwd.service.PasswordGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import spark.Spark.get
import spark.servlet.SparkApplication

@Service
class RestResources @Autowired constructor(val passwordGenerator: PasswordGenerator) : SparkApplication {

    override fun init() {

        get("/password", { request, response ->
            val symbolsets = Symbolsets(
                    specialSymbol = SpecialSymbol.mustOrShould(request.queryParams("specialSymbol")),
                    numeralSymbol = NumeralSymbol.mustOrShould(request.queryParams("numeralSymbol")),
                    capitalSymbol = CapitalSymbol.mustOrShould(request.queryParams("capitalSymbol")),
                    smallLetter = SmallLetter.mustOrShould(request.queryParams("smallLetter"))
            )
            val apgOptions = ApgOptions(
                    algorithm = Algorithm.fromText(request.queryParams("algorithm")),
                    numberOfPasswords = valueOrDefault(request.queryParams("numberOfPasswords"), NUMBER_OF_PASSWORDS),
                    minPasswordLength = valueOrDefault(request.queryParams("minLength"), MIN_PASSWORD_LENGTH),
                    maxPasswordLength = valueOrDefault(request.queryParams("maxLength"), MAX_PASSWORD_LENGTH),
                    symbolsets = symbolsets
            )

            response.type("application/json")
            Gson().toJson(passwordGenerator.generate(apgOptions))
        })
    }
}