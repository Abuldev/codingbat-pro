package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.abu.codingbat.controller.cotract.UserProblemController;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.CompileDTO;
import uz.abu.codingbat.payload.UserProblemDTO;
import uz.abu.codingbat.payload.UserProblemRequestDTO;
import uz.abu.codingbat.service.contract.UserProblemService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserProblemControllerImpl implements UserProblemController {

    private final UserProblemService userProblemService;

    @Override
    public ApiResult<UserProblemDTO> getUserProblem(@NotNull(message = "user id must be not null") UUID userId,
													@NotNull(message = "problem id must be not null") Integer problemId) {
        return userProblemService.get(userId, problemId);
    }

    @Override
    public ApiResult<CompileDTO> solveProblem(UserProblemRequestDTO userProblemDTO) {
        return userProblemService.solveProblemByUser(userProblemDTO);
    }

    @Override
    public ApiResult<List<UserProblemDTO>> getUserProblems() {
        return userProblemService.getAllProblems();
    }

}
