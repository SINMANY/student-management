package co.istad.sm.api.sm_class;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClassMapper {

    @InsertProvider(type = ClassProvider.class, method = "buildAddNewCourseSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("c") SmClass smClass);
}
