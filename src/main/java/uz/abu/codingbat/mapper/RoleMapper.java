package uz.abu.codingbat.mapper;

import org.mapstruct.Mapper;
import uz.abu.codingbat.entity.Role;
import uz.abu.codingbat.payload.RoleDTO;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO(Role role);
}
