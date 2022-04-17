package uz.bakhodirov.springtemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import uz.bakhodirov.springtemplate.dto.responce.AppErrorDto;
import uz.bakhodirov.springtemplate.dto.responce.DataDto;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<DataDto<AppErrorDto>> http(RuntimeException e, WebRequest request) {
        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR)), HttpStatus.OK);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<DataDto<AppErrorDto>> notFound(NotFoundException e, WebRequest request) {
        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(),request, HttpStatus.NOT_FOUND)),HttpStatus.OK);
    }


}
