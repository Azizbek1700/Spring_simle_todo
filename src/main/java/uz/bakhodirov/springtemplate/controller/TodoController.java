package uz.bakhodirov.springtemplate.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import uz.bakhodirov.springtemplate.controller.base.AbstractController;
import uz.bakhodirov.springtemplate.dto.responce.DataDto;
import uz.bakhodirov.springtemplate.dto.todo.TodoCreateDto;
import uz.bakhodirov.springtemplate.dto.todo.TodoDto;
import uz.bakhodirov.springtemplate.services.todo.TodoServices;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TodoController extends AbstractController {
    private final TodoServices todoServices;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(PATH + "/todo/create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody TodoCreateDto dto) {
        return todoServices.create(dto);
    }

    @GetMapping(PATH + "/todo/getAll")
    public ResponseEntity<DataDto<List<TodoDto>>> getAll() {
        return todoServices.getAll();
    }

    @GetMapping(PATH + "/todo/get/{id}")
    public ResponseEntity<DataDto<TodoDto>> get(@PathVariable Long id) {
        return todoServices.get(id);
    }

    @GetMapping(PATH + "/todo/delete/{id}")
    public ResponseEntity<DataDto<Void>> delete(@PathVariable Long id) {
        return todoServices.delete(id);
    }





}
