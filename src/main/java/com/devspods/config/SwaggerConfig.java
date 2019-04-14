package com.devspods.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String CONTROLLERS_BASE_PACKAGE = "com.devspods.controllers";

    @Bean
    public Docket genderApi(){
        return getDocketBuilder().paths(paths()).build();
    }

    private ApiSelectorBuilder getDocketBuilder(){
        return new Docket(SWAGGER_2).select().apis(basePackage(CONTROLLERS_BASE_PACKAGE));
    }

    private Predicate<String> paths() {
        List<Predicate<String>> paths = new ArrayList<>(5);
        paths.add(regex("/genders.*"));
        paths.add(regex("/authors.*"));
        paths.add(regex("/categories.*"));
        paths.add(regex("/posts-status.*"));
        paths.add(regex("/posts.*"));
        return Predicates.or(paths);
    }
}
