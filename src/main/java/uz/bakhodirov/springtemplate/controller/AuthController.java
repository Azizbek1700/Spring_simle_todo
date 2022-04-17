package uz.bakhodirov.springtemplate.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import uz.bakhodirov.springtemplate.controller.base.AbstractController;
import uz.bakhodirov.springtemplate.dto.auth.*;
import uz.bakhodirov.springtemplate.dto.file.UploadsDto;
import uz.bakhodirov.springtemplate.dto.responce.AppErrorDto;
import uz.bakhodirov.springtemplate.dto.responce.DataDto;
import uz.bakhodirov.springtemplate.services.auth.AuthUserService;


import javax.servlet.http.HttpServletRequest;
import java.nio.file.NoSuchFileException;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class AuthController extends AbstractController {
    private final AuthUserService authUserService;

    @PostMapping(value = PATH+"/auth/upload",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<DataDto<String>> uploadPicture(@RequestParam("picture") MultipartFile picture, WebRequest request){
        try {
            authUserService.savePicture(picture);
            return new ResponseEntity<>(new DataDto<>("successfully uploaded "),HttpStatus.OK);
        }
        catch (Exception e){
            AppErrorDto dto=new AppErrorDto();
            dto.setCode("417");
            dto.setStatus(HttpStatus.EXPECTATION_FAILED.value());
            dto.setMessage("Could not upload the file: " + picture.getOriginalFilename() + "!");
            dto.setPath(request.getContextPath());
            dto.setTimestamp(new Timestamp(new Date().getTime()));
            return new ResponseEntity<>(new DataDto<>(dto),HttpStatus.OK);
        }

    }

@GetMapping(PATH+"/auth/picture/{path}")
    public ResponseEntity<DataDto<String>> getPicture(@PathVariable String path ) throws NoSuchFileException {
        DataDto<UploadsDto> picture = authUserService.getPicture(path);
        System.out.println(picture.getData().getNewName());
        return new ResponseEntity<>(new DataDto<>(picture.getData().getNewName()),HttpStatus.OK);

    }

    @GetMapping(PATH+"/auth/profile")
    public ResponseEntity<DataDto<AuthDto>>profile(){
        return new ResponseEntity<>(authUserService.get(),HttpStatus.OK);
    }

    @PostMapping(PATH + "/auth/login")
    public ResponseEntity<DataDto<SessionDto>> login(@RequestBody AuthUserDto loginDto) {
        return new ResponseEntity<>(authUserService.login(loginDto),HttpStatus.OK);
    }

    @Secured(value = "ADMIN")
    @PostMapping(PATH+"/auth/create")
    public ResponseEntity<DataDto<Long>>create(@RequestBody AuthCreateDto dto){
        return new ResponseEntity<>(authUserService.createUser(dto), HttpStatus.OK);
    }

    @PostMapping(PATH+"/auth/refresh")
    public ResponseEntity<DataDto<SessionDto>>refreshToken(@RequestBody AuthRefreshToken token, HttpServletRequest request){
        return new ResponseEntity<>(authUserService.refreshToken(token.getToken(),request),HttpStatus.OK);
    }

    @PatchMapping(PATH+"/auth/update")
    public  ResponseEntity<DataDto<Long>>update(@RequestBody AuthUpdateDto dto){
        return new ResponseEntity<>(authUserService.update(dto),HttpStatus.OK);
    }

    @DeleteMapping(PATH+"/auth/delete")
    public void delete(@RequestParam Long id,@RequestParam Long adminId){
        authUserService.delete(id,adminId);
    }
}
