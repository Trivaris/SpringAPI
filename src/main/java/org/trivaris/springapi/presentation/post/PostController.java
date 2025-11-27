package org.trivaris.springapi.presentation.post;

import java.util.List;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trivaris.springapi.application.post.PostMapper;
import org.trivaris.springapi.application.post.PostService;
import org.trivaris.springapi.application.user.UserService;
import org.trivaris.springapi.presentation.post.dto.PostRequestDto;
import org.trivaris.springapi.presentation.post.dto.PostResponseDto;

@RestController
@RequestMapping("/posts")
public class PostController {
  private final PostService postService;
  private final UserService userService;

  public PostController(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @PutMapping("/upload")
  public ResponseEntity<@NonNull PostResponseDto> putPost(@RequestBody PostRequestDto dto) {
    var user = userService.getUserById(dto.authorId());
    if (user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    var post = postService.putPost(dto.title(), dto.content(), user.get());
    var response = PostMapper.INSTANCE.toPostResponseDto(post);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/show/{authorId}")
  public ResponseEntity<@NonNull List<PostResponseDto>> getAllPosts(@PathVariable Long authorId) {
    var user = userService.getUserById(authorId);
    if (user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    var posts = postService.getPostsFromUser(user.get());
    var response = posts.stream().map(PostMapper.INSTANCE::toPostResponseDto).toList();
    return ResponseEntity.ok(response);
  }
}
