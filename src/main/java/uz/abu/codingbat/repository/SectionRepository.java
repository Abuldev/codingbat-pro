package uz.abu.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.abu.codingbat.entity.Section;
import uz.abu.codingbat.projection.SectionDTOProjection;

import java.util.List;


public interface SectionRepository extends JpaRepository<Section, Integer> {

    long countAllByLanguageId(Integer languageId);

    Section getByTitle(String title);

    List<Section> getAllByLanguage_Id(Integer languageId);

    void deleteAllByLanguage_Id(Integer languageId);

    boolean existsByLanguageId(Integer id);

    boolean existsByTitle(String title);

    @Query(value = "SELECT * FROM get_result_of_query_section(:query)", nativeQuery = true)
    List<SectionDTOProjection> getSectionsByStringQuery(String query);

//    Object existsByTitleIgnoreCaseAndIdNot(String any);
}
