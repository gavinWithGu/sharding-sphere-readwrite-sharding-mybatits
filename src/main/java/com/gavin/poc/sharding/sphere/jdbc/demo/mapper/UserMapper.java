package com.gavin.poc.sharding.sphere.jdbc.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.User;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author Gavin
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
