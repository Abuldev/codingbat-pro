package uz.abu.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abu.codingbat.entity.Case;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case,Long> {
    void deleteAllByProblem_Id(Integer problemId);

    List<Case> getAllByProblemId(Integer problemId);

    void deleteCasesByProblem_Id(Integer id);
}
