package co.istad.sm.api.auth.web;

import co.istad.sm.api.auth.AuthService;
import co.istad.sm.base.BastRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/register")
    public BastRest<?> register(@Valid @RequestBody RegisterDto registerDto) {
        authService.register(registerDto);
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("You have register successfully!")
                .timeStamp(LocalDateTime.now())
                .data(registerDto.email())
                .build();
    }

    @PostMapping("/verify")
    public BastRest<?> verify(@RequestParam String email){
        return BastRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Pleas check email and verify!")
                .timeStamp(LocalDateTime.now())
                .data(email)
                .build();
    }
}
