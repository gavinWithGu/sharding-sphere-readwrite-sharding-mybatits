package com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gavin.poc.sharding.sphere.jdbc.common.base.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author OperationTime
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("operation_time")
@ApiModel(value = "", description = "")
@ToString
public class OperationTime extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("count")
    private int count;

    @ApiModelProperty("power")
    private int power;
    
    @ApiModelProperty("expansion_valve")
    private int expansionValve;

    @ApiModelProperty("created_at")
    private Date createdAt;

    @ApiModelProperty("thing_id")
    private String thingId;
    
    @ApiModelProperty("unit_id")
    private String unitId;
    
//    @ApiModelProperty("unit_id_count")
//    private long unitIdCount;
}
