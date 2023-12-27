package article.WebIde.api.controller;


import article.WebIde.api.dto.MemberRequestDto;
import article.WebIde.api.dto.MemberResponseDto;
import article.WebIde.api.dto.TokenDto;
import article.WebIde.api.dto.TokenRequestDto;
import article.WebIde.api.dto.util.InvalidPasswordException;
import article.WebIde.api.dto.util.PasswordValidator;
import article.WebIde.api.service.AuthService;
import article.WebIde.api.util.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins="*", allowedHeaders = "*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody MemberRequestDto memberRequestDto) {
        try {
            // 비밀번호 유효성 검사
            PasswordValidator.validatePassword(memberRequestDto.getPassword());

            ResponseEntity<MemberResponseDto> response = authService.signup(memberRequestDto);
            return ResponseEntity.ok(response.getBody());
        } catch (InvalidPasswordException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("이메일이 중복되어 사용할 수 없습니다."));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto){
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto){
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }

    @GetMapping("/connectChk")
    public ResponseEntity<String> reissue(){
        return ResponseEntity.ok("연결성공!");
    }
}
