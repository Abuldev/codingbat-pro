package uz.abu.codingbat.entity.template;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class AbsTitleIntegerEntity extends AbsIntegerEntity {
    @Column(nullable = false)
    private String title;
}
