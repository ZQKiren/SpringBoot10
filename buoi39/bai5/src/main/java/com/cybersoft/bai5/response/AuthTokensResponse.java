package com.cybersoft.bai5.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokensResponse {
    private String tokenType;
    private String accessToken;
    private String refreshToken;
}
