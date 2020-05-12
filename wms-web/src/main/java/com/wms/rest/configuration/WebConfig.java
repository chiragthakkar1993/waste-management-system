package com.wms.rest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:rest.properties")
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.addPathPrefix("${wms.api.prefix_version}", HandlerTypePredicate.forAnnotation(RestController.class)
				.and(HandlerTypePredicate.forBasePackage("com.wms.rest.web.controller.v1")));
	}

//	@Autowired
//	private ApplicationContext applicationContext;

//	@Bean
//	@Primary
//	public DTOArgumentProcessor dtoArgumentProcessor() {
//		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(this.applicationContext)
//				.build();
//		return new DTOArgumentProcessor(objectMapper);
//	}

	

//	@Override
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//		argumentResolvers.add(dtoArgumentProcessor());
//	}
	
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addCorsMappings(registry);
//		registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
//	}

}