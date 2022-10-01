package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import uz.abu.codingbat.controller.cotract.ProblemController;
import uz.abu.codingbat.payload.AddProblemDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.ProblemDTO;
import uz.abu.codingbat.service.contract.ProblemService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProblemControllerImp implements ProblemController {

    private final ProblemService service;

    public ApiResult<List<ProblemDTO>> getAllBySectionId(Integer sectionId) {
        return service.getAllProblemsBySectionId(sectionId);
    }


    public ApiResult<ProblemDTO> getById(Integer id) {
        return service.getProblemById(id);
    }

    @PreAuthorize(value = "hasAnyAuthority('ADD_LANGUAGE')")
    public ApiResult<ProblemDTO> add(AddProblemDTO addProblemDTO) {

        return service.addProblem(AddProblemDTO.convert(addProblemDTO));
    }

    public ApiResult<ProblemDTO> update(Integer id, AddProblemDTO addProblemDTO) {
        return service.updateProblemById(id, AddProblemDTO.convert(addProblemDTO));
    }

    public void deleteById(Integer id) {
        service.deleteById(id);
    }

    public void deleteAllBySectionId(Integer sectionId) {
        service.deleteAllBySectionId(sectionId);
    }
}
