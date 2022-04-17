package uz.bakhodirov.springtemplate.services.todo;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.bakhodirov.springtemplate.criteria.GenericCriteria;
import uz.bakhodirov.springtemplate.dto.responce.AppErrorDto;
import uz.bakhodirov.springtemplate.dto.responce.DataDto;
import uz.bakhodirov.springtemplate.dto.todo.TodoCreateDto;
import uz.bakhodirov.springtemplate.dto.todo.TodoDto;
import uz.bakhodirov.springtemplate.dto.todo.TodoUpdateDto;
import uz.bakhodirov.springtemplate.entity.todo.Todo;
import uz.bakhodirov.springtemplate.enums.Role;
import uz.bakhodirov.springtemplate.mapper.todo.TodoMapper;
import uz.bakhodirov.springtemplate.repository.todo.TodoRepository;
import uz.bakhodirov.springtemplate.repository.auth.AuthUserRepository;
import uz.bakhodirov.springtemplate.services.base.AbstractService;
import uz.bakhodirov.springtemplate.services.base.GenericCrudService;
import uz.bakhodirov.springtemplate.session.SessionUser;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServices extends AbstractService<TodoRepository, TodoMapper>
        implements GenericCrudService<Todo, TodoDto, TodoCreateDto, TodoUpdateDto, Long> {
    public TodoServices(TodoRepository repository, TodoMapper mapper, AuthUserRepository authUserRepository, SessionUser sessionUser) {
        super(repository, mapper);
        this.sessionUser = sessionUser;
    }

    private final SessionUser sessionUser;

    @Override
    public ResponseEntity<DataDto<Long>> create(TodoCreateDto createDto) {

        boolean checkName = repository.existsByNameAndDeletedFalse(createDto.getName());
        if (checkName) {
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.CONFLICT, "todo already taken", "todo")), HttpStatus.OK);
        }
        Todo todo = mapper.fromCreateDto(createDto);

        todo.setUserId(sessionUser.getId());
        repository.save(todo);
        return new ResponseEntity<>(new DataDto<>(repository.save(todo).getId()), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<DataDto<Void>> delete(Long id) {
        Optional<Todo> checkId = repository.findByIdAndDeletedFalse(id);

        if (checkId.isEmpty()) {
            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "todo Not  found", "todo")), HttpStatus.OK);
        }

        if (!sessionUser.getRole().equals(Role.ADMIN)) {

            Optional<Todo> todoOptional = repository.findByIdUserTodo(id, sessionUser.getId());

            if (todoOptional.isEmpty()) {

                return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "todo Not  found", "todo")), HttpStatus.OK);
            }

        }
        repository.deletedTodo(id);


        return new ResponseEntity<>(new DataDto<>(true), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<DataDto<Long>> update(TodoUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDto<List<TodoDto>>> getAll() {
        List<Todo> todoList;
        if (sessionUser.getRole().equals(Role.ADMIN)) {
            todoList = repository.findAllByDeletedFalse();
        } else {

            todoList = repository.findAllTodo(sessionUser.getId());
        }
        List<TodoDto> todoDtos = mapper.toDto(todoList);
        return new ResponseEntity<>(new DataDto<>(todoDtos), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDto<TodoDto>> get(Long id) {
        Optional<Todo> todoOptional = repository.findByIdUserTodo(id, sessionUser.getId());
        if (todoOptional.isEmpty()) {

            return new ResponseEntity<>(new DataDto<>(new AppErrorDto(HttpStatus.NOT_FOUND, "todo Not  found", "todo")), HttpStatus.OK);
        }
        TodoDto todoDto = mapper.toDto(todoOptional.get());

        return new ResponseEntity<>(new DataDto<>(todoDto), HttpStatus.OK);

    }


    public ResponseEntity<DataDto<List<TodoDto>>> getAllCriteria(GenericCriteria criteria) {
        PageRequest pageRequest = PageRequest.of( criteria.getPage(), criteria.getSize() );
        List<Todo> studentList = repository.findAll( pageRequest ).toList();
        return new ResponseEntity<>( new DataDto<>( mapper.toDto( studentList ), (long) studentList.size() ), HttpStatus.OK );
    }
}
