package co.istad.sm.api.auth.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDto(@NotBlank(message = "Email is required!") @Email String email,
                          @NotBlank(message = "Password is required!") String password,
                          @NotBlank(message = "Confirm password is required!") String confirmedPassword) {
}
