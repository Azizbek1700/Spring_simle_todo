package uz.bakhodirov.springtemplate.dto.todo;

import lombok.Data;
import uz.bakhodirov.springtemplate.dto.base.BaseDto;

@Data
public class TodoCreateDto implements BaseDto {
    private String name;
    private String description;

}
