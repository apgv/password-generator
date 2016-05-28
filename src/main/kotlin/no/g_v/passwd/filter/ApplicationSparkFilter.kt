package no.g_v.passwd.filter

import no.g_v.passwd.resource.RestResources
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import spark.servlet.SparkApplication
import spark.servlet.SparkFilter
import javax.servlet.FilterConfig

@Component
open class ApplicationSparkFilter @Autowired constructor(val restResources: RestResources) : SparkFilter() {

    override fun getApplication(filterConfig: FilterConfig?): SparkApplication? {
        return restResources
    }
}