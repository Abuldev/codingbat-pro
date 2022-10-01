package uz.abu.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abu.codingbat.entity.AttachmentContent;

import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
}
