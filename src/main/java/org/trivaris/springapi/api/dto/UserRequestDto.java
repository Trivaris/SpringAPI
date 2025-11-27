package org.trivaris.springapi.api.dto;

import lombok.Builder;

@Builder
public class UserRequestDto {
    private String username;
    private String email;
}
