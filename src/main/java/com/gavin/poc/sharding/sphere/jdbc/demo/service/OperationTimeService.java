package com.gavin.poc.sharding.sphere.jdbc.demo.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gavin.poc.sharding.sphere.jdbc.common.base.BaseResponse;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author Gavin
 */
public interface OperationTimeService extends IService<OperationTime> {

    /**
     * 插入
     * @param vo
     * @return
     */
    BaseResponse insert(OperationTime vo);
    
    
    List<OperationTime> selectByThingId(Map<String, Object> map);
    
	Map<String, Object> selectByParams(Map<String, Object> map);
}
