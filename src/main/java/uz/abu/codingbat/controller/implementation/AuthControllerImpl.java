package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.abu.codingbat.controller.cotract.AuthController;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.SignDTO;
import uz.abu.codingbat.payload.TokenDTO;
import uz.abu.codingbat.service.contract.AuthService;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@Slf4j
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;

    public ApiResult<Boolean> signUp(@RequestBody @Valid SignDTO signDTO) {
        log.info("SIgn up method entered: {}", signDTO);
        ApiResult<Boolean> apiResult = authService.signUp(signDTO);
        log.info("SIgn up method exited: {}", apiResult);
        return apiResult;
    }

    public ApiResult<?> verificationEmail(@PathVariable String email) {
        log.info("SIgn in method entered: {}", email);
        return authService.verificationEmail(email);
    }

    @Override
    public ApiResult<TokenDTO> signIn(SignDTO signDTO) {
        log.info("SIgn in method entered: {}", signDTO);
        ApiResult<TokenDTO> apiResult = authService.signIn(signDTO);
        log.info("SIgn in method exited: {}", apiResult);
        return apiResult;
    }

    @Override
    public ApiResult<TokenDTO> refreshToken(String accessToken, String refreshToken) {
        return authService.refreshToken(accessToken,refreshToken);
    }
}
