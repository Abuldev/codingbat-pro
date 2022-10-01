package uz.abu.codingbat.controller.cotract;


import org.springframework.web.bind.annotation.*;
import uz.abu.codingbat.payload.AddSectionDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.SectionDTO;
import uz.abu.codingbat.payload.ViewDTO;
import uz.abu.codingbat.projection.SectionDTOProjection;
import uz.abu.codingbat.util.RestConstants;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/api/section")
public interface SectionController {

    @PostMapping(path = "/add")
	ApiResult<SectionDTO> add(@Valid @RequestBody AddSectionDTO sectionDTO);

    @PostMapping (path = "/list")
	ApiResult<List<SectionDTOProjection>> getSections(@RequestBody(required = false) ViewDTO viewDTO,
													  @RequestParam(defaultValue = RestConstants.DEFAULT_PAGE_NUMBER) int page,
													  @RequestParam(defaultValue = RestConstants.DEFAULT_PAGE_SIZE) int size);

    @GetMapping(path = "/{id}")
	ApiResult<SectionDTO> getSection(@PathVariable Integer id);

    @DeleteMapping(path = "/{id}")
	ApiResult<?> deleteSection(@PathVariable Integer id);

    @PutMapping(path = "/{id}")
	ApiResult<SectionDTO> editSection(@RequestBody @Valid AddSectionDTO sectionDTO,
									  @PathVariable Integer id);

    @GetMapping(path = "list-for-users")
	ApiResult<List<SectionDTO>> getSectionsForUser();
}
