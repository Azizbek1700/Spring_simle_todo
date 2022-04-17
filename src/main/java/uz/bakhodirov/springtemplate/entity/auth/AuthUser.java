package uz.bakhodirov.springtemplate.entity.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import uz.bakhodirov.springtemplate.entity.base.Auditable;
import uz.bakhodirov.springtemplate.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
public class AuthUser extends Auditable  {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    private String picturePath;


    @Column(nullable = false)
    private Long organizationId;

    @Enumerated(EnumType.STRING)
    private Role role;


}
