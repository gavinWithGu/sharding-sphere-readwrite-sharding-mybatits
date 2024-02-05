package com.gavin.poc.sharding.sphere.jdbc.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.poc.sharding.sphere.jdbc.common.base.BaseResponse;
import com.gavin.poc.sharding.sphere.jdbc.common.response.SystemResponse;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.NoShardingTable;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.User;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.vo.NoShardingVo;
import com.gavin.poc.sharding.sphere.jdbc.demo.mapper.NoShardingMapper;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.NoShardingService;

import cn.hutool.core.bean.BeanUtil;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author Gavin
 */
@Service
public class NoShardingServiceImpl extends ServiceImpl<NoShardingMapper,NoShardingTable> implements NoShardingService {

	@Override
    public BaseResponse insert(NoShardingVo vo) {
		NoShardingTable user = BeanUtil.copyProperties(vo, NoShardingTable.class);
        boolean save = save(user);
        if (save){
            return SystemResponse.success("Insert success");
        }
        return SystemResponse.fail("插入失败");
    }
}
