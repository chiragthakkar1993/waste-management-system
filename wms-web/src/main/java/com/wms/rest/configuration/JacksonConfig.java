/**
 * JacksonConfig.java
 *  
 */
package com.wms.rest.configuration;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author chirag
 * @type JacksonConfig
 * @since Apr 5, 2020
 */

@Configuration
public class JacksonConfig {

	@Bean
	@Primary
	@Lazy
	public Jackson2ObjectMapperBuilderCustomizer customJson() {
		return builder -> {
			builder.indentOutput(true).serializationInclusion(Include.NON_NULL)
//					.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE)
					.build();
//					.featuresToEnable(SerializationFeature.WRAP_ROOT_VALUE)

			// all lowercase with under score between words
//	            builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		};
	}

}
