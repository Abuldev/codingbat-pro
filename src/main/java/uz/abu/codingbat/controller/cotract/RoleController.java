package uz.abu.codingbat.controller.cotract;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.abu.codingbat.entity.enums.PermissionEnum;
import uz.abu.codingbat.payload.AddRoleDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.RoleDTO;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = RoleController.ROLE_BASE_PATH)
@PreAuthorize(value = "hasAnyAuthority('EDIT_ROLE')")
public interface RoleController {
    String ROLE_BASE_PATH = "/api/role";

    @PostMapping
	ApiResult<RoleDTO> add(@Valid @RequestBody AddRoleDTO addRoleDTO);


    @DeleteMapping("/{id}")
	ApiResult<Boolean> delete(@PathVariable Integer id);

    @GetMapping("/list")
	ApiResult<List<RoleDTO>> getRoles();

    @GetMapping("permissions-for-role")
	ApiResult<PermissionEnum[]> getPermissions();

}
