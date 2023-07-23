package co.istad.sm.api.user;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String gender;

    private Date dob;

    private String pob;

    private String currentAddress;

    private String email;

    private String phoneNumber;

    private Boolean isDeleted;

    private String photoUrl;

    private String education;
}
