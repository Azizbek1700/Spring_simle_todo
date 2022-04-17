package uz.bakhodirov.springtemplate.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhodirov.springtemplate.dto.base.BaseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthCreateDto implements BaseDto {

    @NotBlank
    private Long organizationId;

    @NotBlank
    private String fullName;

    @NotBlank
    private String username;

    @NotBlank
    @Pattern(regexp = "[+998][0-9]{9}]")
    private String phoneNumber;

    @NotBlank
    private String password;

    @NotBlank
    private String role;

}
