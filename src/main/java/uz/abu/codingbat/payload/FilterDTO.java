package uz.abu.codingbat.payload;

import lombok.Getter;
import uz.abu.codingbat.payload.enums.OperatorTypeEnum;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FilterDTO {

    private OperatorTypeEnum operatorType;//AND, OR

    private List<FilterColumnDTO> columns = new ArrayList<>();
}
