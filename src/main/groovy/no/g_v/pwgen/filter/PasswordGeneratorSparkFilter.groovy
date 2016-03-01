package no.g_v.pwgen.filter

import no.g_v.pwgen.resource.RestResources
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import spark.servlet.SparkApplication
import spark.servlet.SparkFilter

import javax.servlet.FilterConfig
import javax.servlet.ServletException

@Component
class PasswordGeneratorSparkFilter extends SparkFilter {

    @Autowired
    private RestResources restResources

    @Override
    protected SparkApplication getApplication(FilterConfig filterConfig) throws ServletException {
        restResources
    }
}
