package uz.abu.codingbat.service.contract;

import uz.abu.codingbat.payload.AddLanguageDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.LanguageDTO;
import uz.abu.codingbat.payload.ViewDTO;
import uz.abu.codingbat.projection.LanguageDTOProjection;

import java.util.List;

public interface LanguageService {
    ApiResult<List<LanguageDTOProjection>> getLanguagesBySuperMethod(ViewDTO viewDTO, int page, int size);

    ApiResult<LanguageDTO> add(AddLanguageDTO addLanguageDTO);

    ApiResult<LanguageDTO> getLanguage(Integer id);

    ApiResult<?> delete(Integer id);

    ApiResult<LanguageDTO> edit(AddLanguageDTO addLanguageDTO, Integer id);

    ApiResult<List<LanguageDTO>> getLanguagesForUser();

}
