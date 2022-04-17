package uz.bakhodirov.springtemplate.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhodirov.springtemplate.dto.auth.AuthCreateDto;
import uz.bakhodirov.springtemplate.dto.auth.AuthDto;
import uz.bakhodirov.springtemplate.dto.auth.AuthUpdateDto;
import uz.bakhodirov.springtemplate.entity.auth.AuthUser;
import uz.bakhodirov.springtemplate.mapper.base.BaseMapper;


@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<AuthUser, AuthDto, AuthCreateDto, AuthUpdateDto> {
}
