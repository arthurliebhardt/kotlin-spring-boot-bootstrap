package com.atr.kotlin.playground.shared

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData())

    fun metaData(): ApiInfo {
        return ApiInfo(
                "Playgorund API",
                "Documentation of all my playground",
                "1.0",
                "Terms of service",
                Contact("atr", "https://github.com/arthurliebhardt", ""),
                "MIT License", "https://choosealicense.com/licenses/mit/", emptyList())
    }

}