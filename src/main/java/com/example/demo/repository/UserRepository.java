package com.example.demo.repository;

import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserInfoExample;
import com.example.demo.mapper.UserInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hongtao.hao
 * @date 2019/6/27
 */
@Repository
public class UserRepository {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> listUser() {
        UserInfoExample example = new UserInfoExample();
        return userInfoMapper.selectByExample(example);
    }

    public PageInfo<UserInfo>  listPageUser(Integer start,Integer offset) {
        UserInfoExample example = new UserInfoExample();
        PageHelper.startPage(start,offset);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos);

        return pageInfo;
    }

    public UserInfo getUserByName(String userName) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(userName);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(userInfos) ? null : userInfos.get(0);
    }


}
