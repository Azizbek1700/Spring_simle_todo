package uz.bakhodirov.springtemplate.session;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uz.bakhodirov.springtemplate.entity.auth.AuthUser;
import uz.bakhodirov.springtemplate.enums.Role;
import uz.bakhodirov.springtemplate.repository.auth.AuthUserRepository;

import java.time.Duration;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SessionUser {

    private final AuthUserRepository repository;


    public String getUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Long getId() {
        Optional<AuthUser> user = repository.findByUsernameAndDeletedFalse(this.getUsername());
        return user.get().getId();
    }

    public Role getRole(){
        Optional<AuthUser> user = repository.findByUsernameAndDeletedFalse(this.getUsername());
        return user.get().getRole();
    }




}
