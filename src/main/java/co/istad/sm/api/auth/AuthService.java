package co.istad.sm.api.auth;

import co.istad.sm.api.auth.web.RegisterDto;

public interface AuthService {
    void register(RegisterDto registerDto);

    void verify(String email);
}
