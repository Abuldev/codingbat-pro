package uz.abu.codingbat.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.abu.codingbat.entity.Role;
import uz.abu.codingbat.entity.User;
import uz.abu.codingbat.entity.enums.PermissionEnum;
import uz.abu.codingbat.entity.enums.RoleEnum;
import uz.abu.codingbat.repository.RoleRepository;
import uz.abu.codingbat.repository.UserRepository;

import java.util.Objects;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlMode;

    @Value("${app.admin.username}")
    private String adminUsername;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) throws Exception {
        if (Objects.equals(ddlMode, "create")) {

            Role role = new Role();
            role.setName(RoleEnum.ROLE_ADMIN.name());
            role.setDescription("Project owner");
            role.setPermissions(Set.of(PermissionEnum.values()));
            roleRepository.save(role);


            Role roleUser = new Role();
            roleUser.setName(RoleEnum.ROLE_USER.name());
            roleUser.setDescription("Foydalanuvchui");
            roleUser.setPermissions(Set.of(PermissionEnum.SOLVE_PROBLEM));
            roleRepository.save(roleUser);

            User admin = new User(
                    adminUsername,
                    passwordEncoder.encode(adminPassword));
            admin.setRole(role);
            admin.setEnabled(true);

            userRepository.save(admin);
        }
    }

//    @Scheduled(fixedDelay = 6_000L)
//    public void sayHello() {
//        System.out.println("Say hello");
//    }

}
