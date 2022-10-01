package uz.abu.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abu.codingbat.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(String name);
}
