package uz.abu.codingbat.service.implemention;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.abu.codingbat.entity.Attachment;
import uz.abu.codingbat.entity.AttachmentContent;
import uz.abu.codingbat.exceptions.RestException;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.AttachmentDTO;
import uz.abu.codingbat.repository.AttachmentContentRepository;
import uz.abu.codingbat.repository.AttachmentRepository;
import uz.abu.codingbat.service.contract.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    @Value("${app.upload.folder}")
    private String UPLOAD_FOLDER_PATH;

    @SneakyThrows
    @Override
    public ApiResult<List<AttachmentDTO>> uploadDB(MultipartHttpServletRequest request) {

        List<AttachmentDTO> attachmentDTOList = new ArrayList<>();

        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()) {
            String key = fileNames.next();
            List<MultipartFile> files = request.getFiles(key);
            for (MultipartFile file : files) {
                Attachment attachment = new Attachment();
                attachment.setName(file.getOriginalFilename());
                attachment.setSize(file.getSize());
                attachment.setContentType(file.getContentType());
                attachment = attachmentRepository.save(attachment);
                attachmentDTOList.add(AttachmentDTO.mapAttachmentToAttachmentDTO(attachment));



                AttachmentContent attachmentContent = new AttachmentContent();
                attachmentContent.setContent(file.getBytes());
                attachmentContent.setAttachment(attachment);
                attachmentContentRepository.save(attachmentContent);
            }
        }

        return ApiResult.successResponse(attachmentDTOList);
    }

    //    @SneakyThrows
    @SneakyThrows
    @Override
    public ApiResult<List<AttachmentDTO>> uploadFS(MultipartHttpServletRequest request) {
        List<AttachmentDTO> attachmentDTOList = new ArrayList<>();

        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()) {
            String key = fileNames.next();
            List<MultipartFile> files = request.getFiles(key);
            for (MultipartFile file : files) {
                Attachment attachment = new Attachment();
                attachment.setName(file.getOriginalFilename());
                attachment.setSize(file.getSize());
                attachment.setContentType(file.getContentType());
                attachment = attachmentRepository.save(attachment);
                attachmentDTOList.add(AttachmentDTO.mapAttachmentToAttachmentDTO(attachment));

                FileCopyUtils.copy(file.getInputStream(),
                        makeFileOutputStream(attachment.getId(), Objects.requireNonNull(file.getOriginalFilename())));
            }
        }

        return ApiResult.successResponse(attachmentDTOList);
    }

    @SneakyThrows
    @Override
    public void loadFromDB(@NonNull UUID id, HttpServletResponse response) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> RestException.restThrow("Such attachment not found", HttpStatus.NOT_FOUND));

//        response.setHeader("Content-disposition", "attachment; filename=\"" + attachment.getName() + "\"");
        response.setHeader("Content-disposition", "inline; filename=\"" + attachment.getName() + "\"");
        response.setHeader("Cache-Control", "max-age=8640000");
        response.setContentLength(attachment.getSize().intValue());
        response.setContentType(attachment.getContentType());
        FileCopyUtils.copy(
                attachment.getAttachmentContent().getContent(),
                response.getOutputStream());
    }


    @SneakyThrows
    @Override
    public void loadFromFS(@NonNull UUID id, HttpServletResponse response) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> RestException.restThrow("Such attachment not found", HttpStatus.NOT_FOUND));

        response.setHeader("Content-disposition", "inline; filename=\"" + attachment.getName() + "\"");
        response.setHeader("Cache-Control", "max-age=8640000");
        response.setContentLength(attachment.getSize().intValue());
        response.setContentType(attachment.getContentType());
        FileCopyUtils.copy(
                makeFileInputStream(attachment.getId(),attachment.getName()),
                response.getOutputStream());
    }

    private FileOutputStream makeFileOutputStream(UUID id, String originalName) throws FileNotFoundException {
        return new FileOutputStream(UPLOAD_FOLDER_PATH + id + originalName.substring(originalName.lastIndexOf(".")));
    }

    private FileInputStream makeFileInputStream(UUID id, String originalName) throws FileNotFoundException {
        return new FileInputStream(UPLOAD_FOLDER_PATH + id + originalName.substring(originalName.lastIndexOf(".")));
    }
}
