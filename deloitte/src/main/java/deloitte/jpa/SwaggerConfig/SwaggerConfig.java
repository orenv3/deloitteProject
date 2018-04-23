package deloitte.jpa.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import deloitte.jpa.rest.RestCustomer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = RestCustomer.class)
public class SwaggerConfig {

	private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICENSE_TEST = "license";
	private static final String TITLE = "REST API - deloitte customers";
	private static final String DESCRIPTION = "deloitte homework";

	/**
	 * The information on the current API.
	 * 
	 * @return ApiInfo information about the current API
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).license(LICENSE_TEST)
				.version(SWAGGER_API_VERSION).build();

	}

	/**
	 * Swagger-UI configuration
	 * 
	 * @return Docket Docket type Swagger2
	 */
	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
				.paths(PathSelectors.regex("/restCustomer.*")).build();
	}

}
