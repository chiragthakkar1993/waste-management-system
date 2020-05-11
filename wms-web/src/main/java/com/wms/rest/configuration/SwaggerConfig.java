/**
 * SwaggerConfig.java
 *  
 */
package com.wms.rest.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.util.UriComponentsBuilder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author chirag
 * @type SwaggerConfig
 * @since Apr 10, 2020
 */

@Configuration
@EnableSwagger2WebMvc
@Import({ SpringDataRestConfiguration.class })
public class SwaggerConfig {

	@Value("${server.servlet.context-path}")
	private String contextPath;

//	@Primary
//	@Bean
//	public LinkDiscoverers discoverers() {
//		List<LinkDiscoverer> plugins = new ArrayList<>();
//		plugins.add(new CollectionJsonLinkDiscoverer());
//		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
//
//	}

	private static Contact contact = new Contact("chirag", "http://www.github.com/chiragthakkar1993",
			"chirag.thakkar1993@gmail.com");
	private final ApiInfo API_INFO = new ApiInfo("Organico API Documentation",
			"this documentation provides all the required details client need to know to access APIs", "v1",
			"www.appkick.com/tc", contact, "Licensed to Appkick PVT LTD", "www.appkick.com/license",
			Collections.emptyList());

	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.wms.rest.web.controller")).paths(PathSelectors.any())
				.build().apiInfo(API_INFO).pathProvider(new MyPathProvider() {

				});
		return docket;
	}

	private class MyPathProvider extends DefaultPathProvider {
		@Override
		public String getOperationPath(String operationPath) {
			if (operationPath.startsWith(contextPath)) {
				operationPath = operationPath.substring(contextPath.length());
			}
			return Paths.removeAdjacentForwardSlashes(
					UriComponentsBuilder.newInstance().replacePath(operationPath).build().toString());
		}
	}

}
