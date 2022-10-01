package uz.abu.codingbat.compile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.abu.codingbat.payload.CaseDTO;

@Getter
@AllArgsConstructor
public class CompileResult {

    private CaseDTO aCase;

    private String userAnswer;

    private boolean isSuccess;



}
