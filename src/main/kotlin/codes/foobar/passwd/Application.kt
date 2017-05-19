package codes.foobar.passwd

import codes.foobar.passwd.domain.*
import codes.foobar.passwd.service.UrandomPasswordGenerator
import com.google.gson.Gson
import spark.Spark.*

fun main(args: Array<String>) {

    port(8080)
    staticFiles.location("/frontend")

    get("/password", { request, response ->
        val options = Options(
                lowerCase = request.queryParams("lowerCase").toBoolean(),
                upperCase = request.queryParams("uppercase").toBoolean(),
                numbers = request.queryParams("numbers").toBoolean(),
                special = request.queryParams("special").toBoolean(),
                passwordLength = request.queryParams("length")?.toInt() ?: 18
        )

        response.type("application/json")
        Gson().toJson(UrandomPasswordGenerator.generate(options))
    })
}