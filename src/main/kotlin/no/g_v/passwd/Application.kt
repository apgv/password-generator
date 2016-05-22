package no.g_v.passwd

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import javax.validation.Validator

@SpringBootApplication
open class Application {

    @Bean
    open fun validator(): Validator {
        return LocalValidatorFactoryBean()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}