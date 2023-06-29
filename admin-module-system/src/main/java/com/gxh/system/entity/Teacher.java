package com.gxh.system.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author gxh
 * @since 2023-06-29
 */
@Getter
@Setter
@TableName("edu_teacher")
@Schema(name = "Teacher对象", description = "讲师")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name = "讲师ID")
    private String id;

    @Schema(name = "讲师姓名")
    private String name;

    @Schema(name = "讲师简介")
    private String intro;

    @Schema(name = "讲师资历,一句话说明讲师")
    private String career;

    @Schema(name = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @Schema(name = "讲师头像")
    private String avatar;

    @Schema(name = "排序")
    private Integer sort;

    @Schema(name = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Byte isDeleted;

    @Schema(name = "创建时间")
    private Date gmtCreate;

    @Schema(name = "更新时间")
    private Date gmtModified;
}
