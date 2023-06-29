package com.gxh.system.controller;

import com.gxh.system.entity.Teacher;
import com.gxh.system.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author gxh
 * @since 2023-06-29
 */
@RestController
@Tag(name = "讲师模块")
@RequestMapping("/education/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Operation(summary = "讲师列表")
    @GetMapping("/findAll")
    public List<Teacher> findAll() {
        return teacherService.list();
    }

    @Operation(summary = "通过id逻辑删除讲师")
    @Parameters({
            @Parameter(name = "id", description = "讲师id", in = ParameterIn.PATH)
    })
    @DeleteMapping("{id}")
    public boolean removeTeacher(@PathVariable String id) {
        return teacherService.removeById(id);
    }
}

