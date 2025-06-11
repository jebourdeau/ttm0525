package initiativep.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long userId;
    private String username;

    public JwtAuthenticationResponse(String accessToken, String tokenType, Long userId, String username) {
        this.accessToken = accessToken;
        this.tokenType= tokenType;
        this.userId= userId;
        this.username= username;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getTokenType() {
        return tokenType;
    }
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}