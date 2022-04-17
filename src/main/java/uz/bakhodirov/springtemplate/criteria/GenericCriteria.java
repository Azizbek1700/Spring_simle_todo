package uz.bakhodirov.springtemplate.criteria;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdoc.api.annotations.ParameterObject;

import java.util.Objects;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ParameterObject
public class GenericCriteria {
    private Integer size;
    private Integer page;

    public Integer getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public Integer getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }
}
