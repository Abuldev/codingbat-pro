package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.abu.codingbat.controller.cotract.RoleController;
import uz.abu.codingbat.entity.enums.PermissionEnum;
import uz.abu.codingbat.payload.AddRoleDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.RoleDTO;
import uz.abu.codingbat.service.implemention.RoleServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl roleService;

    @Override
    public ApiResult<RoleDTO> add(@Valid @RequestBody AddRoleDTO addRoleDTO) {
        return roleService.add(addRoleDTO);
    }

    @Override
    public ApiResult<Boolean> delete(@PathVariable Integer id) {
        return roleService.delete(id);
    }

    @Override
    public ApiResult<List<RoleDTO>> getRoles() {
        return roleService.getRoles();
    }

    @Override
    public ApiResult<PermissionEnum[]> getPermissions() {
        return roleService.getPermissions();
    }
}
