package com.library.app.config;


/**
 * @author JIDEX
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${API.CLIENT_URL}")
    private String CLIENT_URL;
    @Value("${API.TOKEN_URL}")
    private String TOKEN_URL;
    private boolean enableSwagger = true;

    @Bean
    public Docket api() {
        List<ResponseMessage> list = new java.util.ArrayList<>();
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.library.app.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext()))
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, list)
                .globalResponseMessage(RequestMethod.POST, list);
    }

    private OAuth securitySchema() {
        List<AuthorizationScope> authorizationScopeList = newArrayList();
        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
        authorizationScopeList.add(new AuthorizationScope("trust", "trust all"));
        authorizationScopeList.add(new AuthorizationScope("write", "access all"));
        List<GrantType> grantTypes = newArrayList();
        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant(CLIENT_URL + TOKEN_URL);
        grantTypes.add(creGrant);

        return new OAuth("library-rest-api", authorizationScopeList, grantTypes);

    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
        authorizationScopes[0] = new AuthorizationScope("read", "read all");
        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
        authorizationScopes[2] = new AuthorizationScope("write", "write all");

        return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
    }

    @Bean
    public SecurityConfiguration securityInfo() {

        return new SecurityConfiguration("library-client", "library-secret",
                "", "", "", ApiKeyVehicle.HEADER, "", " ");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Library api for managing books").description("")
                .termsOfServiceUrl("https://library.org")
                .contact(new Contact("Library", "https://library.org", "isaiah@swipe.com"))
                .license("Open Source").licenseUrl("https://library.org").version("1.0.0").build();
    }

}
