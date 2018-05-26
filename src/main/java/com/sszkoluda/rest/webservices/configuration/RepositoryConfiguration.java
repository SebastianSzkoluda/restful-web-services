package com.sszkoluda.rest.webservices.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.sszkoluda.rest.webservices.model"})
@EnableJpaRepositories(basePackages = {"com.sszkoluda.rest.webservices.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
