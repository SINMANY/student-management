package istad.co.sm.api.user.web;

import java.util.Date;

public record UserDto(String firstName,
                      String lastName,
                      String gender,
                      Date dob,
                      String pob) {
}
