package com.sj.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

@Profile("backend")
@Configuration
@EnableTransactionManagement
public class MySQLConfig {

  @Inject
  private Environment _env;

  @Inject
  private DataSource _dataSource;

  @Inject
  private LocalContainerEntityManagerFactoryBean _entityManagerFactory;

   /**
    * Declare the JPA entity manager factory.
    */
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory =
        new LocalContainerEntityManagerFactoryBean();

      entityManagerFactory.setDataSource(_dataSource);

      // Classpath scanning of @Component, @Service, etc annotated class
      entityManagerFactory.setPackagesToScan(_env.getProperty("entitymanager.packagesToScan"));

      // Vendor adapter
      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

      Properties additionalProperties = new Properties();
      additionalProperties.put("hibernate.dialect",_env.getProperty("hibernate.dialect"));
      additionalProperties.put("hibernate.show_sql",_env.getProperty("hibernate.show_sql"));
      //additionalProperties.put("hibernate.hbm2ddl.auto",_env.getProperty("hibernate.hbm2ddl.auto"));
      entityManagerFactory.setJpaProperties(additionalProperties);

      return entityManagerFactory;
  }

    /**
     * Declare the transaction manager.
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(_entityManagerFactory.getObject());
        return transactionManager;
    }

    /**
     * PersistenceExceptionTranslationPostProcessor is a bean post processor
     * which adds an advisor to any bean annotated with EntityRepository so that any
     * platform-specific exceptions are caught and then rethrown as one
     * Spring's unchecked data access exceptions (i.e. a subclass of
     * DataAccessException).
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
