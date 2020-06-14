package com.yf.service.impl;

import com.yf.entity.TUser;
import com.yf.mapper.TUserMapper;
import com.yf.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;
    @Override
    public TUser getUserById(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }
}
