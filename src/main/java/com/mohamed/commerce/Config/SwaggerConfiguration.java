package com.mohamed.commerce.Config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.mohamed.commerce.Utils.Constants.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {



    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("E_commerce API documentation")
                                .title("E_commerce REST API")
                                .build()
                )
                .groupName("REST API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mohamed.commerce"))
                .paths(PathSelectors.ant(APP_ROOT+"/**" ))
                .build();

    }


}
