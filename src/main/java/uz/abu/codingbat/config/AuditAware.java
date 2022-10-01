package uz.abu.codingbat.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.abu.codingbat.entity.User;

import java.util.Objects;
import java.util.Optional;

public class AuditAware implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        if (Objects.isNull(authentication) || Objects.equals(authentication.getName(),"anonymousUser"))
            return Optional.empty();

        User principal = (User) authentication.getPrincipal();
        return Optional.of(principal);
    }
}
