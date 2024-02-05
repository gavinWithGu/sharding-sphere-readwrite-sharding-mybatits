package com.gavin.poc.sharding.sphere.jdbc.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.poc.sharding.sphere.jdbc.common.base.BaseResponse;
import com.gavin.poc.sharding.sphere.jdbc.common.response.SystemResponse;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.User;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.vo.UserVo;
import com.gavin.poc.sharding.sphere.jdbc.demo.mapper.UserMapper;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.UserService;

import cn.hutool.core.bean.BeanUtil;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author Gavin
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public BaseResponse insert(UserVo vo) {
        User user = BeanUtil.copyProperties(vo, User.class);
        boolean save = save(user);
        if (save){
            return SystemResponse.success("插入成功");
        }
        return SystemResponse.fail("插入失败");
    }
}
