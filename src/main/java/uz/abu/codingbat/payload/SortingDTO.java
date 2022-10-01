package uz.abu.codingbat.payload;

import lombok.Getter;
import uz.abu.codingbat.payload.enums.SortingTypeEnum;

@Getter
public class SortingDTO {

    private String name;

    private SortingTypeEnum type;
}
