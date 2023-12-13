package article.WebIde.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long accessTokenExpiresIn;
    private String refreshToken;
    private String token;

    public String getRefreshToken(){
        return null;
    }
}
