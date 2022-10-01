package uz.abu.codingbat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.abu.codingbat.entity.User;

@Configuration
@EnableJpaAuditing
//2-ishimiz
public class AuditingConfig {

    @Bean
    public AuditorAware<User> auditorAware(){
        return new AuditAware();
    }
}
