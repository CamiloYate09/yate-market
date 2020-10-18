package com.yate.market.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Antes
     *  @Bean
     *     public Docket api() {
     *         return new Docket(DocumentationType.SWAGGER_2)
     *                 .select()
     *                 .apis(RequestHandlerSelectors.basePackage("com.yate.market.web.controller"))
     *                 .build();
     *     }
     */
    /**
     * Despues
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yate.market.web.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEnPointInfi());
    }

    private ApiInfo apiEnPointInfi(){
        return  new ApiInfoBuilder().title("Api de Productos")
                .description("Servicios para la consulta de productos de un supermercado")
                .license("Apache 2.0")
                .version("1.0.0")
                .licenseUrl("https:apache.com")
                .build();
    }



}
