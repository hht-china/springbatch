package com.example.demo.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author hongtao.hao
 * @date 2019/6/27
 */
@Getter
@Setter
//@NotBlank
public class UserForm {

    @NotBlank(message="用户名不能为空")
    private String username;

    @NotBlank(message="密码不能为空")
    private String password;

    @NotBlank(message="邮箱不能为空")
    private String email;

    @NotBlank(message="手机不能为空")
    private String mobile;
}
