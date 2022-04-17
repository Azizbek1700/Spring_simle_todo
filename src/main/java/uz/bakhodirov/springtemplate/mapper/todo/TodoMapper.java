package uz.bakhodirov.springtemplate.mapper.todo;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhodirov.springtemplate.dto.todo.TodoCreateDto;
import uz.bakhodirov.springtemplate.dto.todo.TodoDto;
import uz.bakhodirov.springtemplate.dto.todo.TodoUpdateDto;
import uz.bakhodirov.springtemplate.entity.todo.Todo;
import uz.bakhodirov.springtemplate.mapper.base.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TodoMapper extends BaseMapper<Todo, TodoDto, TodoCreateDto, TodoUpdateDto> {

    @Override
    TodoDto toDto(Todo todo);

    @Override
    List<TodoDto> toDto(List<Todo> e);

    @Override
    Todo fromCreateDto(TodoCreateDto todoCreateDto);

    @Override
    Todo fromUpdateDto(TodoUpdateDto todoUpdateDto);
}
