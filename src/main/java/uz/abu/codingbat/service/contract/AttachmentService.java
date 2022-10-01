package uz.abu.codingbat.service.contract;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.AttachmentDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

public interface AttachmentService {
    ApiResult<List<AttachmentDTO>> uploadDB(MultipartHttpServletRequest request);

    ApiResult<List<AttachmentDTO>> uploadFS(MultipartHttpServletRequest request);

    void loadFromDB(UUID id, HttpServletResponse response);

    void loadFromFS(UUID id, HttpServletResponse response);
}
