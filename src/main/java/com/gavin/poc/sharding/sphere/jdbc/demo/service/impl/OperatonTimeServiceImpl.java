package com.gavin.poc.sharding.sphere.jdbc.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.poc.sharding.sphere.jdbc.common.base.BaseResponse;
import com.gavin.poc.sharding.sphere.jdbc.common.response.SystemResponse;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;
import com.gavin.poc.sharding.sphere.jdbc.demo.mapper.OperationTimeMapper;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.OperationTimeService;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author Gavin
 */
@Service
public class OperatonTimeServiceImpl extends ServiceImpl<OperationTimeMapper, OperationTime> implements OperationTimeService {
  
	@Autowired
	private OperationTimeMapper operationTimeMapper;

	@Override
	public BaseResponse insert(OperationTime vo) {
		 boolean save = save(vo);
	        if (save){
	            return SystemResponse.success("插入成功");
	        }
	        return SystemResponse.fail("插入失败");
	}

	@Override
	public Map<String, Object> selectByParams(Map<String, Object> map) {
		Map<String, Object> selectByParams = operationTimeMapper.selectByParams(map);
		return selectByParams;
	}

	@Override
	public List<OperationTime> selectByThingId(Map<String, Object> map) {
		List<OperationTime> selectByThingId = operationTimeMapper.selectByThingId(map);
		return selectByThingId;
	}
    
    
}
