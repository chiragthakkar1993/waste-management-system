package com.wms.entity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chirag
 * @type PersistenceConfig
 * @since Mar 19, 2020 5:45:17 PM
 */
@Configuration
@EnableMongoAuditing
@EnableTransactionManagement
@EnableMongoRepositories
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class PersistenceConfig {

	private final MongoTemplate mongoTemplate;
	private final MongoConverter mongoConverter;

	@Bean
	public AuditorAware<String> mongoAuditorProvider() {
		return new AuditorAware<String>() {

			@Override
			public Optional<String> getCurrentAuditor() {

				return Optional.of("Chirag");
			}
		};
//		return new AuditorAwareImpl() {
//			@Override
//			public Optional<User> getCurrentAuditor() {
//				return Optional.ofNullable(SecurityContextHolder.getContext()).map(SecurityContext::getAuthentication)
//						.filter(Authentication::isAuthenticated).map(Authentication::getPrincipal)
//						.map(User.class::cast);
//			}
//		};
	}

	@EventListener(ApplicationReadyEvent.class)
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public void initIndicesAfterStartup() {

		MongoMappingContext mappingContext = (MongoMappingContext) this.mongoConverter.getMappingContext();
		for (BasicMongoPersistentEntity<?> persistenceEntity : mappingContext.getPersistentEntities()) {
			Class<?> classType = persistenceEntity.getType();
			if (classType.isAnnotationPresent(Document.class)) {
				IndexResolver resolver = new MongoPersistentEntityIndexResolver(mappingContext);
				IndexOperations indexOps = mongoTemplate.indexOps(classType);
				indexOps.dropAllIndexes();
				resolver.resolveIndexFor(classType).forEach(indexOps::ensureIndex);
			}
		}
		log.info("************* Indices resolved **************");

	}

}
