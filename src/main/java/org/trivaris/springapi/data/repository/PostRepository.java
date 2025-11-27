package org.trivaris.springapi.data.repository;

import java.util.List;
import org.h2.engine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trivaris.springapi.data.object.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  Post findFirstById(int id);

  List<Post> findByUserId(int userId);

  List<Post> findByUser(User user);
}
