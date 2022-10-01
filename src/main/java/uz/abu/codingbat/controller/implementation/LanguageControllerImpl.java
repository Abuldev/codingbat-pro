package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import uz.abu.codingbat.controller.cotract.LanguageController;
import uz.abu.codingbat.payload.AddLanguageDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.LanguageDTO;
import uz.abu.codingbat.payload.ViewDTO;
import uz.abu.codingbat.projection.LanguageDTOProjection;
import uz.abu.codingbat.service.contract.LanguageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LanguageControllerImpl implements LanguageController {

    private final LanguageService languageService;


    @Override
    public ApiResult<LanguageDTO> add(AddLanguageDTO addLanguageDTO) {
        log.info("Add method entered: {}", addLanguageDTO);

        ApiResult<LanguageDTO> result = languageService.add(addLanguageDTO);

        log.info("Add method exited: {}", result);

        return result;
    }

    @Override
    public ApiResult<List<LanguageDTO>> getLanguagesForUser() {
        return languageService.getLanguagesForUser();
    }

    @Override
    public ApiResult<List<LanguageDTOProjection>> getLanguages(ViewDTO viewDTO, int page, int size) {
        return languageService.getLanguagesBySuperMethod(viewDTO, page, size);
    }

    @Override
    public ApiResult<LanguageDTO> getLanguage(Integer id) {
        return languageService.getLanguage(id);
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return languageService.delete(id);
    }

    @Override
    public ApiResult<LanguageDTO> edit(AddLanguageDTO addLanguageDTO, Integer id) {
        return languageService.edit(addLanguageDTO, id);
    }

}
