package uz.bakhodirov.springtemplate.services.base;

import org.springframework.http.ResponseEntity;
import uz.bakhodirov.springtemplate.dto.base.BaseDto;
import uz.bakhodirov.springtemplate.dto.responce.DataDto;


import java.io.Serializable;
import java.util.List;


/**
 * @param <D> DTO
 * @param <K> Id Long
 */
public interface GenericService<
        D extends BaseDto,
        K extends Serializable
        > extends BaseService {


    ResponseEntity<DataDto<List<D>>> getAll();

    ResponseEntity<DataDto<D>> get(K id);
}
