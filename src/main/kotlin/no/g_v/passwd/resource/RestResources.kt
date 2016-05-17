package no.g_v.passwd.resource

import org.springframework.stereotype.Service
import spark.Spark.get
import spark.servlet.SparkApplication

@Service
class RestResources : SparkApplication {

    override fun init() {

        get("/", { request, response ->
            "Spark and Kotlin :-)"
        })
    }
}