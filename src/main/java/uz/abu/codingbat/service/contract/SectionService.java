package uz.abu.codingbat.service.contract;

import uz.abu.codingbat.payload.AddSectionDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.SectionDTO;
import uz.abu.codingbat.payload.ViewDTO;
import uz.abu.codingbat.projection.SectionDTOProjection;

import java.util.List;

public interface SectionService {
    ApiResult<SectionDTO> add(AddSectionDTO sectionDTO);

    ApiResult<SectionDTO> getSection(Integer id);

    ApiResult<?> delete(Integer id);

    ApiResult<SectionDTO> edit(AddSectionDTO addSectionDTO, Integer id);

    ApiResult<List<SectionDTOProjection>> getSections(ViewDTO viewDTO, int page, int size);

    ApiResult<List<SectionDTO>> getSectionsForUser();


}
