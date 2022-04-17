package uz.bakhodirov.springtemplate.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.bakhodirov.springtemplate.dto.base.GenericDto;
import uz.bakhodirov.springtemplate.enums.Role;


@Getter
@Setter
public class AuthDto extends GenericDto {

    private String fullName;

    private String username;

    private String phoneNumber;

    private Long organizationId;

    private String picturePath;

    private Role role;

}
