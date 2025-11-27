package org.trivaris.springapi.service;

import org.springframework.stereotype.Service;
import org.trivaris.springapi.api.dto.UserRequestDto;
import org.trivaris.springapi.data.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserRequestDto getUserById(Long id) {
    var user = userRepository.findById(id).orElseThrow();
    return UserRequestDto.builder()
        .username(user.getUsername())
        .email(user.getEmail())
        .build();
  }

}
