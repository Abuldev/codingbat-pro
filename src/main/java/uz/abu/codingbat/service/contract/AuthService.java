package uz.abu.codingbat.service.contract;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.SignDTO;
import uz.abu.codingbat.payload.TokenDTO;


public interface AuthService extends UserDetailsService {
    ApiResult<Boolean> signUp(SignDTO signDTO);

    ApiResult<?> verificationEmail(String email);

    ApiResult<TokenDTO> signIn(SignDTO signDTO);

    ApiResult<TokenDTO> refreshToken(String accessToken, String refreshToken);
}
