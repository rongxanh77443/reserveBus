package com.kltn.booking.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 12/3/2020
 * Time      : 11:14 AM
 * Filename  : AuditConfiguration
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

}