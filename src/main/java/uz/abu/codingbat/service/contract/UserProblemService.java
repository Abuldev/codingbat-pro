package uz.abu.codingbat.service.contract;

import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.CompileDTO;
import uz.abu.codingbat.payload.UserProblemDTO;
import uz.abu.codingbat.payload.UserProblemRequestDTO;

import java.util.List;
import java.util.UUID;

public interface UserProblemService {

    ApiResult<UserProblemDTO> get(UUID userId, Integer problemId);

    ApiResult<CompileDTO> solveProblemByUser(UserProblemRequestDTO userProblemDTO);

    ApiResult<List<UserProblemDTO>> getAllProblems();
}
