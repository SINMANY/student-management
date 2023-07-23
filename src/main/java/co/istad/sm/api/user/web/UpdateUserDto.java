package co.istad.sm.api.user.web;

import java.util.Date;

public record UpdateUserDto(String firstName,
                            String lastName,
                            String gender,
                            Date dob) {
}
