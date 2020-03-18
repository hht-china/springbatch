package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongtao.hao
 * @date 2019/6/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> listUser() {
        List<UserInfo> userInfos = userRepository.listUser();
        return userInfos2UserDTOs(userInfos);
    }

    @Override
    public PageInfo listPageUser(Integer start,Integer offset) {

        return userRepository.listPageUser(start,offset);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        return;
    }

    @Override
    public UserDTO getUser(@NotBlank String userName) {
        UserInfo userInfo = userRepository.getUserByName(userName);
        return userInfo2UserDTO(userInfo);
    }

    private UserDTO userInfo2UserDTO(UserInfo userInfo){
        if(userInfo == null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userInfo , userDTO);
        return userDTO;
    }

    private List<UserDTO> userInfos2UserDTOs(List<UserInfo>  userInfos){
        if(CollectionUtils.isEmpty(userInfos)){
            return null;
        }
        List<UserDTO> userDTOS = new ArrayList<>();
        UserDTO userDTO ;
        for (UserInfo userInfo : userInfos){
            userDTO = new UserDTO();
            BeanUtils.copyProperties(userInfo , userDTO);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
}
