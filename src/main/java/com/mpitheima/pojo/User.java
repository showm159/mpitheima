package com.mpitheima.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName(value = "tbl_user")
public class User {
    private Long id;
    private String name;
    @TableField(value = "pwd",select = false)
    private String password;
    private Integer age;
    private String tel;
    @TableField(exist = false)
    private Integer online;
    //逻辑删除字段，标记当前字段是否被删除
    @TableField(value = "is_delete",select = false)
    //value = "0" sql语句后面条件的追加
    //delval = "1" delete这条sql语句后面的追加
    @TableLogic(value = "0",delval = "1")
    private Integer delete;
    //实现乐观锁
    @Version
    private Integer version;
}