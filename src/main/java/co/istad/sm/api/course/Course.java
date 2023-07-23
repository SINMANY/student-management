package co.istad.sm.api.course;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Course {

    private Integer id;

    private String name;

    private String description;

    private Float fee;

    private Integer hour;

    private String level;

    private Boolean isDeleted;
}
