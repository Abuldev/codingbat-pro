package uz.abu.codingbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.abu.codingbat.payload.*;
import uz.abu.codingbat.service.implemention.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/edit")
    @PreAuthorize(value = "hasAnyAuthority('EDIT_ROLE')")
    public ApiResult<Boolean> editRole(@RequestBody UserDTO userDTO) {
        return userService.editRole(userDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('DELETE_USER')")
    public ApiResult<Boolean> delete(@PathVariable UUID id) {
        return userService.delete(id);
    }

    @GetMapping("/list")
    @PreAuthorize(value = "hasAnyAuthority('GET_USERS')")
    public ApiResult<List<UserListDTO>> getListOfUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{roleId}")
    @PreAuthorize(value = "hasAnyAuthority('GET_USERS')")
    public ApiResult<List<UserListDTO>> getUsersWithRole(@PathVariable Integer roleId) {
        return userService.getUsersWithRole(roleId);
    }

    @PostMapping("/user-me")
    public ApiResult<RoleDTO> userMe(@Valid @RequestBody UserMe userMe) {
        return userService.userMe(userMe);
    }

}
