package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author hongtao.hao
 * @date 2019/6/27
 */
public interface UserService {
    List<UserDTO> listUser();

    PageInfo listPageUser(Integer start,Integer offset);

    void saveUser(UserDTO userDTO);


    UserDTO getUser(@NotBlank String userName);
}
