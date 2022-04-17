//package uz.bakhodirov.springtemplate.config.testSecirity;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import uz.bakhodirov.springtemplate.entity.auth.AuthUser;
//import uz.bakhodirov.springtemplate.enums.Role;
//import uz.bakhodirov.springtemplate.repository.auth.AuthUserRepository;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Service
//@RequiredArgsConstructor
//public class UserService implements UserDetailsService {
//
//    private final AuthUserRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AuthUser authUser = repository.findByUsernameAndDeletedFalse(username).orElseThrow(() -> {
//            throw new RuntimeException("user not found");
//        });
//        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
//        ArrayList<Role> roles=new ArrayList<>();
//        roles.forEach(role -> {
//
//            authorities.add(new SimpleGrantedAuthority(role.name()));
//        });
//
//        return User.builder()
//                .username(authUser.getUsername())
//                .password(authUser.getPassword())
//                .authorities(new SimpleGrantedAuthority(authUser.getRole().name()))
//                .build();
//    }
//}
