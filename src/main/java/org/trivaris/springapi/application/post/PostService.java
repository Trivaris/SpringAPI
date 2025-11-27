package org.trivaris.springapi.application.post;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.trivaris.springapi.domain.post.Post;
import org.trivaris.springapi.domain.post.PostRepository;
import org.trivaris.springapi.domain.user.User;

@Service
public class PostService {
  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Optional<Post> getPostById(long id) {
    return postRepository.findById(id);
  }

  public List<Post> getPostsFromUser(User user) {
    return postRepository.findAllByUser(user);
  }

  public Post putPost(String title, String content, User user) {
    var post = new Post(title, content, user);
    return postRepository.save(post);
  }
}
