package uz.abu.codingbat.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.abu.codingbat.compile.CompileResult;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompileDTO {

    private UserProblemDTO userProblemDTO;

    private List<CompileResult> compileResultList;

    private String errorMessage;

    public CompileDTO(UserProblemDTO userProblemDTO, List<CompileResult> compileResultList) {
        this.userProblemDTO = userProblemDTO;
        this.compileResultList = compileResultList;
    }

    public CompileDTO(UserProblemDTO userProblemDTO, String  errorMessage) {
        this.userProblemDTO = userProblemDTO;
        this.errorMessage = errorMessage;

    }
}
