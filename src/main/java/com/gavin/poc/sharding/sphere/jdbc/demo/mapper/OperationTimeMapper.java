package com.gavin.poc.sharding.sphere.jdbc.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author Gavin
 */
@Mapper
public interface OperationTimeMapper extends BaseMapper<OperationTime> {
	Map<String, Object> selectByParams(Map<String, Object> map);
	
	List<OperationTime> selectByThingId(Map<String, Object> map);
}
