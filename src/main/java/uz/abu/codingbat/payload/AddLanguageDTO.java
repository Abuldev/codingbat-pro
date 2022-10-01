package uz.abu.codingbat.payload;


import lombok.*;
import uz.abu.codingbat.entity.Language;
import uz.abu.codingbat.util.CommonUtils;

import javax.validation.constraints.NotBlank;

/**
 * API DAN CLIENTL LARGA BORADIGAN HAR QANDAY SUCCESS VA ERROR RESPONSE LAR QAYTADIGAN CLASS
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddLanguageDTO {

    @NotBlank(message = "Title must be not blank")
    private String title;

    public Language get() {
        return new Language(title);
    }

    public Language get(Integer id) {
        return new Language(title, CommonUtils.makeUrl(title),id);
    }

}
