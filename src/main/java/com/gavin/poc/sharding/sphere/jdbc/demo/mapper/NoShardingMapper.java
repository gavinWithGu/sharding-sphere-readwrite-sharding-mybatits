package com.gavin.poc.sharding.sphere.jdbc.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.NoShardingTable;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author Gavin
 */
@Mapper
public interface NoShardingMapper extends BaseMapper<NoShardingTable> {

}
