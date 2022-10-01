package uz.abu.codingbat.payload;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddSectionDTO{

    private String title;

    private String description;

    private Integer maxRate;

    private Integer languageId;

    public AddSectionDTO(String title) {
        this.title = title;
    }


    public AddSectionDTO(String title, String description, Integer maxRate, Integer languageId) {
        this.title = title;
        this.description = description;
        this.maxRate = maxRate;
        this.languageId = languageId;
    }

    public AddSectionDTO(String title, Integer languageId) {
        this.title = title;
        this.languageId = languageId;
    }

}
