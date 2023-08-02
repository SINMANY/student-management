package co.istad.sm.api.sm_class.web.validator;

import co.istad.sm.api.user.UserMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClassIdConstrainsValidator implements ConstraintValidator<ClassIdConstrains, List<Integer>> {
    private final UserMapper userMapper;
    @Override
    public boolean isValid(List<Integer> classIds, ConstraintValidatorContext context) {
        for (Integer classId : classIds){
            if (userMapper.checkClassId(classId)) {
                return false;
            }
        }
        return true;
    }
}
