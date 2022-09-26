package flowerShop.web.dto;

import javax.validation.constraints.NotBlank;

public class AuthUserDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    public AuthUserDto() {}

    public String getUsername() { return userName; }

    public void setUsername(String username) { this.userName = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
