package uz.abu.codingbat.service.contract;

import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.ProblemDTO;

import java.util.List;

public interface ProblemService {
    ApiResult<List<ProblemDTO>> getAllProblemsBySectionId(Integer sectionId);

    ApiResult<ProblemDTO> getProblemById(Integer id);

    ApiResult<ProblemDTO> addProblem(ProblemDTO problemDTO);

    ApiResult<ProblemDTO> updateProblemById(Integer id, ProblemDTO problemDTO);

    void deleteById(Integer id);

    void deleteAllBySectionId(Integer sectionId);
}
