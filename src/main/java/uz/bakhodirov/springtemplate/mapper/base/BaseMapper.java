package uz.bakhodirov.springtemplate.mapper.base;

import uz.bakhodirov.springtemplate.dto.base.BaseDto;
import uz.bakhodirov.springtemplate.dto.base.GenericDto;
import uz.bakhodirov.springtemplate.entity.base.BaseEntity;

import java.util.List;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 */

public interface BaseMapper<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto>{

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD ud);

}