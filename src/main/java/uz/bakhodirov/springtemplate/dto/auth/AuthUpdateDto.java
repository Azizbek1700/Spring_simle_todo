package uz.bakhodirov.springtemplate.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.bakhodirov.springtemplate.dto.base.GenericDto;
import uz.bakhodirov.springtemplate.enums.Role;


import javax.validation.constraints.NotBlank;

@Getter
@Setter

public class AuthUpdateDto extends GenericDto {

    @NotBlank
    private String fullName;

    @NotBlank
    private String username;

    @NotBlank
    private String phoneNumber;


    private Role role;
}
