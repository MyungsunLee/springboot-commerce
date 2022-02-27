package com.bdshopping.springbootbdshopping.config;

import org.mapstruct.BeanMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static com.bdshopping.springbootbdshopping.utils.ProjectConstants.PROJECT_BASE_PACKAGE;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Value("${swagger.app-info.name}")
    private String appName;

    @Value("${swagger.app-info.description}")
    private String appDescription;

    @Value("${swagger.app-info.version}")
    private String appVersion;

    @Value("${swagger.app-info.license}")
    private String license;

    @Value("${swagger.app-info.license-url}")
    private String appLicenseUrl;

    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.url}")
    private String contactUrl;

    @Value("${swagger.contact.email}")
    private String contactEmail;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(getHeaderParams())
                .select()
                .apis(RequestHandlerSelectors.basePackage(PROJECT_BASE_PACKAGE))
                // .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(getApiInformation());
    }

    private ApiInfo getApiInformation() {

        final Contact contact = new Contact(contactName, contactUrl, contactEmail);

        return new ApiInfoBuilder()
                .title(appName)
                .version(appVersion)
                .description(appDescription)
                .license(license).licenseUrl(appLicenseUrl)
                .contact(contact)
                .build();
    }

    private List<Parameter> getHeaderParams() {

        final Parameter parameter = new ParameterBuilder()
                .required(false)
                .name("Authorization")
                .parameterType("header")
                .modelRef(new ModelRef("string"))
                .build();

        return Collections.singletonList(parameter);

    }

}
