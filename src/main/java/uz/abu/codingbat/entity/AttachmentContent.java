package uz.abu.codingbat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.abu.codingbat.entity.template.AbsUUIDEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AttachmentContent extends AbsUUIDEntity {
    private byte[] content;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    private Attachment attachment;
}
