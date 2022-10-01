package uz.abu.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abu.codingbat.entity.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
