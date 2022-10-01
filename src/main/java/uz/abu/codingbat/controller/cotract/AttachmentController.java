package uz.abu.codingbat.controller.cotract;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.AttachmentDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

//@RequestMapping(value = AttachmentController.BASE_PATH)
public interface AttachmentController {

    String BASE_PATH = "/api/attachment";

//    @PostMapping("/upload-db")
    ApiResult<List<AttachmentDTO>> uploadDB(MultipartHttpServletRequest request);

//    @PostMapping("/upload-file-system")
    ApiResult<List<AttachmentDTO>> uploadFS(MultipartHttpServletRequest request);


//    @GetMapping("/load-db/{id}")
    void getFileFromDB(@PathVariable UUID id, HttpServletResponse response);


//    @GetMapping("/load-fs/{id}")
    void getFileFromFS(@PathVariable UUID id, HttpServletResponse response);


}

