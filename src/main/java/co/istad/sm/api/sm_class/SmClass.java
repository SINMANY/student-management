package co.istad.sm.api.sm_class;

import co.istad.sm.api.course.Course;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SmClass {

    private Integer id;

    private String shift;

    private String startTime;

    private String endTime;

    private Boolean isDeleted;

    private Boolean isWeekend;

    private List<Course> courses;
}
