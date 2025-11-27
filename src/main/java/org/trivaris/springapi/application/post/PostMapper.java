package org.trivaris.springapi.application.post;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.trivaris.springapi.domain.post.Post;
import org.trivaris.springapi.presentation.post.dto.PostRequestDto;
import org.trivaris.springapi.presentation.post.dto.PostResponseDto;

@Mapper
public interface PostMapper {
  PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

  PostResponseDto toPostResponseDto(Post post);
}
