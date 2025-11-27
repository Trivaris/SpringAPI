package org.trivaris.springapi.domain.post;

import java.util.List;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trivaris.springapi.domain.user.User;

@Repository
public interface PostRepository extends JpaRepository<@NonNull Post, @NonNull Long> {
  List<Post> findAllByUser(@NonNull User user);
}
