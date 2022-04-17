package uz.bakhodirov.springtemplate.services.base;

import org.springframework.http.ResponseEntity;
import uz.bakhodirov.springtemplate.dto.base.BaseDto;
import uz.bakhodirov.springtemplate.dto.base.GenericDto;
import uz.bakhodirov.springtemplate.dto.responce.DataDto;
import uz.bakhodirov.springtemplate.entity.base.BaseEntity;

import java.io.Serializable;


/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 * @param <K>  -> class that defines the primary key for your pojo class
 */
public interface GenericCrudService<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto,
        K extends Serializable
        > extends GenericService<D, K> {

    ResponseEntity<DataDto<K>> create(CD createDto);

    ResponseEntity<DataDto<Void>> delete(K id);

    ResponseEntity<DataDto<K>> update(UD updateDto);

}
