package uz.abu.codingbat.service.contract;

import uz.abu.codingbat.entity.enums.PermissionEnum;
import uz.abu.codingbat.payload.AddRoleDTO;
import uz.abu.codingbat.payload.ApiResult;
import uz.abu.codingbat.payload.RoleDTO;

import java.util.List;

public interface RoleService {

    ApiResult<RoleDTO> add(AddRoleDTO addRoleDTO);

    ApiResult<Boolean> delete(Integer id);

    ApiResult<List<RoleDTO>> getRoles();

    ApiResult<PermissionEnum[]> getPermissions();
}
