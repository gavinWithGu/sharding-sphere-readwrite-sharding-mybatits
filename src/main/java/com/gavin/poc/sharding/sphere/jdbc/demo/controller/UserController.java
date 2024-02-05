package com.gavin.poc.sharding.sphere.jdbc.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.gavin.poc.sharding.sphere.jdbc.common.base.BaseResponse;
import com.gavin.poc.sharding.sphere.jdbc.common.response.SystemResponse;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.vo.UserVo;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.UserService;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author Gavin
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/insert")
    public BaseResponse insert(@RequestBody UserVo vo){
        return userService.insert(vo);
    }

    @GetMapping("/query")
    public BaseResponse query(){
        return SystemResponse.success(userService.list());
    }


}
