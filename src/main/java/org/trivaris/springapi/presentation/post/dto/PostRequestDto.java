package org.trivaris.springapi.presentation.post.dto;

public record PostRequestDto (Long authorId, String date, String title, String content) {}
