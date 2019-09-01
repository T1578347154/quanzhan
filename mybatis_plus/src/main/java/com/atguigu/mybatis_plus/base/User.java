package com.atguigu.mybatis_plus.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
   //  @TableId(type=IdType.AUTO)//主键自增   mysql勾选自增
     @TableId(type = IdType.AUTO)
     private Long id;
    private String name;
    private Integer age ;
    private String  email;
    // 在需要自动的字段 加上 下面的注解 添加业务 更新时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // 在需要自动的字段 加上 下面的注解 更新业务 也 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
   //逻辑删除
    @TableLogic
    private Integer deleted;

}
