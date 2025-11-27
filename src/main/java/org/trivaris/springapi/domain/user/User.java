package org.trivaris.springapi.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.trivaris.springapi.domain.post.Post;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String username;
  private String email;

  @OneToMany(mappedBy = "user")
  @ToString.Exclude
  private List<Post> posts = List.of();

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }
}
