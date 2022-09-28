package com.momen.food.user;


import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/User/v1")
public class UserController {

    private final UserService service;
    private UserMapper mapper;

    @PostMapping
    @RolesAllowed({"admin", "user"})
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @RolesAllowed({"admin", "user"})
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        val dto = mapper.toUserDTO(service.update(user));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    @RolesAllowed({"admin", "supplier", "user"})
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User user = service.getById(id);
        UserDTO userDTO = mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping()
    @Timed("user.getAll")
    @RolesAllowed("admin")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> users = service.getAll();
        List<UserDTO> usersDto = mapper.toUserDTOs(users);

        return ResponseEntity.ok(usersDto);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({"admin"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
