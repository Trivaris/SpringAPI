package org.trivaris.springapi.application.user;

import java.util.List;
import org.springframework.stereotype.Service;
import org.trivaris.springapi.domain.user.User;
import org.trivaris.springapi.domain.user.UserRepository;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User putUser(String username, String email) {
    var user = new User(username, email);
    userRepository.save(user);
    return user;
  }
}
