package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.abu.codingbat.controller.cotract.AttachmentController;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.AttachmentDTO;
import uz.abu.codingbat.service.contract.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AttachmentControllerImpl implements AttachmentController {

    private final AttachmentService attachmentService;

    @Override
    public ApiResult<List<AttachmentDTO>> uploadDB(MultipartHttpServletRequest request) {
        return attachmentService.uploadDB(request);
    }

    @Override
    public ApiResult<List<AttachmentDTO>> uploadFS(MultipartHttpServletRequest request) {
        return attachmentService.uploadFS(request);
    }

    @Override
    public void getFileFromDB(UUID id, HttpServletResponse response) {
        attachmentService.loadFromDB(id,response);
    }

    @Override
    public void getFileFromFS(UUID id, HttpServletResponse response) {
        attachmentService.loadFromFS(id,response);
    }
}
