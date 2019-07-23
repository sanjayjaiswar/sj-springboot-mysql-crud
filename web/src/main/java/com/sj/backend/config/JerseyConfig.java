package com.sj.backend.config;

import com.sj.backend.controller.EntityController;
import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.ReflectiveJaxrsScanner;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResource;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/backendapp")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(EntityController.class);

		// Swagger classes
		register(ApiListingResource.class);
		register(ApiDeclarationProvider.class);
		register(ApiListingResourceJSON.class);
		register(ResourceListingProvider.class);
	}

	@PostConstruct
	public void initializeSwaggerConfiguration() {
		ReflectiveJaxrsScanner scanner = new ReflectiveJaxrsScanner();
		scanner.setResourcePackage("com.sj.backend.controller");
		ScannerFactory.setScanner(scanner);
		ClassReaders.setReader(new DefaultJaxrsApiReader());
		SwaggerConfig config = ConfigFactory.config();
		config.setApiVersion("1.0");
		config.setBasePath("http://localhost:7070/api");
	}
}

