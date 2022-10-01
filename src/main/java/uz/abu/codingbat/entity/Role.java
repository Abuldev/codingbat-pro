package uz.abu.codingbat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.abu.codingbat.entity.enums.PermissionEnum;
import uz.abu.codingbat.entity.template.AbsIntegerEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbsIntegerEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private Set<PermissionEnum> permissions;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    private List<User> users;

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, String description, Set<PermissionEnum> permissions) {
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }
}
