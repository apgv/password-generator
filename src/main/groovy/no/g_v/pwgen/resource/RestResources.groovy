package no.g_v.pwgen.resource

import groovy.json.JsonOutput
import org.springframework.stereotype.Service
import spark.servlet.SparkApplication

import static spark.Spark.*

@Service
class RestResources implements SparkApplication {

    @Override
    void init() {

        get('/hello', { request, response ->
            response.type('application/json')
            JsonOutput.toJson([greeting: 'hello'])
        })
    }
}
