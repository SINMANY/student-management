package co.istad.sm.api.sm_class;

import co.istad.sm.api.course.Course;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SmClass implements GrantedAuthority {

    private Integer id;

    private String shift;

    private String startTime;

    private String endTime;

    private Boolean isDeleted;

    private Boolean isWeekend;

//    private Set<Course> courses;

    @Override
    public String getAuthority() {
        return "SMCLASS_"+ shift;
    }
}

//import lombok.*;
//        import org.springframework.security.core.GrantedAuthority;
//
//        import java.util.Set;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Role implements GrantedAuthority {
//    private Integer id;
//    private String name;
//    private Set<Authority> authorities;
//
//    @Override
//    public String getAuthority() {
//        return "ROLE_"+ name; // spring need require prefix ROLE_
//    }
//}
