package kr.pe.nuti.home.api.core.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Configuration
@EnableJpaRepositories({
    "kr.pe.nuti.home.api.pack.*.repository"
})
@EntityScan("kr.pe.nuti.home.api.pack.*.domain")
public class JpaConfiguration {
}
