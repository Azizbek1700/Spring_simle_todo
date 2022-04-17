package uz.bakhodirov.springtemplate.dto.auth;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginDto {

    private String username;

    private String password;
}
