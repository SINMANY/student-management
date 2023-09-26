package co.istad.sm.api.auth;

import co.istad.sm.api.auth.web.RegisterDto;
import co.istad.sm.api.user.User;
import co.istad.sm.api.user.UserMapStruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImp implements AuthService {

    private final AuthMapper authMapper;
    private final UserMapStruct userMapStruct;
    private final PasswordEncoder encoder;

    @Override
    public void register(RegisterDto registerDto) {
        User user = userMapStruct.registerDtoToUser(registerDto);
//        log.info("User: {}", user.getEmail());
        user.setIsVerified(false);
        user.setPassword(encoder.encode(user.getPassword()));
        authMapper.register(user);
    }

    @Override
    public void verify(String email) {

    }
}
