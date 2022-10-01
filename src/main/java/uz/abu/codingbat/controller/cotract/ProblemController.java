package uz.abu.codingbat.controller.cotract;

import org.springframework.web.bind.annotation.*;
import uz.abu.codingbat.payload.AddProblemDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.ProblemDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(path = ProblemController.BASE_PATH)
public interface ProblemController {
    String BASE_PATH = "/api/problem";
    String GET_BY_SECTION_ID = "/by-section/{sectionId}";
    String GET_BY_ID = "/{id}";
    String PUT_BY_ID = "/{id}";
    String DELETE_BY_ID = "/{id}";
    String DELETE_BY_SECTION_ID = "/all-by-section/{sectionId}";

    @GetMapping(GET_BY_SECTION_ID)
	ApiResult<List<ProblemDTO>> getAllBySectionId(@Valid @NotNull @PathVariable Integer sectionId);

    @GetMapping(GET_BY_ID)
	ApiResult<ProblemDTO> getById(@Valid @NotNull @PathVariable Integer id);

    @PostMapping
	ApiResult<ProblemDTO> add(@Valid @NotNull @RequestBody AddProblemDTO addProblemDTO);

    @PutMapping(PUT_BY_ID)
	ApiResult<ProblemDTO> update(@Valid @NotNull @PathVariable Integer id, @Valid @NotNull  @RequestBody AddProblemDTO AddProblemDTO);

    @DeleteMapping(DELETE_BY_ID)
    void deleteById(@Valid @NotNull @PathVariable Integer id);

    @DeleteMapping(DELETE_BY_SECTION_ID)
    void deleteAllBySectionId(@Valid @NotNull @PathVariable Integer sectionId);


}
