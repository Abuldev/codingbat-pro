package uz.abu.codingbat.payload;

import lombok.Getter;
import uz.abu.codingbat.payload.enums.ConditionTypeEnum;

@Getter
public class FilterColumnDTO {

    private String name;

    private ConditionTypeEnum conditionType;

    private String value;

    private String from;

    private String till;
}
