package org.trivaris.springapi.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.trivaris.springapi.api.dto.UserRequestDto;
import org.trivaris.springapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequestDto> getMethodName(@PathVariable Long id) {
        var dto = userService.getUserById(id);
        return ResponseEntity.ok(dto);
    }

}
