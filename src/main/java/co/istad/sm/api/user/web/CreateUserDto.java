package co.istad.sm.api.user.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CreateUserDto(@NotBlank(message = "First name is required!") String firstName,
                            @NotBlank(message = "Last name is required!") String lastName,
                            @NotBlank(message = "Gender is required!") String gender,
                            @NotNull Date dob,
                            @NotBlank(message = "Place of birth is required!") String pob,
                            @NotBlank(message = "Current address is required!") String currentAddress,
                            @NotBlank(message = "Email is required!") String email,
                            @NotBlank(message = "Phone number is required!") String phoneNumber,
                            @NotBlank String photoUrl,
                            @NotBlank(message = "Education is required!") String education) {
}
