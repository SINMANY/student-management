package co.istad.sm.api.user.web;

import java.util.Date;

public record UserDto(String firstName,
                      String lastName,
                      String gender,
                      Date dob,
                      String email,
                      String phoneNumber,
                      Boolean isDeleted,
                      String education) {
}
