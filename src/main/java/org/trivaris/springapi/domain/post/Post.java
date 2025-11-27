package org.trivaris.springapi.domain.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.trivaris.springapi.domain.user.User;

@Getter
@NoArgsConstructor
@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @CreationTimestamp
  private Date created;

  private String title;
  private String content;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Post(String title, String content, User user) {
    this.title = title;
    this.content = content;
    this.user = user;
  }
}
