package com.gavin.poc.sharding.sphere.jdbc.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gavin.poc.sharding.sphere.jdbc.common.base.BaseResponse;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.NoShardingTable;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.vo.NoShardingVo;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author Gavin
 */
public interface NoShardingService extends IService<NoShardingTable> {


    /**
     * 插入
     * @param vo
     * @return
     */
    BaseResponse insert(NoShardingVo vo);
}
