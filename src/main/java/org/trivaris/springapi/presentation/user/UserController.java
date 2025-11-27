package org.trivaris.springapi.presentation.user;

import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import org.trivaris.springapi.application.user.UserMapper;
import org.trivaris.springapi.presentation.user.dto.UserRequestDto;
import org.trivaris.springapi.presentation.user.dto.UserResponseDto;
import org.trivaris.springapi.application.user.UserService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<@NonNull UserResponseDto> getMethodName(@PathVariable Long id) {
    var foundUser = userService.getUserById(id);
    if (foundUser.isPresent()) {
      var user = foundUser.get();
      var response = UserMapper.INSTANCE.toUserResponseDto(user);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/register")
  public ResponseEntity<@NonNull UserResponseDto> addUser(@RequestBody UserRequestDto requestDto) {
    var username = requestDto.username();
    var email = requestDto.email();
    var user = userService.putUser(username, email);
    var responseDto = UserMapper.INSTANCE.toUserResponseDto(user);

    return ResponseEntity.ok(responseDto);
  }
}
