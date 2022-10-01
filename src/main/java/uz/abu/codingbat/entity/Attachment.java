package uz.abu.codingbat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import uz.abu.codingbat.entity.template.AbsUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attachment extends AbsUUIDEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String contentType;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "attachment")
    private AttachmentContent attachmentContent;

    public Attachment(String name, Long size, String contentType, AttachmentContent attachmentContent) {
        this.name = name;
        this.size = size;
        this.contentType = contentType;
        this.attachmentContent = attachmentContent;
    }
}
