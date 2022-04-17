package uz.bakhodirov.springtemplate.dto.todo;

import lombok.Data;
import uz.bakhodirov.springtemplate.dto.base.GenericDto;

@Data
public class TodoDto extends GenericDto {
    private String name;
    private String description;

}
