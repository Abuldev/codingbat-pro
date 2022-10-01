package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.abu.codingbat.controller.cotract.SectionController;
import uz.abu.codingbat.payload.AddSectionDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.SectionDTO;
import uz.abu.codingbat.payload.ViewDTO;
import uz.abu.codingbat.projection.SectionDTOProjection;
import uz.abu.codingbat.service.contract.SectionService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class SectionControllerImpl implements SectionController {

    private final SectionService sectionService;

    @Override
    public ApiResult<SectionDTO> add(AddSectionDTO sectionDTO) {
        return sectionService.add(sectionDTO);
    }

    @Override
    public ApiResult<List<SectionDTOProjection>> getSections(ViewDTO viewDTO, int page, int size) {
        return sectionService.getSections(viewDTO,page,size);
    }

    @Override
    public ApiResult<SectionDTO> getSection(Integer id) {
        return sectionService.getSection(id);
    }

    @Override
    public ApiResult<?> deleteSection(Integer id) {
        return sectionService.delete(id);
    }

    @Override
    public ApiResult<SectionDTO> editSection(AddSectionDTO sectionDTO, Integer id) {
        return sectionService.edit(sectionDTO,id);
    }

    @Override
    public ApiResult<List<SectionDTO>> getSectionsForUser() {
        return sectionService.getSectionsForUser();
    }
}
